package com.mysite.exam1.service;

import com.mysite.exam1.entity.Post;
import com.mysite.exam1.entity.UserBlock;
import com.mysite.exam1.repository.PostRepository;
import com.mysite.exam1.repository.UserBlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserBlockRepository userBlockRepository;

    // 게시글 작성
    public Post writePost(Post post) {
        return postRepository.save(post);
    }

    // 게시글 조회 (차단한 사용자의 글은 필터링)
    public List<Post> getFilteredPosts(Long myUserId) {
        // 1. 내가 차단한 기록 리스트를 가져옴
        List<UserBlock> blocks = userBlockRepository.findByBlockerId(myUserId);

        // 2. 차단당한 사람들의 ID만 추출 (for문 사용)
        List<Long> blockedUserIds = new ArrayList<>();
        for (UserBlock block : blocks) {
            blockedUserIds.add(block.getBlockedId());
        }

        // 3. 필터링 로직
        if (blockedUserIds.isEmpty()) {
            return postRepository.findAll(); // 차단한 사람이 없으면 모두 보여줌
        } else {
            return postRepository.findByUserIdNotIn(blockedUserIds); // 차단한 사람이 있으면 제외하고 보여줌
        }
    }
}