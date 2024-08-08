package vn.edu.likelion.manage_book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.manage_book.entity.BookEntity;
import vn.edu.likelion.manage_book.entity.BookSoldEntity;
import vn.edu.likelion.manage_book.model.request.BookRequest;
import vn.edu.likelion.manage_book.repository.BookRepository;
import vn.edu.likelion.manage_book.service.BookAcquisitionService;
import vn.edu.likelion.manage_book.service.BookService;
import vn.edu.likelion.manage_book.service.BookSoldService;

import java.util.*;

@Service
public class BookImpl implements BookService {

    // other service
    @Autowired
    private BookSoldService bookSoldService;

    // repository
    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookEntity create(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    @Override
    public BookEntity update(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    @Override
    public void delete(BookEntity bookEntity) {
       bookEntity = bookRepository.findByName(bookEntity.getName());
       if (bookEntity == null) {
           return;
       }
        bookEntity.setDeleted(true);
        bookEntity.setUpdateTime(new Date());
        bookRepository.save(bookEntity);
    }

    @Override
    public Iterator<BookEntity> findAll() {
        return bookRepository.findAll().iterator();
    }

    @Override
    public Optional<BookEntity> findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public BookEntity findByName(String name) {
        return bookRepository.findByName(name);
    }

    @Override
    public BookEntity soldBook(int bookId, int quantity) {
        BookEntity bookEntity = findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        if(bookEntity == null) return null;

        BookSoldEntity bookSoldEntity = new BookSoldEntity();
        bookSoldEntity.setQuantity(quantity);
        bookSoldEntity.setBookId(bookId);
        bookSoldEntity.setCreateTime(new Date());
        bookSoldService.create(bookSoldEntity);

        bookEntity.setQuantity(bookEntity.getQuantity() - quantity);
        return bookRepository.save(bookEntity);

    }

    @Override
    public List<BookEntity> sortBooks() {
        List<BookEntity> books = bookRepository.findAll();

        books.sort(Comparator.comparing(BookEntity::getPrice).reversed());
        return books;
    }

    @Override
    public List<BookEntity> findBookPagination(int page, int size) {
        return bookRepository.listBookPagination(page,size);
    }


}
