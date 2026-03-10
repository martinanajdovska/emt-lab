package com.emt.library.web.handler;

import com.emt.library.model.exception.CountryNotFoundException;
import com.emt.library.web.controller.AuthorController;
import com.emt.library.web.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = AuthorController.class)
public class AuthorControllerExceptionHandler {
    @ExceptionHandler(CountryNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(CountryNotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(HttpStatus.NOT_FOUND, exception.getMessage()));
    }
}
