package com.mysite.exam1.repository;

import com.mysite.exam1.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    // 차단당한 사용자의 ID 목록을 제외하고 게시글을 가져오는 메서드
    List<Post> findByUserIdNotIn(List<Long> blockedIds);
}