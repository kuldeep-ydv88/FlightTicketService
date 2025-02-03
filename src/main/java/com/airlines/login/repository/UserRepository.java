package com.airlines.login.repository;

import com.airlines.user.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserInfo,Integer> {
    Optional<UserInfo> findByEmail(String email);
}
