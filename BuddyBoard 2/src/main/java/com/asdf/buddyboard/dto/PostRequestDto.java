package com.asdf.buddyboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostRequestDto {
    private String title;
    private String content;
    private Long authorId;
}
