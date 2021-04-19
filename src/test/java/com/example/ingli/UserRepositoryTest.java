package com.example.ingli;

import com.example.ingli.Controller.model.Article;
import com.example.ingli.Controller.model.User;
import com.example.ingli.dao.UserDAOImpl;
import com.example.ingli.dao.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDAOImpl userDAO;

    @Test
    void saveUserTest() {
        User user = new User();
        user.setFirstName("name");
        user.setLastName("lastName");
        userRepository.save(user);
    }

    @Test
    void findUserByFirstNameTest() {
        User oleksandr = userRepository.findUserByFirstName("Oleksandr");
        System.out.println(oleksandr.getFirstName() + oleksandr.getLastName());
    }

    @Test
    void findUserByFirstNameLikeTest() {
        User oleksandr = userRepository.findUserByFirstNameLike("leks");
        System.out.println(oleksandr.getFirstName() + oleksandr.getLastName());
    }

    @Test
    void getUserWithDetailsTest() {
        //    in db I have User: Oleksandr Kirieiev id=9 and age = 50.
        User oleksandr = userDAO.getUserWithDetails(9L);
        System.out.println(oleksandr.getFirstName() + oleksandr.getLastName());
        System.out.println(oleksandr.getUserDetail().getAge());
        Assertions.assertEquals(50, (int) oleksandr.getUserDetail().getAge());
    }

    @Test
    void getUserByIdTest() {
        User user = userRepository.findById(9L).orElse(null);
        assert user != null;
        Assertions.assertEquals("Oleksandr", user.getFirstName());
    }

}
