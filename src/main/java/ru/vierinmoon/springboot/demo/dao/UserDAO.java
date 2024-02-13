package ru.vierinmoon.springboot.demo.dao;

import ru.vierinmoon.springboot.demo.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void addUser(User user);
    void removeUserById(Long id);
    User getUserById(Long id);
    void updateUser(User user);
}
