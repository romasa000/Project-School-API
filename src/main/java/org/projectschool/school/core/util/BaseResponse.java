package org.projectschool.school.core.util;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BaseResponse {
    private int port;
    private HttpStatus http;
    private String msj;
    private Object object;

    public BaseResponse(int port, HttpStatus http, String msj, Object object) {
        this.port = port;
        this.http = http;
        this.msj = msj;
        this.object = object;
    }

    public BaseResponse(int port, HttpStatus http, String msj) {
        this.port = port;
        this.http = http;
        this.msj = msj;
    }
}
