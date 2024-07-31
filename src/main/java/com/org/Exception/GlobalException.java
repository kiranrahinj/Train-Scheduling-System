package com.org.Exception;

import com.org.Util.ResponseCode;
import com.org.Util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(TrainScedulingException.class)
    public final ResponseEntity<?> trainSchedulingExcetpion( TrainScedulingException trainScedulingEx){
        return new ResponseEntity<>(ResponseUtil.getErrorGenericApiResponse(trainScedulingEx.getMessage(),trainScedulingEx.getResponseCode().name()),
                trainScedulingEx.getStatus());
    }
}
