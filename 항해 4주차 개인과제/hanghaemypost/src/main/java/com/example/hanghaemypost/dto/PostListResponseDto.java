package com.example.hanghaemypost.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostListResponseDto extends ResponseDto {
    private List<PostDto> postList;

    public PostListResponseDto(String msg, int value, List<PostDto> postDtoList) {
        super(msg, value);
        this.postList = postDtoList;
    }
}
