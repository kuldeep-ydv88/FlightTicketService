package com.airlines.security;

import com.airlines.common.constant.Constant;
import com.airlines.exception.InvalidCredentialsException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT authFilter. All the request passing from here with
 * Authorization token
 */
@Component
@Slf4j
@Order(2)
public class JwtAuthenticationFilter extends OncePerRequestFilter implements AuthenticationEntryPoint {
    private final JwtTokenValidator jwtTokenValidator;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(final JwtTokenValidator jwtTokenValidator,
                                   final UserDetailsService userDetailsService) {
        this.jwtTokenValidator = jwtTokenValidator;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwtToken = getJwtTokenFromRequest(request);
        jwtTokenValidator.validate(jwtToken);
        setAuthenticationContext(request, jwtToken);
        filterChain.doFilter(request, response);
    }

    private String getJwtTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(Constant.AUTHENTICATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(Constant.BEARER)) {
            return bearerToken.substring(7);
        }
        throw new InvalidCredentialsException("Bearer token can not be null", HttpStatus.BAD_REQUEST.value());
    }


    private void setAuthenticationContext(HttpServletRequest request, String jwtToken) {
        String username = getUserNameFromJwtToken(jwtToken);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(token);
    }

    private String getUserNameFromJwtToken(String jwtToken) {
        try {
            Jws<Claims> claims = jwtTokenValidator.parseJwt(jwtToken);
            return claims.getBody().getSubject();
        } catch (Exception e) {
            throw new InvalidCredentialsException("Failed to parse token", e, HttpStatus.UNAUTHORIZED.value());
        }
    }

    @Override
    protected boolean shouldNotFilter(final HttpServletRequest request) {
        return request.getRequestURI().startsWith("/public");
    }

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException)
            throws IOException {
        log.error("Unauthorized error: {}", authException.getMessage());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        final Map<String, Object> body = new HashMap<>();
        body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
        body.put("error", "Unauthorized");
        body.put("message", authException.getMessage());
        body.put("path", request.getServletPath());
        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), body);
    }

}
