package vn.edu.likelion.manage_book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.manage_book.entity.BookAcquisitionEntity;
import vn.edu.likelion.manage_book.entity.BookEntity;
import vn.edu.likelion.manage_book.model.request.BookRequest;
import vn.edu.likelion.manage_book.repository.BookAcquisitionRepository;
import vn.edu.likelion.manage_book.service.BookAcquisitionService;
import vn.edu.likelion.manage_book.service.BookService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class BookAcquisitionImpl implements BookAcquisitionService {

    // other services
    @Autowired
    private BookService bookService;

    // repository
    @Autowired
    private BookAcquisitionRepository bookAcquisitionRepository;

    @Override
    public void addBook(BookRequest book) {

        BookEntity bookEntity = bookService.findByName(book.getName());

        if(bookEntity != null) {
            bookEntity.setQuantity(book.getQuantity()+bookEntity.getQuantity());
            bookEntity.setUpdateTime(new Date());
        } else {
            bookEntity = new BookEntity();
            bookEntity.setDeleted(false);
            bookEntity.setQuantity(book.getQuantity());
            bookEntity.setName(book.getName());
            bookEntity.setPrice(book.getPrice());
            bookEntity.setCreateTime(new Date());
        }
        bookEntity =bookService.create(bookEntity);

        BookAcquisitionEntity bookAcquisitionEntity = new BookAcquisitionEntity();
        bookAcquisitionEntity.setBookId(bookEntity.getId());
        bookAcquisitionEntity.setQuantity(book.getQuantity());
        bookAcquisitionEntity.setCreateTime(new Date());

        update(bookAcquisitionEntity);
    }

    @Override
    public List<BookAcquisitionEntity> getBooksAroundDay(LocalDate from, LocalDate to) {
        List<BookAcquisitionEntity> books = bookAcquisitionRepository.findAll();

        List<BookAcquisitionEntity> result = new ArrayList<BookAcquisitionEntity>();
        for (BookAcquisitionEntity book : books) {
            Date createTime = book.getCreateTime();
            if (createTime != null) {
                // Convert Date to LocalDate
                LocalDate createLocalDate = convertDateToLocalDate(createTime);

                if (!createLocalDate.isBefore(from) && !createLocalDate.isAfter(to)) {
                    result.add(book);
                }
            }
        }
        return result;
    }


    @Override
    public BookAcquisitionEntity create(BookAcquisitionEntity bookAcquisitionEntity) {
        return bookAcquisitionRepository.save(bookAcquisitionEntity);
    }

    @Override
    public BookAcquisitionEntity update(BookAcquisitionEntity bookAcquisitionEntity) {
        return bookAcquisitionRepository.save(bookAcquisitionEntity);
    }

    @Override
    public void delete(BookAcquisitionEntity bookAcquisitionEntity) {

    }

    @Override
    public Iterator<BookAcquisitionEntity> findAll() {
        return null;
    }

    @Override
    public Optional<BookAcquisitionEntity> findById(int id) {
        return Optional.empty();
    }

    private LocalDate convertDateToLocalDate(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
