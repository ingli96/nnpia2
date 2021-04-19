package com.example.ingli.Service;

import com.example.ingli.Controller.model.User;
import com.example.ingli.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImplication implements UserService{

    @Autowired
    private UserRepository userRepository;

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
        userRepository.deleteById(id);
    }
}
