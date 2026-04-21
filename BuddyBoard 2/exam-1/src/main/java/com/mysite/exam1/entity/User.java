package com.mysite.exam1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String email;
    private String password;

    // 추천인 ID (초보자 스타일로 외래키를 직접 저장)
    private Long recommenderId;

    private LocalDateTime createdAt = LocalDateTime.now();
}