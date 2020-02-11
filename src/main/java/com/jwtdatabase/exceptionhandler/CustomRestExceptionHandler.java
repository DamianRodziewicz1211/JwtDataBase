package com.jwtdatabase.exceptionhandler;



import org.json.JSONException;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request){

        List<String> errors = new ArrayList<String>();
        for(FieldError error : ex.getBindingResult().getFieldErrors()){
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }

        for(ObjectError error : ex.getBindingResult().getGlobalErrors()){
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        ApiErrors apiErrors = new ApiErrors(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),errors);

        return handleExceptionInternal( ex, apiErrors,headers,apiErrors.getStatus(),request);

    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        String error = ex.getParameterName() + " parameter is missing";

        ApiErrors apiErrors = new ApiErrors(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),error);

        return new ResponseEntity<Object>( apiErrors, new HttpHeaders(), apiErrors.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        String error = ex.getMethod() + " not supported. Check URL or arguments";


        ApiErrors apiErrors = new ApiErrors(HttpStatus.METHOD_NOT_ALLOWED,ex.getMessage(),error);

        return new ResponseEntity<Object>(apiErrors,new HttpHeaders(),apiErrors.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request){
        String error = "Make sure you have all needed arguments";

        ApiErrors apiErrors = new ApiErrors(HttpStatus.BAD_REQUEST,ex.getMessage(),error);

        return new ResponseEntity<Object>(apiErrors,new HttpHeaders(),apiErrors.getStatus());
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    protected ResponseEntity<Object> handleEmptyResultException(
            EmptyResultDataAccessException ex) {
        String error = "No entity with given id";
        ApiErrors apiErrors = new ApiErrors(HttpStatus.NOT_FOUND,ex.getMessage(),error);

        return new ResponseEntity<Object>(apiErrors,new HttpHeaders(),apiErrors.getStatus());
    }



    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<Object> handleNullPointerException(
            NullPointerException ex) {
        String error = "No entity with given id";
        ApiErrors apiErrors = new ApiErrors(HttpStatus.NOT_FOUND,ex.getMessage(),error);

        return new ResponseEntity<Object>(apiErrors,new HttpHeaders(),apiErrors.getStatus());
    }


}
