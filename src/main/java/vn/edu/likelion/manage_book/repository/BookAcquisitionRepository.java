package vn.edu.likelion.manage_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.manage_book.entity.BookAcquisitionEntity;

@Repository
public interface BookAcquisitionRepository extends JpaRepository<BookAcquisitionEntity,Integer> {
}
