package com.mysite.exam1.repository;

import com.mysite.exam1.entity.UserBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserBlockRepository extends JpaRepository<UserBlock, Long> {
    // 내가 차단한 기록들을 가져오는 메서드
    List<UserBlock> findByBlockerId(Long blockerId);
}