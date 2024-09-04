package com.api.facturacion.controllers;

import com.api.facturacion.entities.User;
import com.api.facturacion.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable long id) {
        return userService.getById(id);
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping("/user")
    public void editUser(@RequestBody User user) {
        userService.save(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.delete(id);
    }
}
