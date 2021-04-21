package com.example.Service;

import com.example.Controller.model.User;
import com.example.Controller.model.UserDetail;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends CrudService<User> {

    public User getByIdWithDetail(Long id);

    public UserDetail createUserDetail(UserDetail object);

    public UserDetail updateUserDetail(UserDetail object);
}
