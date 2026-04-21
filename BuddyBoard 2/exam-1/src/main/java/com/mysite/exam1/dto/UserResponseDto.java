package com.mysite.exam1.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter @Setter
public class UserResponseDto {
    private Long userId;
    private String username;
    private String email;
    private LocalDateTime createdAt;
}