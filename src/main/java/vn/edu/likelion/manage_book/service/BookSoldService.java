package vn.edu.likelion.manage_book.service;


import vn.edu.likelion.manage_book.entity.BookEntity;
import vn.edu.likelion.manage_book.entity.BookSoldEntity;

import java.util.List;

public interface BookSoldService extends BaseService<BookSoldEntity> {

    List<BookSoldEntity> sortBookSoldQuantity();

    List<BookSoldEntity> find5BookBestSeller();

    List<BookSoldEntity> findBookSoldPagination(int pageNo) ;
}
