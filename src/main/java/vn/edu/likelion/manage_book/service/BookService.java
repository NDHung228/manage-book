package vn.edu.likelion.manage_book.service;

import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.likelion.manage_book.entity.BookEntity;
import vn.edu.likelion.manage_book.model.request.BookRequest;

import java.util.List;


public interface BookService extends BaseService<BookEntity> {
    BookEntity findByName(String name);
    BookEntity soldBook(int bookId, @RequestParam int quantity);
    List<BookEntity> sortBooks();

    List<BookEntity> findBookPagination(int page, int size);

}
