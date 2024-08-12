package com.airlines.user;

import com.airlines.user.dto.ChangePasswordRequestDTO;
import com.airlines.common.dto.APIResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public record UserInfoService(MongoTemplate mongoTemplate) implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsername(username);
    }

    public User findByUsername(String username) {
        Criteria criteria = Criteria.where("username").is(username);
        Query query = Query.query(criteria);
        return mongoTemplate.findOne(query, User.class);
    }

    public User getUserDetails(String id){
        return mongoTemplate.findById(id, User.class);
    }
    public User save(User userInfo) {
        return mongoTemplate.save(userInfo);
    }

    public APIResponseDTO changePassword(ChangePasswordRequestDTO changePasswordRequestDTO) {
        return null;
    }
    public APIResponseDTO logout() {
        return null;
    }

    public User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.nonNull(authentication)) {
            return (User) authentication.getPrincipal();
        }
        return null;
    }


}
