package vn.edu.likelion.manage_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.manage_book.entity.BookEntity;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    BookEntity findByName(String name);

    @Query(value = "SELECT * " +
            " FROM BOOKS " +
            " ORDER BY ID " +
            " OFFSET ?1 ROWS FETCH NEXT ?2 ROWS ONLY",nativeQuery = true)
    List<BookEntity> listBookPagination(int page, int size);
}
