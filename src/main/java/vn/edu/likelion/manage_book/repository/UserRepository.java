package vn.edu.likelion.manage_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.likelion.manage_book.entity.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsernameAndPassword(String username,String password);
    Optional<UserEntity> findByUsername(String username);
}
