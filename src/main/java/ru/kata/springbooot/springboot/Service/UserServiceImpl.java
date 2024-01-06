package ru.kata.springbooot.springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.springbooot.springboot.DAO.UserDAO;
import ru.kata.springbooot.springboot.model.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public void saveUser(String name, int age, String email) {
        userDAO.saveUser(name, age, email);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    @Override
    public void removeById(Long id) {
        userDAO.removeById(id);
    }

    @Transactional
    @Override
    public void updateUser(Long id, String name, int age, String email) {
        userDAO.updateUser(id, name, age, email);
    }

    @Transactional
    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }
}
