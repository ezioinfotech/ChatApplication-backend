package com.example.ChatApplication.loginandregistration.exceptions;

import com.example.ChatApplication.loginandregistration.exceptions.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ResponseStatus
@ControllerAdvice
public class LoginExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LoginExceptions.class)
    public ResponseEntity<ErrorModel> departmentNotFoundException(LoginExceptions exception, WebRequest request) {
        ErrorModel message = new ErrorModel(false, exception.getMessage());
        return ResponseEntity.status(HttpStatus.MULTI_STATUS)
                .body(message);
    }
}
