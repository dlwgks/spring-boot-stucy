package com.mysite.exam1.service;

import com.mysite.exam1.entity.User;
import com.mysite.exam1.entity.UserBlock;
import com.mysite.exam1.repository.UserBlockRepository;
import com.mysite.exam1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserBlockRepository userBlockRepository;

    // 회원가입
    public User register(User user) {
        return userRepository.save(user);
    }

    // 사용자 차단 기능
    public String blockUser(Long blockerId, Long blockedId) {
        UserBlock block = new UserBlock();
        block.setBlockerId(blockerId);
        block.setBlockedId(blockedId);
        userBlockRepository.save(block);

        return "사용자를 성공적으로 차단했습니다.";
    }
}