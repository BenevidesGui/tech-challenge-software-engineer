package org.example.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(StrategyNotFoundException.class)

    public ResponseEntity<ErrorResponse> handleStrategyNotFound(StrategyNotFoundException ex) {
        ErrorResponse error =
                new ErrorResponse(
                        ex.getMessage(),
                        HttpStatus.NOT_FOUND.value()
                );

        logger.error("Strategy not found error occurred");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {

        String message = ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        ErrorResponse error =
                new ErrorResponse(
                        message,
                        400
                );
        logger.error("Validation error occurred");

        return ResponseEntity
                .badRequest()
                .body(error);
    }
}