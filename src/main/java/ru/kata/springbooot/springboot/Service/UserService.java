package ru.kata.springbooot.springboot.Service;


import ru.kata.springbooot.springboot.model.User;

import java.util.List;

public interface UserService {

    void saveUser(String name, int age, String email);
    List<User> getAllUsers();
    void removeById(Long id);
    void updateUser(Long id, String name, int age, String email);
    User getUserById(Long id);
}
