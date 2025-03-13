package org.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.user.domain.UserDomain;
import org.user.response.UserResponse;
import org.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse<String>> createUser(@RequestBody UserDomain userDomain) {
        userService.addUser(userDomain);
        return ResponseEntity.ok(new UserResponse<>("success", "User created successfully!", null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse<UserDomain>> getUser(@PathVariable String id) {
        UserDomain userDomain = userService.getUser(id);
        if (userDomain == null) {
            return ResponseEntity.status(404).body(new UserResponse<>("error", "User not found", null));
        }
        return ResponseEntity.ok(new UserResponse<>("success", "User retrieved successfully!", userDomain));
    }
}


