package com.emt.library.web.handler;

import com.emt.library.model.exception.AuthorNotFoundException;
import com.emt.library.model.exception.NoAvailableCopiesException;
import com.emt.library.web.controller.BookController;
import com.emt.library.web.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = BookController.class)
public class BookControllerExceptionHandler {
    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(AuthorNotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(NoAvailableCopiesException.class)
    public ResponseEntity<ApiError> handleNoAvailableCopies(NoAvailableCopiesException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiError.of(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }
}
