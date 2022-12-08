package com.example.hanghaemypost.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostResponseDto extends ResponseDto {
    private PostDto post;

    public PostResponseDto(String msg, int value, PostDto postDto) {
        super(msg, value);
        this.post = postDto;
    }
}
