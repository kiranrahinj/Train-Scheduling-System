package com.org.Util;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenericApiResponse {
    private String status;
    private String responseCode;
    private String messege;
    private Object data;

    public GenericApiResponse(String messege,String status,String responseCode){
        this.messege=messege;
        this.status=status;
        this.responseCode=responseCode;
    }
}
