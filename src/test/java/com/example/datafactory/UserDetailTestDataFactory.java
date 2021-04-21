package com.example.datafactory;

import com.example.Controller.model.UserDetail;
import com.example.dao.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDetailTestDataFactory {

    @Autowired
    private UserDetailRepository userDetailRepository;

    public UserDetail saveUserDetail() {
        UserDetail userDetail = new UserDetail();
        userDetail.setAge(24);
        userDetailRepository.save(userDetail);
        return userDetail;
    }
}
