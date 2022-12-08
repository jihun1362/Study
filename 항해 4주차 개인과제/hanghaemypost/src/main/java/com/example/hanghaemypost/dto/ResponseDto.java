package com.example.hanghaemypost.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseDto {
    //DTO(Data Transfer Object)-순수하게 데이터를 담아 계층 간으로 전달하는 객체이다.
    private String msg;
    private int statusCode;

    public ResponseDto(String msg, int value) {
        this.msg = msg;
        this.statusCode = value;
    }
}
