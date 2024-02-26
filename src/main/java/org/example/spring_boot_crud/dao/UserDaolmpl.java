package org.example.spring_boot_crud.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.spring_boot_crud.models.User;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaolmpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user ", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int userId) {
        entityManager.remove(entityManager.find(User.class, userId));
    }

    @Override
    public void updateUser(int id, User userUpdate) {
        User user = getUser(id);
        user.setName(userUpdate.getName());
        user.setAge(userUpdate.getAge());
        user.setEmail(userUpdate.getEmail());
        entityManager.merge(user);
    }

    @Override
    public User getUser(int userId) {
        return entityManager.find(User.class, userId);
    }
}
