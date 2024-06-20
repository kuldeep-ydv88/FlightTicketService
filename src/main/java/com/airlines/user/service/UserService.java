package com.airlines.user.service;

import com.airlines.login.dto.APIResponseDTO;
import com.airlines.user.entity.User;
import com.airlines.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * This class is responsible to provide CRUD operations for user.
 * entity
 * @author kuldeep yadav
 *
 */

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public APIResponseDTO updateUser(){
        return null;
    }

    public APIResponseDTO deleteUser(){
        return null;
    }

    public APIResponseDTO getUserInfoById(){
        return null;
    }
    public User getLoggedInUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
