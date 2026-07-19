package com.ib.lms.auth;

import com.ib.lms.auth.dto.AuthResponse;
import com.ib.lms.auth.dto.LoginRequest;
import com.ib.lms.auth.dto.RegisterRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * Authentication Controller
 * Handles HTTP requests for login, register, refresh, logout, and current user endpoints
 * Delegates business logic to AuthService
 * Uses userid as the primary identifier (not email)
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    /**
     * Register a new user
     */
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request, HttpServletResponse response) {
        log.info("POST /api/v1/auth/register - UserID: {}", request.getUserid());
        AuthResponse authResponse = authService.register(request);
        authService.setAuthCookies(response, authResponse.getAccessToken(), authResponse.getRefreshToken());
        return ResponseEntity.ok(authResponse);
    }

    /**
     * Login user and return tokens
     * Uses userid for authentication
     */
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request, HttpServletResponse response) {
        log.info("POST /api/v1/auth/login - UserID: {}", request.getUserid());
        AuthResponse authResponse = authService.authenticate(request);
        authService.setAuthCookies(response, authResponse.getAccessToken(), authResponse.getRefreshToken());
        return ResponseEntity.ok(authResponse);
    }

    /**
     * Refresh access token using refresh token
     */
    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refreshToken(@CookieValue(name = "refreshToken", required = false) String refreshToken, HttpServletResponse response) {
        log.info("POST /api/v1/auth/refresh");
        if (refreshToken == null || refreshToken.isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        AuthResponse authResponse = authService.refreshToken(refreshToken);
        authService.setAuthCookies(response, authResponse.getAccessToken(), authResponse.getRefreshToken());
        return ResponseEntity.ok(authResponse);
    }

    /**
     * Logout user - clear cookies
     */
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletResponse response) {
        log.info("POST /api/v1/auth/logout");
        authService.clearAuthCookies(response);
        return ResponseEntity.ok().build();
    }

    /**
     * Get current authenticated user
     */
    @GetMapping("/me")
    public ResponseEntity<AuthResponse.UserInfo> getCurrentUser(Authentication authentication) {
        AuthResponse.UserInfo userInfo = authService.getCurrentUser(authentication);
        log.info("GET /api/v1/auth/me - User: {}", userInfo.getUserId());
        return ResponseEntity.ok(userInfo);
    }

}