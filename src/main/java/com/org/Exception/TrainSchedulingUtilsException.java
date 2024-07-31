package com.org.Exception;

import com.org.Util.ResponseCode;
import org.springframework.http.HttpStatus;

public class TrainSchedulingUtilsException {
    public final static void propogateBadRequestException(String message, ResponseCode responseCode){
         throw new TrainScedulingException(message, HttpStatus.BAD_REQUEST,responseCode);
    }
}
