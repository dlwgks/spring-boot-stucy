package com.asdf.buddyboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MemberResponseDto {
    private Long id;
    private String username;
    private String email;
}
