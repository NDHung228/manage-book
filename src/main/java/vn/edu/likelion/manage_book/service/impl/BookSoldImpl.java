package vn.edu.likelion.manage_book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.manage_book.entity.BookEntity;
import vn.edu.likelion.manage_book.entity.BookSoldEntity;
import vn.edu.likelion.manage_book.repository.BookSoldRepository;
import vn.edu.likelion.manage_book.service.BookSoldService;

import java.util.*;

@Service
public class BookSoldImpl implements BookSoldService {

    @Autowired
    BookSoldRepository bookSoldRepository;

    @Override
    public BookSoldEntity create(BookSoldEntity bookSoldEntity) {
       return bookSoldRepository.save(bookSoldEntity);
    }

    @Override
    public BookSoldEntity update(BookSoldEntity bookSoldEntity) {
        return null;
    }

    @Override
    public void delete(BookSoldEntity bookSoldEntity) {

    }

    @Override
    public Iterator<BookSoldEntity> findAll() {
        return bookSoldRepository.findAll().iterator();
    }

    @Override
    public Optional<BookSoldEntity> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<BookSoldEntity> sortBookSoldQuantity() {
        List<BookSoldEntity> books = bookSoldRepository.findAll();
        books.sort(Comparator.comparing(BookSoldEntity::getQuantity).reversed());
        return books;
    }

    @Override
    public List<BookSoldEntity> find5BookBestSeller() {
        List<BookSoldEntity> books = sortBookSoldQuantity();
        List<BookSoldEntity> bestSeller = new ArrayList<>();

        if(books.size()< 5) {
            bestSeller = books;
            return bestSeller;
        }

        for(int i = 0; i< 5; i++) {
            bestSeller.add(books.get(i));
        }
        return bestSeller;
    }

    @Override
    public List<BookSoldEntity> findBookSoldPagination(int pageNo) {
        return List.of();
    }
}
