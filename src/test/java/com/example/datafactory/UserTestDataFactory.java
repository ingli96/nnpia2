package com.example.datafactory;

import com.example.Controller.model.User;
import com.example.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTestDataFactory {

    @Autowired
    private UserRepository userRepository;


    public User saveUser() {
        User user = new User();
        user.setFirstName("Test Name");
        userRepository.save(user);
        return user;
    }

}
