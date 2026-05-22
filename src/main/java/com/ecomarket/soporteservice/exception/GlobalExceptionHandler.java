package com.ecomarket.soporteservice.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecomarket.soporteservice.model.dto.ErrorResponseDTO;

import jakarta.servlet.http.HttpServletRequest;

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

    @ExceptionHandler(YaExisteEnBdException.class)
    public ResponseEntity<ErrorResponseDTO> handleNoExistInDbException(YaExisteEnBdException ex, HttpServletRequest request) {
        ErrorResponseDTO errorResponse = ErrorResponseDTO.builder()
        .timestamp(LocalDateTime.now())
        .status(HttpStatus.CONFLICT.value()).error(HttpStatus.CONFLICT.getReasonPhrase())
        .message(ex.getMessage())
        .path(request.getRequestURI())
        .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(NoExisteEnBdException.class)
    public ResponseEntity<ErrorResponseDTO> handleNoExistInDbException(NoExisteEnBdException ex, HttpServletRequest request) {
        ErrorResponseDTO errorResponse = ErrorResponseDTO.builder()
        .timestamp(LocalDateTime.now())
        .status(HttpStatus.NOT_FOUND.value()).error(HttpStatus.NOT_FOUND.getReasonPhrase())
        .message(ex.getMessage())
        .path(request.getRequestURI())
        .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    
}