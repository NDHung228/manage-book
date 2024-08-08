package vn.edu.likelion.manage_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.manage_book.entity.BookSoldEntity;

import java.util.List;

@Repository
public interface BookSoldRepository extends JpaRepository<BookSoldEntity,Integer> {


}
