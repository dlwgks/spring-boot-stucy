package com.asdf.buddyboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ReferralResponseDto {
    private Long id;
    private Long referrerId;  // 추천인
    private String referrerUsername;    // username
    private Long referredId;  // 가입자
    private String referredUsername;    // username
    private LocalDateTime createdAt;
}
