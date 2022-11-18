package com.local.springproject.JPA;

import com.local.springproject.User.UserClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserClass, Integer> {
    Optional<UserClass> findByNameAndPassword(String name, String password);
    Optional<UserClass> findByName(String name);
}
