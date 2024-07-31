package com.org.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import com.org.Util.*;
@Getter
public class TrainScedulingException extends RuntimeException{

    private HttpStatus status;
    private ResponseCode responseCode;

    public TrainScedulingException(String messege, HttpStatus status,ResponseCode responseCode){
        super(messege);
        this.status=status;
        this.responseCode=responseCode;
    }

}
