package com.mysite.exam1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_blocks")
@Getter @Setter
public class UserBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blockId;

    private Long blockerId; // 차단하는 사람의 ID
    private Long blockedId; // 차단당하는 사람의 ID
}