package com.example.hanghaemypost.dto;

import com.example.hanghaemypost.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostResponseDto extends ResponseDto {
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;

    public PostResponseDto(Post post,String msg){
        super(msg, HttpStatus.OK.value());
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
        this.createdAt = post.getCreatedAt();
    }
}
