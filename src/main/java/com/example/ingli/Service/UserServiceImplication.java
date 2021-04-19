package com.example.ingli.Service;

import com.example.ingli.Controller.User;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserServiceImplication implements UserService {

    List<User> users = new ArrayList<User>();

    public UserServiceImplication() {
        this.users.add(new User(1L, "Oleksandr", "Kirieiev"));
        this.users.add(new User(2L, "Ivan", "Petrov"));
        this.users.add(new User(3L, "Joe", "Ivanov"));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void create(User object) {
        this.users.add(object);
    }

    @Override
    public void delete(Long id) {
        this.users.remove(Math.toIntExact(id) - 1);
    }
}
