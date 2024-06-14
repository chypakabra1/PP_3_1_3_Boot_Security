package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {

        this.userDao = userDao;

    }

    @Override
    public List<User> index() {
        return userDao.getAllUsers();
    }

    @Override
    public User show(Long id) {
        return userDao.getUser(id);
    }

    @Transactional
    public void save(User user) {
        userDao.saveUser(user);
    }

    @Transactional
    @Override
    public void update(User user, Long id) {
        userDao.updateUser(user, id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDao.deleteUser(id);
    }
}
