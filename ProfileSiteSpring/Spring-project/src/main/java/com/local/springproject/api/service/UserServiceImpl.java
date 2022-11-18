package com.local.springproject.api.service;

import com.local.springproject.JPA.UserRepository;
import com.local.springproject.User.UserClass;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserClass> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserClass> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public UserClass saveUser(UserClass userClass) {
        return userRepository.save(userClass);
    }

    @Override
    public UserClass updateUser(UserClass userClass) {
        return userRepository.save(userClass);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
