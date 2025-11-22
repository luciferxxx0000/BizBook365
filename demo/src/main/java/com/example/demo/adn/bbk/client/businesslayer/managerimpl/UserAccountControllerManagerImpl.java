package com.example.demo.adn.bbk.client.businesslayer.managerimpl;

import com.example.demo.adn.bbk.client.businesslayer.manager.UserAccountControllerManager;
import com.example.demo.adn.bbk.client.datalayer.modal.User;
import org.springframework.stereotype.Service;

@Service
public abstract class UserAccountControllerManagerImpl implements UserAccountControllerManager {


    @Override
    public String saveUser(User user) {
        // Business Logic here
        return "User Saved Successfully";
    }
}
