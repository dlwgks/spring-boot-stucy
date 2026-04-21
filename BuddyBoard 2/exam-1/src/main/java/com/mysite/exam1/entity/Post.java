package com.mysite.exam1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Getter @Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private Long userId; // 작성자 ID
    private String title;
    private String content;

    private LocalDateTime createdAt = LocalDateTime.now();
}