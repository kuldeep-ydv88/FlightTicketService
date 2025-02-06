package com.airlines.user.service;

import com.airlines.user.dto.ChangePasswordRequestDTO;
import com.airlines.user.dto.UserInfoDto;
import com.airlines.user.entity.UserInfo;
import com.airlines.user.repository.UserRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author Kuldeep
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MongoTemplate mongoTemplate;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow();
    }

    @Override
    public List<UserInfo> findAll() {
        return mongoTemplate.findAll(UserInfo.class);
    }

    public UserInfo save(UserInfo userInfo) {
        return mongoTemplate.save(userInfo);
    }

    @Override
    public UserInfoDto getUserDetails(String id) {
        UserInfo userInfo = mongoTemplate.findById(id, UserInfo.class);
        UserInfoDto userInfoDto = new UserInfoDto();
        if (Objects.nonNull(userInfo)) {
//            userInfoDto.setFullName(userInfo.getFullName());
            userInfoDto.setUsername(userInfo.getUsername());
            userInfoDto.setEmail(userInfo.getEmail());
//            userInfoDto.setPhone(userInfo.getPhone());
//            userInfoDto.setGender(userInfo.getGender());
//            userInfoDto.setDob(userInfo.getDob());
        }
        return userInfoDto;
    }

    @Override
    public UserInfoDto updateUserDetails(UserInfoDto userInfoDto, String id) {
        UserInfo userInfo = mongoTemplate.findById(id, UserInfo.class);
        if (Objects.nonNull(userInfo)) {
            if (StringUtils.isNotEmpty(userInfoDto.getFullName())) {
//                userInfo.setFullName(userInfoDto.getFullName());
            }
            if (StringUtils.isNotEmpty(userInfoDto.getEmail())) {
                userInfo.setEmail(userInfoDto.getEmail());
            }
            if (StringUtils.isNotEmpty(userInfoDto.getPhone())) {
//                userInfo.setPhone(userInfoDto.getPhone());
            }
            if (StringUtils.isNotEmpty(userInfoDto.getGender())) {
//                userInfo.setGender(userInfoDto.getGender());
            }
            if (StringUtils.isNotEmpty(userInfoDto.getDob())) {
//                userInfo.setDob(userInfoDto.getDob());
            }
            mongoTemplate.save(userInfo);
        }
        return userInfoDto;
    }

    @Override
    public boolean changePassword(ChangePasswordRequestDTO requestPayload) {
        return false;
    }

    public UserInfo getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.nonNull(authentication)) {
            return (UserInfo) authentication.getPrincipal();
        }
        return null;
    }

    public UserInfo findById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, UserInfo.class);
    }

}
