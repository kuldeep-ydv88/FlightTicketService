package com.airlines.user.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Kuldeep
 */
public interface UserService {
    UserDetails loadUserByUsername(String username);
}
