package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;


public interface UserService {
    List<User> index();

    User show(Long id);

    void save(User user);

    void update(User user, Long id);

    void delete(Long id);
}
