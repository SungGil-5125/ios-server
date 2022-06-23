package com.example.demo.response;

import com.example.demo.response.Result.CommonResultResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    @Getter
    @AllArgsConstructor
    private enum CommonResponse {
        SUCCESS(true, "성공", HttpStatus.OK);
        private Boolean success;
        private String msg;
        private HttpStatus httpStatus;
    }

    public CommonResultResponse getSuccessResult() {
        return getCommonResultResponse();
    }

    private CommonResultResponse getCommonResultResponse() {
        return new CommonResultResponse(CommonResponse.SUCCESS.getSuccess(), CommonResponse.SUCCESS.msg, CommonResponse.SUCCESS.httpStatus);
    }
}
