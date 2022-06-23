package com.example.demo.controller;

import com.example.demo.dto.UserLoginDto;
import com.example.demo.dto.UserSignUpDto;
import com.example.demo.response.ResponseService;
import com.example.demo.response.Result.CommonResultResponse;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final ResponseService responseService;

    @PostMapping("/register")
    public CommonResultResponse register(@RequestBody UserSignUpDto userSignUpDto) {
        userService.register(userSignUpDto);
        return responseService.getSuccessResult();
    }

    @PostMapping("/login")
    public CommonResultResponse login(@RequestBody UserLoginDto userLoginDto) {
        userService.login(userLoginDto);
        return responseService.getSuccessResult();
    }

}
