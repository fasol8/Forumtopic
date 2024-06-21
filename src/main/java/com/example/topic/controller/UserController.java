package com.example.topic.controller;

import com.example.topic.domain.user.User;
import com.example.topic.domain.user.UserData;
import com.example.topic.domain.user.UserService;
import com.example.topic.infra.security.JwtUtil;
import com.example.topic.infra.security.LoginData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@SecurityRequirement(name = "bearer-key")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Operation(summary = "Register a new user")
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserData userData) {
        userService.registerUser(userData);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully.");
    }

    @Operation(summary = "List all users")
    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Login a user")
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody @Valid LoginData loginData) {
        User user = userService.validateUser(loginData.getMail(), loginData.getPassword());
        if (user != null) {
            String token = jwtUtil.generateToken(user.getMail());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
    }
}
