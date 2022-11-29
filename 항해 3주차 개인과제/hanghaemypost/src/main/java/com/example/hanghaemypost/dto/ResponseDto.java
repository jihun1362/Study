package com.example.hanghaemypost.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseDto {
    private String msg;
    private int statusCode;

    public ResponseDto(String msg, int value) {
        this.msg = msg;
        this.statusCode = value;
    }
}
