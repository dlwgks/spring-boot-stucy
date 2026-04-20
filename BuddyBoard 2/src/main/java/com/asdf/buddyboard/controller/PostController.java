package com.asdf.buddyboard.controller;

import com.asdf.buddyboard.dto.PostRequestDto;
import com.asdf.buddyboard.dto.PostResponseDto;
import com.asdf.buddyboard.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostResponseDto> addPost(@RequestBody PostRequestDto dto){
        return ResponseEntity.ok(postService.addPost(dto));
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDto>> getPosts(){
        return ResponseEntity.ok(postService.getPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> getPostById(@PathVariable Long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDto> updatePostById(@PathVariable Long id, @RequestBody PostRequestDto dto){
        return ResponseEntity.ok(postService.updatePostById(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Long id){
        postService.deletePostById(id);
        return ResponseEntity.noContent().build();
    }
}
