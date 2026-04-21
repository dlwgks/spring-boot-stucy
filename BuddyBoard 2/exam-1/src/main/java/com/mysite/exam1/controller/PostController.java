package com.mysite.exam1.controller;

import com.mysite.exam1.entity.Post;
import com.mysite.exam1.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Post API", description = "게시글 작성 및 조회 관련 API")
@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Operation(summary = "게시글 작성", description = "새로운 게시글을 작성합니다.")
    @PostMapping
    public Post writePost(@RequestBody Post post) {
        return postService.writePost(post);
    }

    @Operation(summary = "게시글 목록 조회", description = "내 ID(myUserId)를 입력하면 내가 차단한 사람의 글을 제외하고 가져옵니다.")
    @GetMapping
    public List<Post> getPosts(@RequestParam Long myUserId) {
        return postService.getFilteredPosts(myUserId);
    }
}