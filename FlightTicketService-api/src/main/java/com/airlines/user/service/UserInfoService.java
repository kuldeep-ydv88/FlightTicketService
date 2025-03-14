package com.airlines.user.service;

import com.airlines.user.dto.ChangePasswordRequestDTO;
import com.airlines.user.dto.UserInfoDto;
import com.airlines.user.entity.UserInfo;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserInfoService implements UserDetailsService {
    private final MongoTemplate mongoTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
        return user;
    }

    public UserInfo findByEmail(String email) {
        Criteria criteria = Criteria.where("email").is(email);
        Query query = Query.query(criteria);
        return mongoTemplate.findOne(query, UserInfo.class);
    }

    public List<UserInfo> findAll() {
        return mongoTemplate.findAll(UserInfo.class);
    }

    public UserInfo save(UserInfo userInfo) {
        return mongoTemplate.save(userInfo);
    }

    public UserInfoDto getUserDetails(String id) {
        UserInfo userInfo = mongoTemplate.findById(id, UserInfo.class);
        UserInfoDto userInfoDto = new UserInfoDto();
        if (Objects.nonNull(userInfo)) {
            userInfoDto.setFirstName(userInfo.getFirstName());
            userInfoDto.setLastName(userInfo.getLastName());
            userInfoDto.setUsername(userInfo.getUsername());
            userInfoDto.setEmail(userInfo.getEmail());
            userInfoDto.setPhone(userInfo.getContactNumber());
            userInfoDto.setGender(userInfo.getGender());
            userInfoDto.setDob(userInfo.getDateOfBirth());
        }
        return userInfoDto;
    }

    public UserInfoDto updateUserDetails(UserInfoDto userInfoDto, String id) {
        UserInfo userInfo = mongoTemplate.findById(id, UserInfo.class);
        if (Objects.nonNull(userInfo)) {
            if (StringUtils.isNotEmpty(userInfoDto.getFirstName())) {
                userInfo.setFirstName(userInfoDto.getFirstName());
            }
            if (StringUtils.isNotEmpty(userInfoDto.getLastName())){
                userInfo.setLastName(userInfo.getLastName());
            }
            if (StringUtils.isNotEmpty(userInfoDto.getEmail())) {
                userInfo.setEmail(userInfoDto.getEmail());
            }
            if (StringUtils.isNotEmpty(userInfoDto.getPhone())) {
                userInfo.setContactNumber(userInfoDto.getPhone());
            }
            if (StringUtils.isNotEmpty(userInfoDto.getGender())) {
                userInfo.setGender(userInfoDto.getGender());
            }
            if (StringUtils.isNotEmpty(String.valueOf(userInfoDto.getDob()))) {
                userInfo.setDateOfBirth(userInfoDto.getDob());
            }
            mongoTemplate.save(userInfo);
        }
        return userInfoDto;
    }

    public UserInfo findById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, UserInfo.class);
    }

    public boolean changePassword(ChangePasswordRequestDTO requestPayload) {
        return true;
    }

}
