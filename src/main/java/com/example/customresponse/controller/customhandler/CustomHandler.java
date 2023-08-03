package com.example.customresponse.controller.customhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { RuntimeException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>(
                ErrorResponse
                        .builder()
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                        .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

//    @ExceptionHandler(value = { MissingServletRequestParameterException.class })
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseEntity<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
//        return new ResponseEntity<>(
//                ErrorResponse
//                        .builder()
//                        .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
//                        .message(ex.getMessage())
//                        .build(),
//                HttpStatus.BAD_REQUEST
//        );
//    }

    @ExceptionHandler(value = { AuthenticationException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleAuthenticationException(RuntimeException ex) {
        return new ResponseEntity<>(
                ErrorResponse
                        .builder()
                        .code(HttpStatus.FORBIDDEN.getReasonPhrase())
                        .message(HttpStatus.FORBIDDEN.getReasonPhrase())
                        .build(),
                HttpStatus.FORBIDDEN
        );
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(
                ErrorResponse
                        .builder()
                        .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                        .message(ex.getMessage())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }
}
