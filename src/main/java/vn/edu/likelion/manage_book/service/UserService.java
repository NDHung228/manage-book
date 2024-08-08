package vn.edu.likelion.manage_book.service;

import vn.edu.likelion.manage_book.entity.UserEntity;

public interface UserService extends BaseService<UserEntity> {

    UserEntity login(String username, String password);
}
