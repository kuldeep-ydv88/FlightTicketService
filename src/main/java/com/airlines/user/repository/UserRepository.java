package com.airlines.user.repository;


import com.airlines.user.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserInfo,Integer> {
    Optional<UserInfo> findByEmail(String email);
}
