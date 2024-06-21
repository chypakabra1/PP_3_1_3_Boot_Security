package ru.kata.spring.boot_security.demo.dao;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;


public interface UserDao {

    List<User> getAllUsers();

    User getUser(Long id);

    void saveUser(User user);

    void updateUser(User user, Long id);

    void deleteUser(Long id);
}
