package com.asdf.buddyboard.service;

import com.asdf.buddyboard.dto.PostRequestDto;
import com.asdf.buddyboard.dto.PostResponseDto;
import com.asdf.buddyboard.entity.Member;
import com.asdf.buddyboard.entity.Post;
import com.asdf.buddyboard.exception.PostNotFoundException;
import com.asdf.buddyboard.repository.MemberRepository;
import com.asdf.buddyboard.repository.PostRepository;
import com.asdf.buddyboard.util.EntityDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public PostResponseDto addPost(PostRequestDto dto){
        Member author = memberRepository.findById(dto.getAuthorId()).orElseThrow(PostNotFoundException::new);
        Post post = EntityDtoMapper.toEntity(dto);
        post.setAuthor(author);
        return EntityDtoMapper.toDto(postRepository.save(post));
    }

    @Transactional(readOnly = true)
    public List<PostResponseDto> getPosts(){
        return postRepository.findAll().stream()
                .map(EntityDtoMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public PostResponseDto getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(PostNotFoundException::new);
        return EntityDtoMapper.toDto(post);
    }

    // 추천인 기준으로 나를 추천인으로 기입한 가입자들의 게시글 조회
    @Transactional(readOnly = true)
    public List<PostResponseDto> getPostsByReferrer(Long id){
        return postRepository.findByReferrer(id).stream()
                .map(EntityDtoMapper::toDto)
                .toList();
    }

    // 가입자 기주으로 내가 입력한 추천인의 게시글 조회
    @Transactional(readOnly = true)
    public List<PostResponseDto> getPostsByReferred(Long id){
        return postRepository.findByReferred(id).stream()
                .map(EntityDtoMapper::toDto)
                .toList();
    }

    // 제목과 본문만 수정 가능
    public PostResponseDto updatePostById(Long id, PostRequestDto dto){
        Post post = postRepository.findById(id).orElseThrow(PostNotFoundException::new);
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        return EntityDtoMapper.toDto(postRepository.save(post));
    }

    public void deletePostById(Long id){
        postRepository.deleteById(id);
    }
}
