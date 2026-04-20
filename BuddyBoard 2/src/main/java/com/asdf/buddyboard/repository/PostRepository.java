package com.asdf.buddyboard.repository;

import com.asdf.buddyboard.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    // 특정 사용자(referrer)의 추천으로 가입한 사람들(N명)의 게시글 조회
    @Query(
            "SELECT p FROM Post p " +
            "JOIN Referral r ON r.referred.id = p.author.id " +
            "WHERE r.referrer.id = :referrerId"
    )
    List<Post> findByReferrer(@Param("referrerId")Long referrerId);

    // 내 추천인(한 명)의 게시글 조회
    @Query(
            "SELECT p from Post p " +
            "JOIN Referral r ON r.referrer.id = p.author.id " +
            "WHERE r.referred.id = :referredId"
    )
    List<Post> findByReferred(@Param("referredId")Long referredId);
}
