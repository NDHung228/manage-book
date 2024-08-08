package vn.edu.likelion.manage_book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.manage_book.entity.UserEntity;
import vn.edu.likelion.manage_book.repository.UserRepository;
import vn.edu.likelion.manage_book.service.UserService;

import java.util.Iterator;
import java.util.Optional;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity create(UserEntity userEntity) {
        userEntity.setRole_id(1);
        return userRepository.save(userEntity);
    }




    @Override
    public UserEntity update(UserEntity userEntity) {
        return null;
    }

    @Override
    public void delete(UserEntity userEntity) {

    }

    @Override
    public Iterator<UserEntity> findAll() {
        return null;
    }

    @Override
    public Optional<UserEntity> findById(int id) {
        return Optional.empty();
    }

    @Override
    public UserEntity login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }
}
