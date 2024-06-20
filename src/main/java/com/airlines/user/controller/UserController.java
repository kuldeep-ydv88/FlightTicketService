package com.airlines.user.controller;

import com.airlines.login.dto.APIResponseDTO;
import com.airlines.user.entity.User;
import com.airlines.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
@Tag(name = "User", description = "the User CRUD API")
@Slf4j
@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN') ")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("")
    public APIResponseDTO updateUser(){
        return userService.updateUser();
    }

    @PostMapping("")
    public APIResponseDTO deleteUser(){
        return userService.deleteUser();

    }

    @GetMapping
    public APIResponseDTO getUserInfoById(){
        return userService.getUserInfoById();
    }

}

