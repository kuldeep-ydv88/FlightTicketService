package com.airlines.security;

import com.airlines.common.constant.Constant;
import com.airlines.common.constant.MessageConstant;
import com.airlines.security.certificates.SecurityCertificatesManager;
import com.airlines.user.entity.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.util.function.Function;

/**
 * creating utils class for generating and validating tokens.
 */
@Component
@Slf4j
public class JwtTokenGenerator {

    private final SecurityCertificatesManager securityCertificatesManager;

    @Value("${security.token.expires}")
    private int tokenExpiryInMinutes;

    public JwtTokenGenerator(final SecurityCertificatesManager securityCertificatesManager) {
        this.securityCertificatesManager = securityCertificatesManager;
    }

    public String generate(UserInfo userInfo, boolean isRefreshToken) throws NoSuchAlgorithmException, InvalidKeySpecException {
        Instant now = Instant.now();
        log.info("Generating security tokens");
        return isRefreshToken ? Jwts.builder()
                .claim("isRefreshToken", true)
                .signWith(securityCertificatesManager.getPrivateKey())
                .setSubject(userInfo.getUsername())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(tokenExpiryInMinutes, ChronoUnit.MINUTES)))
                .compact()

                : Jwts.builder()
                .signWith(securityCertificatesManager.getPrivateKey())
                .claim(Constant.USERNAME, userInfo.getUsername())
                .claim(Constant.ROLE, userInfo.getAuthorities())
                .claim("isRefreshToken", false)
                .setSubject(userInfo.getUsername())
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(tokenExpiryInMinutes, ChronoUnit.MINUTES)))
                .compact();
    }
}