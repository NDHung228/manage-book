package vn.edu.likelion.manage_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.manage_book.entity.UserEntity;
import vn.edu.likelion.manage_book.model.request.UserRequest;
import vn.edu.likelion.manage_book.security.UserInfoService;
import vn.edu.likelion.manage_book.security.jwt.JwtUtil;
import vn.edu.likelion.manage_book.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/register")
    public ResponseEntity addUser(@RequestBody UserRequest user) {

        userService.register(user.getUsername(), user.getPassword());

        return ResponseEntity.ok("Register successful");
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserRequest user) {
        UserEntity userEntity = userInfoService.authenticateUser(user.getUsername(), user.getPassword());
        if (userEntity != null) {
            String token = jwtUtil.generateToken(userEntity.getUsername());

            return  ResponseEntity.ok(token);
        }

        return ResponseEntity.badRequest().body("Login failed");
    }
}
