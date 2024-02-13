package ru.vierinmoon.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vierinmoon.springboot.demo.model.User;
import ru.vierinmoon.springboot.demo.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {
    private static final String REDIRECT_USERS = "redirect:/users";

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return REDIRECT_USERS;
    }

    @GetMapping("/update")
    public String editUser(Model model, @RequestParam("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return  REDIRECT_USERS;
    }

    @PostMapping("/delete")
    public String removeUser(@RequestParam("id") Long id) {
        userService.removeUserById(id);
        return REDIRECT_USERS;
    }
}
