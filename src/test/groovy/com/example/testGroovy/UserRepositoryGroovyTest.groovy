package com.example.testGroovy

import com.example.Controller.model.Article
import com.example.Controller.model.User
import com.example.dao.ArticleRepository
import com.example.dao.UserDAOImpl
import com.example.dao.UserRepository
import com.example.datafactory.Creator
import com.example.datafactory.UserTestDataFactory
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Import([UserTestDataFactory.class, Creator.class])
@Import([UserTestDataFactory.class, UserDAOImpl.class, Creator.class])
class UserRepositoryGroovyTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserTestDataFactory userTestDataFactory;

    @Autowired
    UserDAOImpl userDAO;

    @Test
    void saveUserTest() {
        User user = new User(firstName: "Test Name");
        userTestDataFactory.saveUserWithDetails(user);

        User userInDb = userRepository.findById(user.getId()).get();
        Assertions.assertTrue(userInDb.getFirstName() == "Test Name")
    }

    @Test
    void getUserWithDetailsTest() {
        User user = new User(firstName: "Test Name");
        userTestDataFactory.saveUserWithDetails(user);

        User userInDb = userDAO.getUserWithDetails(user.getId());
        Assertions.assertTrue(userInDb.getFirstName() == "Test Name")
    }

    @Test
    void getUserByNameLikeTest() {
        userTestDataFactory.saveUser();

        User userInDb = userRepository.findUserByFirstNameLike("est");
        Assertions.assertTrue(userInDb.getFirstName() == "Test Name")
    }

    @Test
    void getUserByNameTest() {
        User user = userTestDataFactory.saveUser();

        User userInDb = userRepository.findUserByFirstNameLike(user.getFirstName());
        Assertions.assertTrue(userInDb.getFirstName() == user.getFirstName())
    }
}