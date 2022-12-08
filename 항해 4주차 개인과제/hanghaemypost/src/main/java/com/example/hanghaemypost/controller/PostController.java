package com.example.hanghaemypost.controller;

import com.example.hanghaemypost.dto.*;
import com.example.hanghaemypost.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    @PostMapping("/postwrite")
    public ResponseDto createPost(@RequestBody PostRequestDto postRequestDto, HttpServletRequest request) {
        try {
            PostDto postDto = postService.createPost(postRequestDto, request);
            return new PostResponseDto("게시글 작성 완료!", 200, postDto);
        } catch (IllegalArgumentException e) {
            return new ResponseDto(e.getMessage(), 400);
        }
    }

    @GetMapping("/posts")
    public ResponseDto getPosts() {
        try {
            List<PostDto> postDtoList = postService.getPosts();
            return new PostListResponseDto("전체 게시글 조회 완료!", 200, postDtoList);
        } catch (RuntimeException e) {
            return new ResponseDto(e.getMessage(), 500);
        }
    }

    @GetMapping("/posts/{id}")
    public ResponseDto getOnePost(@PathVariable Long id) {
        try {
            PostDto postDto = postService.getOnePost(id);
            return new PostResponseDto("게시글 조회 완료!", 200, postDto);
        } catch (IllegalArgumentException e) {
            return new ResponseDto(e.getMessage(), 400);
        }
    }

    @PutMapping("/posts/{id}")
    public ResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto, HttpServletRequest request) {
        try {
            PostDto postDto = postService.updatePost(id, postRequestDto, request);
            return new PostResponseDto("게시글 수정 완료!", 200, postDto);
        } catch (IllegalArgumentException e) {
            return new ResponseDto(e.getMessage(), 400);
        }
    }

    @DeleteMapping("/posts/{id}")
    public ResponseDto deletePost(@PathVariable Long id, HttpServletRequest request) {
        try {
            postService.deletePost(id, request);
            return new ResponseDto("게시글 삭제 완료!", 200);
        } catch (IllegalArgumentException e) {
            return new ResponseDto(e.getMessage(), 400);
        }
    }

}
