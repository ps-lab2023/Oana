package com.proiectps.airport.service;

import com.proiectps.airport.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    User findByName(String name);
    User updateUser(User user);
    void deleteByNameUser(User user);

    long logIn(String name, String password);
}
