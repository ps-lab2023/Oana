package com.proiectps.airport.service;

import com.proiectps.airport.model.User;
import com.proiectps.airport.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest {

    private static final String NUME = "Oana";
    private static final String NUME_UPDATE = "Mintas";
    private static final String NUME_DELETE = "Mintas";
    private static final String NUME_NOT = "Numele care nu exista";
    private static final String NUME_UPDATE_NOT = "Numele care nu exista";

    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;
    private User user;

    @BeforeEach
    void init(){
        initMocks(this);
        user=new User();
        user.setName(NUME);
        when(userRepository.findByName(NUME)).thenReturn(user);
    }


    @Test
    void givenExistingName_whenFindByName_thenFindOne() {

        userService = new UserServiceImpl(userRepository);

        User user = userService.findByName(NUME);

        assertNotNull(user);
        assertEquals(NUME, user.getName());
    }

    @Test
    void givenNonExistingName_whenFindByName_thenThrowException() {
        when(userRepository.findByName(NUME_NOT)).thenReturn(null);

        Exception exception = assertThrows(NullPointerException.class, () -> {
            userService.findByName(NUME_NOT);
        });

    }

    @Test
    void givenExistingUser_whenUpdateUserName_checkResultedName() {

        userService = new UserServiceImpl(userRepository);

        User userUpdate = userService.findByName(NUME);
        userUpdate.setName(NUME_UPDATE);
        User user = userService.updateUser(userUpdate);

        assertNotNull(user);
        assertEquals(NUME_UPDATE, user.getName());
    }


    @Test
    void deleteByName() {

        userService = new UserServiceImpl(userRepository);

        User userDelete=new User();
        userDelete=userService.findByName(NUME_DELETE);
        userService.deleteByNameUser(userDelete);

        when(userRepository.findByName(NUME_NOT)).thenReturn(null);
    }



}
