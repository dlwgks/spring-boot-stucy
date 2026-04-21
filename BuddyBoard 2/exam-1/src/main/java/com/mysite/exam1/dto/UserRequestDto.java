package com.mysite.exam1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRequestDto {
    private String username;
    private String email;
    private String password;
    private Long recommenderId; // 추천인 ID (없으면 null)
}
