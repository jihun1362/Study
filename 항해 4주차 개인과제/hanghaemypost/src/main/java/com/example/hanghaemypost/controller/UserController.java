package com.example.hanghaemypost.controller;


import com.example.hanghaemypost.dto.LoginRequestDto;
import com.example.hanghaemypost.dto.ResponseDto;
import com.example.hanghaemypost.dto.SignupRequestDto;
import com.example.hanghaemypost.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody @Valid SignupRequestDto signupRequestDto) {
        try {
            userService.signup(signupRequestDto);
            return new ResponseDto("Success!", 200);
        } catch (IllegalArgumentException e) {
            return new ResponseDto(e.getMessage(), 400);
        }
    }

    @PostMapping("/login")
    public ResponseDto login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        try {
            userService.login(loginRequestDto, response);
            return new ResponseDto("Success!", 200);
        }catch (IllegalArgumentException e){
            return new ResponseDto(e.getMessage(), 400);
        }
    }
}
