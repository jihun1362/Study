package com.example.hanghaemypost.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentResponseDto extends ResponseDto {
    private CommentDto commentDto;

    public CommentResponseDto(String msg, int value, CommentDto commentDto) {
        super(msg, value);
        this.commentDto = commentDto;
    }
}
