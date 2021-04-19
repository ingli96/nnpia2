package com.example.ingli.Service;

import com.example.ingli.Controller.model.User;
import com.example.ingli.Controller.model.UserDetail;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends CrudService<User> {

    public User getByIdWithDetail(Long id);

    public UserDetail createUserDetail(UserDetail object);

    public UserDetail updateUserDetail(UserDetail object);
}
