package com.local.springproject.api.service;

import com.local.springproject.User.UserClass;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserClass> findAllUsers();
    Optional<UserClass> findById(Integer id);
    UserClass saveUser(UserClass userClass);
    UserClass updateUser(UserClass userClass);
    void deleteUser(Integer id);
}
