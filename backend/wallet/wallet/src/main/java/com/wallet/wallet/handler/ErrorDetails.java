package com.wallet.wallet.handler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetails {
    
    private String exception;
    private String message;

    public ErrorDetails(Exception e){
        this.exception = e.getClass().getSimpleName();
        this.message = e.getMessage();
    }
}
