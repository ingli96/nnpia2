package com.example.datafactory;

import com.example.Controller.model.UserDetail;
import com.example.dao.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailTestDataFactory {

    @Autowired
    private UserDetailRepository userDetailRepository;

    public List<UserDetail> saveUserDetail() {
        List<UserDetail> details = new ArrayList<>();
        UserDetail userDetail = new UserDetail();
        userDetail.setPhone(24545465L);
        userDetailRepository.save(userDetail);
        details.add(userDetail);
        return details;
    }
}
