package vn.edu.likelion.manage_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.manage_book.entity.UserEntity;
import vn.edu.likelion.manage_book.model.request.UserRequest;
import vn.edu.likelion.manage_book.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity addUser(@RequestBody UserRequest user) {

        UserEntity userEntity = new UserEntity(user.getUsername(), user.getPassword());

        UserEntity newUser = userService.create(userEntity);

        if(newUser != null) {
            return ResponseEntity.ok(newUser);
        }

        return ResponseEntity.badRequest().body("User has been created");
    }

    @GetMapping("/login")
    public ResponseEntity login(@RequestBody UserRequest user) {

        return ResponseEntity.ok(userService.login(user.getUsername(), user.getPassword()));
    }
}
