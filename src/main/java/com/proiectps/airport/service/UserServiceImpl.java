package com.proiectps.airport.service;

import com.proiectps.airport.model.User;
import com.proiectps.airport.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    @Override
    public User findByName(String name)
    {
        return userRepository.findByName(name);
    }

    @Override
    public User updateUser(User user) {
        User updateUser = userRepository.findById(user.getId()).get();
        updateUser.setName(user.getName());
        userRepository.save(updateUser);
        return updateUser;
    }

    @Override
    public void deleteByNameUser(User user) {
        User deleteUser = userRepository.findByName(user.getName());
        userRepository.deleteById(deleteUser.getId());

    }

    public long logIn(String name, String password) {
        User userCredentials = userRepository.findByName(name);
        if(userCredentials.getPassword().equals(password))
            return userCredentials.getId();
        else return 0;
    }

}
