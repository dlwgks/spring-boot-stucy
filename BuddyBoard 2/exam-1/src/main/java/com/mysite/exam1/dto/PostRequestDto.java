package com.mysite.exam1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostRequestDto {
    private Long userId; // 작성자 ID
    private String title;
    private String content;
}