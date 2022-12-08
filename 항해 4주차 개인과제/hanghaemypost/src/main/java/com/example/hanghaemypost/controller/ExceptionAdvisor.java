package com.example.hanghaemypost.controller;

import com.example.hanghaemypost.dto.ResponseDto;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseDto processValidationError(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();

        StringBuilder builder = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            if (fieldError.getField().equals("username")){
                builder2.append(fieldError.getField());
                builder2.append("(은)는 ");
                builder2.append("최소 4 자 및 최대 10 자 하나의 소문자, 하나의 숫자가 들어가야합니다.");
                return new ResponseDto(builder2.toString(), 400);
            }else {
                builder.append(fieldError.getField());
                builder.append("(은)는 ");
                builder.append("최소 8 자 및 최대 15 자, 하나 이상의 대문자, 하나의 소문자, 하나의 숫자 및 하나의 특수 문자가 들어가야합니다.");
                return new ResponseDto(builder.toString(), 400);
            }
        }
        return new ResponseDto("fail!", 400);
    }

}