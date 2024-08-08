package vn.edu.likelion.manage_book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder encoder;

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
    public UserEntity findByUsername(String username) {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        return user.orElse(null);
    }

    @Override
    public UserEntity login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,encoder.encode(password));
    }

    @Override
    public UserEntity register(String username, String password) {
        return create(new UserEntity(username, encoder.encode(password)));
    }
}
