package com.wallet.wallet.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class ResponseBuilder {

    public static ResponseEntity<Object> responseBuilder(HttpStatus httpStatus, String path, Object object){
        Map<String, Object> response = new HashMap<>();
        response.put("status", httpStatus);
        response.put("path", path);
        response.put("timestamp", Timestamp.from(Instant.now()));
        response.put((object instanceof ErrorDetails) ? "error" : "response", object);
        return ResponseEntity.status(httpStatus).body(response);
    };

    public static ResponseEntity<Object> responseBuilder(HttpStatus httpStatus, Object object){
        Map<String, Object> response = new HashMap<>();
        response.put("status", httpStatus);
        response.put("timestamp", Timestamp.from(Instant.now()));
        response.put((object instanceof ErrorDetails) ? "error" : "response", object);
        return ResponseEntity.status(httpStatus).body(response);
    };
}
