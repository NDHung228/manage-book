package vn.edu.likelion.manage_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.manage_book.entity.BookAcquisitionEntity;
import vn.edu.likelion.manage_book.entity.BookEntity;
import vn.edu.likelion.manage_book.entity.BookSoldEntity;
import vn.edu.likelion.manage_book.model.request.BookRequest;
import vn.edu.likelion.manage_book.service.BookAcquisitionService;
import vn.edu.likelion.manage_book.service.BookService;
import vn.edu.likelion.manage_book.service.BookSoldService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookSoldService bookSoldService;

    @Autowired
    private BookAcquisitionService bookAcquisitionService;


    @GetMapping("get-books-pagination")
    public List<BookEntity> getAllBooks(@RequestParam int page, @RequestParam int size) {
        return bookService.findBookPagination(page,size);
    }

    @PostMapping
    public ResponseEntity addBook(@RequestBody BookRequest book) {
        bookAcquisitionService.addBook(book);

        return ResponseEntity.status(HttpStatus.OK).body("Add book success");
    }

    @PutMapping("update-book")
    public ResponseEntity updateBook(@RequestBody BookEntity book) {
        BookEntity result = bookService.update(book);

        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Update book failed");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Update book success");
    }

    @DeleteMapping()
    public ResponseEntity deleteBook(@RequestBody BookEntity book) {
        bookService.delete(book);
        return ResponseEntity.status(HttpStatus.OK).body("Delete book success");
    }

    @GetMapping()
    public BookEntity getBook(@RequestParam(required = false) Integer id, @RequestParam(required = false) String name) {
        if (id != null) {
            return bookService.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        }
        return bookService.findByName(name);
    }

    @GetMapping("/sold-book")
    public BookEntity soldBook(@RequestParam int bookId, @RequestParam int quantity) {
        return bookService.soldBook(bookId, quantity);
    }

    @GetMapping("/sort-book-price")
    public List<BookEntity> getBooksSort() {
        return bookService.sortBooks();
    }

    @GetMapping("/sort-book-sold-quantity")
    public List<BookSoldEntity> getBooksSoldQuantity() {
        return bookSoldService.sortBookSoldQuantity();
    }

    @GetMapping("/find-book-around-days")
    public List<BookAcquisitionEntity> findBooksAroundDays(@RequestParam LocalDate fromDate, @RequestParam LocalDate toDate) {
        return bookAcquisitionService.getBooksAroundDay(fromDate, toDate);
    }

    @GetMapping("/find-5-books-best-sellers")
    public List<BookSoldEntity> find5BooksBestSellers() {
        return bookSoldService.find5BookBestSeller();
    }


    @GetMapping("find-book-sold")
    public List<BookSoldEntity> findBooksSold(@RequestParam int page) {
        List<BookSoldEntity> books = new ArrayList<>();
        bookSoldService.findAll().forEachRemaining(books::add);
        return books;
    }
}
