package com.org.Util;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public final static GenericApiResponse getSuccessGenericApiResponse(String message,String status,String ResposeCode,Object data){
        return GenericApiResponse.builder().messege(message).responseCode(ResposeCode).status(status).data(data).build();
    }

    public final static GenericApiResponse getErrorGenericApiResponse(String messege,String ResponseCode){
        return GenericApiResponse.builder().messege(messege).status("error").responseCode(ResponseCode).build();
    }
}
