package com.example.demo.adn.bbk.client.datalayer.services;

import com.example.demo.adn.bbk.client.datalayer.modal.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User updateUser(User user);

    User getUser(Integer id);

    List<User> getAllUsers();

    void deleteUser(Integer id);
}
