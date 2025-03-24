package com.media.database.media_database.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MediaNotFoundException.class)
    // @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleMediaNotFound(MediaNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(MediaTypeNotFoundException.class)
    // @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleMediaTypeNotFound(MediaTypeNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<String> handleRoleNotFound(RoleNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
