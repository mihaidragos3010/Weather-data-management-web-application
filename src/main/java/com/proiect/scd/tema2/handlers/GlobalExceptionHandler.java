package com.proiect.scd.tema2.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.microsoft.sqlserver.jdbc.SQLServerException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLServerException.class)
    public ResponseEntity<?> handleSQLServerException() {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .build();
    }

}
