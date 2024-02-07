package ru.vierinmoon.springboot.SpringBoot311.dao;

import ru.vierinmoon.springboot.SpringBoot311.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void addUser(User user);
    void removeUserById(Long id);
    User getUserById(Long id);
    void updateUser(User user);
}
