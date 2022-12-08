package com.example.hanghaemypost.dto;

import com.example.hanghaemypost.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentDto {
    private String content;
    private String username;
    private LocalDateTime createdAt;

    public CommentDto(Comment comment) {
        this.content = comment.getContent();
        this.username = comment.getUser().getUsername();
        this.createdAt = comment.getCreatedAt();
    }
}
