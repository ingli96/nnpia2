package com.example.ingli.datafactory;

import com.example.ingli.Controller.model.User;
import com.example.ingli.dao.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTestDataFactory {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUserTest() {
        User user = new User();
        user.setFirstName("name");
        user.setLastName("lastName");
        userRepository.save(user);
    }

}
