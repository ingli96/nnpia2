package com.example.Controller;

import com.example.Controller.model.User;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping( "users")
    public String getAll(Model model) {
        List<User> userList = userService.getAll();
        model.addAttribute("users", userList);
        return "user-list";
    }

//    @GetMapping("users/{id}")
//    public String getDetails(@PathVariable("id") Long id, Model model) {
//        User user = userService.getByIdWithDetail(id);
//        model.addAttribute("user", user);
//        return "user-detail";
//    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.create(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.update(user);
        return "redirect:/users";
    }

}