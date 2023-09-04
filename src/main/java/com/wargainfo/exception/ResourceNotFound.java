package com.wargainfo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.io.Serializable;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = 6047715523242910552L;

    public ResourceNotFound(String message){
        super(message);
    }





}
