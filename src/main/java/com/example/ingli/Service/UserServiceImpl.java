package com.example.ingli.Service;

import com.example.ingli.Controller.model.User;
import com.example.ingli.Controller.model.UserDetail;
import com.example.ingli.dao.UserDAOImpl;
import com.example.ingli.dao.UserDetailRepository;
import com.example.ingli.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private UserDAOImpl userDAO;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User create(User object) {
        return userRepository.save(object);
    }

    @Override
    public User update(User object) {
        return userRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        getByIdWithDetail(id).setUserDetail(null);
        userRepository.deleteById(id);
    }

    @Override
    public User getByIdWithDetail(Long id) {
        return userDAO.getUserWithDetails(id);
    }

    @Override
    public UserDetail createUserDetail(UserDetail object) {
        return userDetailRepository.save(object);
    }

    @Override
    public UserDetail updateUserDetail(UserDetail object) {
        return userDetailRepository.save(object);
    }

}
