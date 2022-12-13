package com.wallet.wallet.handler.controller;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.*;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;

import com.wallet.wallet.handler.ErrorDetails;
import com.wallet.wallet.handler.exception.ResourceNotFoundException;
import com.wallet.wallet.handler.exception.UserUnauthorizedException;

import static com.wallet.wallet.handler.ResponseBuilder.responseBuilder;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler({ NotFoundException.class,
            ResourceNotFoundException.class
    })
    public ResponseEntity<Object> notFoundHandler(HttpServletRequest request, Exception exception) {
        return responseBuilder(NOT_FOUND, request.getRequestURI(), new ErrorDetails(exception));
    }

    @ResponseStatus(FORBIDDEN)
    @ExceptionHandler({ Forbidden.class })
    public ResponseEntity<Object> forbiddenHandler(HttpServletRequest request, Exception exception) {
        return responseBuilder(FORBIDDEN, request.getRequestURI(), new ErrorDetails(exception));
    }

    @ResponseStatus(UNAUTHORIZED)
    @ExceptionHandler({ Unauthorized.class, 
            BadCredentialsException.class,
            UserUnauthorizedException.class 
    })
    public ResponseEntity<Object> unauthorizedHandler(HttpServletRequest request, Exception exception) {
        return responseBuilder(FORBIDDEN, request.getRequestURI(), new ErrorDetails(exception));
    }

    @ResponseStatus(CONFLICT)
    @ExceptionHandler({})
    public ResponseEntity<Object> alreadyExistsHandler(HttpServletRequest request, Exception exception) {
        return responseBuilder(CONFLICT, request.getRequestURI(), new ErrorDetails(exception));
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({ ArithmeticException.class,
            MissingRequestHeaderException.class,
            MethodArgumentNotValidException.class,
            NullPointerException.class,
            IllegalArgumentException.class,
            IndexOutOfBoundsException.class,
    })
    public ResponseEntity<Object> badRequestHandler(HttpServletRequest request, Exception exception) {
        return responseBuilder(BAD_REQUEST, request.getRequestURI(), new ErrorDetails(exception));
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<Object> internalServerErrorHandler(HttpServletRequest request, Exception exception) {
        return responseBuilder(INTERNAL_SERVER_ERROR, request.getRequestURI(), new ErrorDetails(exception));
    }

}
