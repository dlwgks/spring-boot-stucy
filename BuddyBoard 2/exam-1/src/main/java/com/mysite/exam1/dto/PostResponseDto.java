package com.mysite.exam1.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter @Setter
public class PostResponseDto {
    private Long postId;
    private Long userId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
}