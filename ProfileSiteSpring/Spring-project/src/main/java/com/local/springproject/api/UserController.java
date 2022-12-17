package com.local.springproject.api;

import com.local.springproject.User.UserClass;
import com.local.springproject.api.service.UserServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@PreAuthorize("isAuthenticated()")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Optional<UserClass> findUserById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @GetMapping
    public List<UserClass> findAllUser() {
        return userService.findAllUsers();
    }

    @PutMapping
    public UserClass updateUser (@RequestBody UserClass userClass) {
        return userService.updateUser(userClass);
    }

    @PostMapping
    public UserClass saveUser (@RequestBody UserClass userClass) {
        return userService.saveUser(userClass);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }
}
