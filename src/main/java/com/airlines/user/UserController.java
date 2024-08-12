package com.airlines.user;

import com.airlines.user.dto.ChangePasswordRequestDTO;
import com.airlines.common.dto.APIResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("")
@Slf4j
public record UserController(UserInfoService userInfoService) {


    @Operation(summary = "change password API", description = "request contain user email")
    @PostMapping("/change-password")
    public APIResponseDTO changePassword(@RequestBody @Valid ChangePasswordRequestDTO changePasswordRequestDTO) {
        log.info("change password for the user's email : {}",changePasswordRequestDTO.getOldPassword());
        return userInfoService.changePassword(changePasswordRequestDTO);
    }

    @Operation(summary = "forget password", description = "request contain user i'd")
    @PostMapping("/logout")
    public APIResponseDTO logout() {
        return userInfoService.logout();
    }

    @GetMapping("public/users/{id}")
    public ResponseEntity<User> getUserDetails(@PathVariable("id") String id){
        return ResponseEntity.ok(userInfoService.getUserDetails(id));
    }

}
