package ru.kata.springbooot.springboot.DAO;


import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kata.springbooot.springboot.model.User;

import java.util.List;


@Repository
public class UserDAOHibernateImpl implements UserDAO {

    private final EntityManager entityManager;

    @Autowired
    public UserDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveUser(String name, int age, String email) {

        entityManager.merge(new User(name,age,email));

    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void removeById(Long id) {

        entityManager.remove(entityManager.find(User.class, id));

    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(Long id, String name, int age, String email) {

        User user = getUserById(id);
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        entityManager.merge(user);

    }
}
