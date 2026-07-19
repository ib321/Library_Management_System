package com.ib.lms.auth.dto;

import com.ib.lms.model.User;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    private String accessToken;
    private String refreshToken;
    private String tokenType = "Bearer";
    private Long expiresIn;
    private UserInfo user;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInfo {
        private String userId;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String address;
        private User.Role role;
        private Boolean enabled;

        public static UserInfo fromUser(User user) {
            return UserInfo.builder()
                    .userId(user.getUserid())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .phone(user.getPhone())
                    .address(user.getAddress())
                    .role(user.getRole())
                    .enabled(user.isEnabled())
                    .build();
        }
    }
}