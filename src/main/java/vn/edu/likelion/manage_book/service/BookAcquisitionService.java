package vn.edu.likelion.manage_book.service;
import vn.edu.likelion.manage_book.entity.BookAcquisitionEntity;
import vn.edu.likelion.manage_book.model.request.BookRequest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface BookAcquisitionService extends BaseService<BookAcquisitionEntity> {
    void addBook(BookRequest book);

    List<BookAcquisitionEntity> getBooksAroundDay(LocalDate from, LocalDate to);

}
