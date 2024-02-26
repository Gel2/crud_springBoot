package org.example.spring_boot_crud.service;



import org.example.spring_boot_crud.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser(int userId);
    void updateUser(int id, User user);
    User getUser(int userId);
}
