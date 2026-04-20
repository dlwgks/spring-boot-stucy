package com.asdf.buddyboard.util;

import com.asdf.buddyboard.dto.*;
import com.asdf.buddyboard.entity.Member;
import com.asdf.buddyboard.entity.Post;
import com.asdf.buddyboard.entity.Referral;

public class EntityDtoMapper {

    public static MemberResponseDto toDto(Member member){
        return MemberResponseDto.builder()
                .id(member.getId())
                .username(member.getUsername())
                .email(member.getEmail())
                .build();
    }

    public static PostResponseDto toDto(Post post){
        return PostResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .authorId(post.getAuthor().getId())
                .authorUsername(post.getAuthor().getUsername())
                .createdAt(post.getCreatedAt())
                .build();
    }

    public static ReferralResponseDto toDto(Referral ref){
        return ReferralResponseDto.builder()
                .id(ref.getId())
                .referredId(ref.getReferred().getId())
                .referredUsername(ref.getReferred().getUsername())
                .referrerId(ref.getReferrer().getId())
                .referrerUsername(ref.getReferrer().getUsername())
                .createdAt(ref.getCreatedAt())
                .build();
    }

    public static Member toEntity(MemberRequestDto dto){
        return Member.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .build();
    }

    public static Post toEntity(PostRequestDto dto){
        return Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }
}
