package com.wallet.wallet.handler.exception;

public class UserUnauthorizedException extends RuntimeException{
    
    public UserUnauthorizedException(String message){
        super(message);
    }
}
