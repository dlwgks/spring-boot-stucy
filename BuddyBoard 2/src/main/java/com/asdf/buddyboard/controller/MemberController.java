package com.asdf.buddyboard.controller;

import com.asdf.buddyboard.dto.MemberRequestDto;
import com.asdf.buddyboard.dto.MemberResponseDto;
import com.asdf.buddyboard.dto.PostResponseDto;
import com.asdf.buddyboard.service.MemberService;
import com.asdf.buddyboard.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/members")
public class MemberController {
    private final MemberService memberService;
    private final PostService postService;

    @PostMapping
    public ResponseEntity<MemberResponseDto> addMember(@RequestBody MemberRequestDto dto){
        return ResponseEntity.ok(memberService.addMember(dto));
    }

    @GetMapping
    public ResponseEntity<List<MemberResponseDto>> getMembers(){
        return ResponseEntity.ok(memberService.getMembers());
    }

    @GetMapping("/{id}/referrer/posts")
    public ResponseEntity<List<PostResponseDto>> getMyReferrerPosts(@PathVariable Long id){
        // 내가 Referred 입장. 상대방이 referrer
        return ResponseEntity.ok(postService.getPostsByReferred(id));
    }

    @GetMapping("/{id}/referred/posts")
    public ResponseEntity<List<PostResponseDto>> getMyReferredPosts(@PathVariable Long id){
        // 내가 Referrer 입장. 상대방이 Referred
        return ResponseEntity.ok(postService.getPostsByReferrer(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> getMemberById(@PathVariable Long id){
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberResponseDto> updateMemberById(@PathVariable Long id, @RequestBody MemberRequestDto dto){
        return ResponseEntity.ok(memberService.updateMemberById(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id){
        memberService.deleteMemberById(id);
        return ResponseEntity.noContent().build();
    }
}
