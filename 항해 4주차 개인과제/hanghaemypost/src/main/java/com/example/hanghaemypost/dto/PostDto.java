package com.example.hanghaemypost.dto;

import com.example.hanghaemypost.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@NoArgsConstructor
public class PostDto {
    private String title;
    private String content;
    private String username;
    private LocalDateTime createdAt;

    private ArrayList<CommentDto> commentList;

    public PostDto(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.username = post.getUser().getUsername();
        this.createdAt = post.getCreatedAt();
    }

    public PostDto(Post post, ArrayList<CommentDto> commentDtoList) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.username = post.getUser().getUsername();
        this.createdAt = post.getCreatedAt();
        this.commentList = commentDtoList;
    }

}
