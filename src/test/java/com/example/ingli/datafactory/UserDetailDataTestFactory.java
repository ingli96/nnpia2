package com.example.ingli.datafactory;

import com.example.ingli.Controller.model.User;
import com.example.ingli.Controller.model.UserDetail;
import com.example.ingli.dao.UserDetailRepository;
import com.example.ingli.dao.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDetailDataTestFactory {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Test
    public void saveUserWithDetailTest(User user) {
        UserDetail userDetail = new UserDetail();
        userDetail.setAge(24);
        userDetail.setJob("developer");
        userDetailRepository.save(userDetail);
        user.setUserDetail(userDetail);
        userRepository.save(user);
    }

}
