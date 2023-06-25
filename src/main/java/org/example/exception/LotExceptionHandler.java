package org.example.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LotExceptionHandler {
    @ExceptionHandler(LotNotFoundException.class)
    public ResponseEntity<?> handlerNotFound(){
        return ResponseEntity.notFound().build();
    }
}
