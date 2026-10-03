package com.example.parcial.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.processing.Completion;

import static com.sun.tools.javac.jvm.ByteCodes.error;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class){
        public ProblemDetail handleValidation;(MethodArgumentNotValidException ex){
            string errors = ex.getBindingResult().getFieldErrors().streams()
                    .map(error->error.getField()+": " error.getDefaultMessage()
        }
    }

    @ExceptionHandler(AlreadyRequestedException.class){
        public ProblemDetail handle Completion ex;
        AlreadyRequestedException(AlreadyRequestedException ex){
            return ProblemDetail.forStatusAndDetail(HttpStatus.ALREADYREQUESTED, ex.getMessage());
        }
    }
}
