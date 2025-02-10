package com.airlines.security;

import com.airlines.exception.InvalidCredentialsException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Objects;

@Component
@Log4j2
public class JwtTokenValidator {

    @Value("${security.secret.salt}")
    private String signingKey;
    private Key getSigningKey() {
        return new SecretKeySpec(signingKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
    }

    public void validate(String jwtToken) {
        try {
            Jws<Claims> jwt = parseJwt(jwtToken);
            if (!StringUtils.hasText(jwt.getBody().getSubject())
                    || Boolean.parseBoolean(Objects.toString(jwt.getBody().get("isRefreshToken")))) {
                throw new InvalidCredentialsException(
                        "Provided Token is not valid. Help: Check if token is expired or tampered",
                        HttpStatus.UNAUTHORIZED.value()
                );
            }
        } catch (Exception e) {
            throw new InvalidCredentialsException("Could not validate JSON Token", e, HttpStatus.UNAUTHORIZED.value()
            );
        }
    }

    public Jws<Claims> parseJwt(String jwtToken) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(jwtToken);
    }
}
