package com.asdf.buddyboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberRequestDto {
    private String username;
    private String password;
    private String email;
    private String referrer;
}
