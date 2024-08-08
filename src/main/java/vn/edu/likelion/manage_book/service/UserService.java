package vn.edu.likelion.manage_book.service;

import vn.edu.likelion.manage_book.entity.UserEntity;

public interface UserService extends BaseService<UserEntity> {

    UserEntity findByUsername(String username);

    UserEntity login(String username, String password);

    UserEntity register(String username, String password);

}
