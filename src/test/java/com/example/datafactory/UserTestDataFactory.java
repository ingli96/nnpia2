package com.example.datafactory;

import com.example.Controller.model.User;
import com.example.Controller.model.UserDetail;
import com.example.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        user.setUserDetail(new ArrayList<UserDetail>());
        userRepository.save(user);
        return user;
    }

    public User saveUserWithDetails(User user) {
        user.setUserDetail(userDetailTestDataFactory.saveUserDetail());
        userRepository.save(user);
        return user;
    }
}
