package com.ecomarket.soporteservice.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> errorHandlerValidation(MethodArgumentNotValidException ex) {
        //@SuppressWarnings("unused")
        Map<String, String> errorsMap = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorsMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorsMap;
    }


    /* Excepciones personalizadas template

    @ExceptionHandler(NoExistInDbException.class)
    public ResponseEntity<ErrorResponse> handleNoExistInDbException(NoExistInDbException ex, HttpServletRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
        .timestamp(LocalDateTime.now())
        .status(HttpStatus.NOT_FOUND.value()).error(HttpStatus.NOT_FOUND.getReasonPhrase())
        .message(ex.getMessage())
        .path(request.getRequestURI())
        .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse    );
    }
    */

}