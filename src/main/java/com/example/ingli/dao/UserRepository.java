package com.example.ingli.dao;

import com.example.ingli.Controller.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByFirstName(String name);

    @Query("select u from User u where u.firstName like %:name%")
    User findUserByFirstNameLike(String name);

}
