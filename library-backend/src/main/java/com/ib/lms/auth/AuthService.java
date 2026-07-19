package com.ib.lms.auth;

import com.ib.lms.auth.dto.AuthResponse;
import com.ib.lms.auth.dto.LoginRequest;
import com.ib.lms.auth.dto.RegisterRequest;
import com.ib.lms.model.User;
import com.ib.lms.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Authentication Service - handles login, registration, token refresh
 * Uses userid as the primary identifier
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /**
     * Register a new user
     */
    @Transactional
    public AuthResponse register(RegisterRequest request) {
        log.info("Registering new user: {}", request.getUserid());
        if (userRepository.existsByUserid(request.getUserid())) {
            throw new AuthException("User ID already taken: " + request.getUserid());
        }
        // Create user with BCrypt encoded password
        User user = User.builder()
                .userid(request.getUserid())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(passwordEncoder.encode(request.getPassword()))
                .address(request.getAddress())
                .role(request.getRole() != null ? request.getRole() : User.Role.STUDENT)
                .enabled(true)
                .build();
        userRepository.save(user);
        log.info("User registered successfully: {}", user.getUserid());

        // Generate tokens
        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .user(AuthResponse.UserInfo.fromUser(user))
                .build();
    }

    /**
     * Authenticate user and generate tokens
     * Uses userid (not email) for authentication
     */
    public AuthResponse authenticate(LoginRequest request) {
        log.info("Authenticating user: {}", request.getUserid());

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUserid(), request.getPassword())
            );
            User user = (User) authentication.getPrincipal();
            if (!user.isEnabled()) {
                throw new BadCredentialsException("Account is disabled");
            }

            log.info("User authenticated successfully: {}", user.getUserid());
            String accessToken = jwtService.generateAccessToken(user);
            String refreshToken = jwtService.generateRefreshToken(user);

            return AuthResponse.builder()
                    .accessToken(accessToken)
                    .refreshToken(refreshToken)
                    .user(AuthResponse.UserInfo.fromUser(user))
                    .build();

        } catch (BadCredentialsException e) {
            log.warn("Invalid credentials for: {}", request.getUserid());
            throw new BadCredentialsException("Invalid user ID or password");
        }
    }

    /**
     * Refresh access token using refresh token
     */
    public AuthResponse refreshToken(String refreshToken) {
        log.debug("Refreshing access token");
        String userid = jwtService.extractUsername(refreshToken);
        if (userid == null) {
            throw new AuthException("Invalid refresh token");
        }
        User user = userRepository.findByUserid(userid)
                .orElseThrow(() -> new AuthException("User not found"));
        if (!jwtService.validateToken(refreshToken, user)) {
            throw new AuthException("Invalid or expired refresh token");
        }

        log.info("Token refreshed for: {}", user.getUserid());
        String newAccessToken = jwtService.generateAccessToken(user);
        String newRefreshToken = jwtService.generateRefreshToken(user);

        return AuthResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(newRefreshToken)
                .user(AuthResponse.UserInfo.fromUser(user))
                .build();
    }

    /**
     * Get current authenticated user from Spring Security context
     */
    public AuthResponse.UserInfo getCurrentUser(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return AuthResponse.UserInfo.fromUser(user);
    }

    /**
     * Clear auth cookies
     */
    void clearAuthCookies(HttpServletResponse response) {
        Cookie accessCookie = new Cookie("accessToken", "");
        accessCookie.setHttpOnly(true);
        accessCookie.setPath("/");
        accessCookie.setMaxAge(0);
        response.addCookie(accessCookie);

        Cookie refreshCookie = new Cookie("refreshToken", "");
        refreshCookie.setHttpOnly(true);
        refreshCookie.setPath("/api/v1/auth/refresh");
        refreshCookie.setMaxAge(0);
        response.addCookie(refreshCookie);
    }

    /**
     * Set auth tokens in HttpOnly cookies
     */
    void setAuthCookies(HttpServletResponse response, String accessToken, String refreshToken) {
        Cookie accessCookie = new Cookie("accessToken", accessToken);
        accessCookie.setHttpOnly(true);
        accessCookie.setSecure(false); // Set to true in production with HTTPS
        accessCookie.setPath("/");
        accessCookie.setMaxAge((int) (jwtService.getAccessTokenExpirationSeconds()));
        accessCookie.setAttribute("SameSite", "Lax");
        response.addCookie(accessCookie);

        Cookie refreshCookie = new Cookie("refreshToken", refreshToken);
        refreshCookie.setHttpOnly(true);
        refreshCookie.setSecure(false); // Set to true in production with HTTPS
        refreshCookie.setPath("/api/v1/auth/refresh");
        refreshCookie.setMaxAge((int) (jwtService.getRefreshTokenExpirationSeconds()));
        refreshCookie.setAttribute("SameSite", "Lax");
        response.addCookie(refreshCookie);
    }
}