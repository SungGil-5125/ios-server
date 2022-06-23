package com.example.demo.response.Result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class CommonResultResponse {

    private boolean success;
    private String msg;
    private HttpStatus httpStatus;
}
