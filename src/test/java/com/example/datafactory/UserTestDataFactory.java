package com.example.datafactory;

import com.example.Controller.model.User;
import com.example.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.example")
public class UserTestDataFactory {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailTestDataFactory userDetailTestDataFactory;

    public User saveUser() {
        User user = new User();
        user.setFirstName("Test Name");
        userRepository.save(user);
        return user;
    }

    public User saveUserWithDetails(User user) {
        user.setUserDetail(userDetailTestDataFactory.saveUserDetail());
        userRepository.save(user);
        return user;
    }
}
