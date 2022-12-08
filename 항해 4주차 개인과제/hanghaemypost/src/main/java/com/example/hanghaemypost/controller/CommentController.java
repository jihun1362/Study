package com.example.hanghaemypost.controller;

import com.example.hanghaemypost.dto.CommentDto;
import com.example.hanghaemypost.dto.CommentRequestDto;
import com.example.hanghaemypost.dto.CommentResponseDto;
import com.example.hanghaemypost.dto.ResponseDto;
import com.example.hanghaemypost.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{id}/commentwrite")
    public ResponseDto createComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto, HttpServletRequest request) {
        try {
            CommentDto commentDto = commentService.createComment(id, commentRequestDto, request);
            return new CommentResponseDto("댓글 작성 완료!", 200, commentDto);
        } catch (IllegalArgumentException e) {
            return new ResponseDto(e.getMessage(), 400);
        }
    }

    @PutMapping("/comments/{id}")
    public ResponseDto updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto, HttpServletRequest request) {
        try {
            CommentDto commentDto = commentService.updateComment(id, commentRequestDto, request);
            return new CommentResponseDto("댓글 수정 완료!", 200, commentDto);
        } catch (IllegalArgumentException e) {
            return new ResponseDto(e.getMessage(), 400);
        }
    }

    @DeleteMapping("/comments/{id}")
    public ResponseDto deleteComment(@PathVariable Long id, HttpServletRequest request) {
        try {
            commentService.deleteComment(id, request);
            return new ResponseDto("댓글 삭제 완료!", 200);
        } catch (IllegalArgumentException e) {
            return new ResponseDto(e.getMessage(), 400);
        }
    }
}
