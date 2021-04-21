package com.example.ingli;

import com.example.ingli.Controller.model.User;
import com.example.ingli.dao.UserRepository;
import com.example.ingli.datafactory.UserTestDataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(UserTestDataFactory.class)
class UserRepositoryGroovyTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTestDataFactory userTestDataFactory;

    @Test
    void saveUserTest() {
        userTestDataFactory.saveUserTest();
        List<User> users = userRepository.findAll();
        Assertions.assertEquals(1, users.size());
    }
}