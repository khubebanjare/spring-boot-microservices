package com.khube.main.global.exception;

import com.khube.main.exception.EmployeeNotFoundException;
import com.khube.main.exception.reponsebuilder.ResponseEntityBuilder;
import com.khube.main.exception.response.EmployeeErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomEmployeeServiceGlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());

        EmployeeErrorResponse err = new EmployeeErrorResponse(
                LocalDateTime.now(),
                "Employee Not Found",
                HttpStatus.BAD_REQUEST,
                details);
        return ResponseEntityBuilder.build(err);
    }

    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());

        EmployeeErrorResponse err = new EmployeeErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Malformed JSON request", details);

        return ResponseEntityBuilder.build(err);
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> details = new ArrayList<String>();
        details = ex.getBindingResult().getFieldErrors().stream().map(error -> error.getObjectName() + " : " + error.getDefaultMessage()).collect(Collectors.toList());

        EmployeeErrorResponse err = new EmployeeErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Validation Errors", details);

        return ResponseEntityBuilder.build(err);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {

        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());

        EmployeeErrorResponse err = new EmployeeErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Type Mismatch", details);

        return ResponseEntityBuilder.build(err);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(Exception ex, WebRequest request) {

        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());

        EmployeeErrorResponse err = new EmployeeErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Constraint Violations", details);

        return ResponseEntityBuilder.build(err);
    }

    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> details = new ArrayList<String>();
        details.add(ex.getParameterName() + " parameter is missing");

        EmployeeErrorResponse err = new EmployeeErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Missing Parameters", details);

        return ResponseEntityBuilder.build(err);
    }

    /*protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> details = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        builder.append(ex.getContentType());
        builder.append(" media type is not supported. Supported media types are ");
        ex.getSupportedMediaTypes().forEach(t -> builder.append(t).append(", "));

        details.add(builder.toString());

        ApiError err = new ApiError(LocalDateTime.now(), HttpStatus.UNSUPPORTED_MEDIA_TYPE, "Unsupported Media Type", details);

        return ResponseEntityBuilder.build(err);
    }*/

    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> details = new ArrayList<String>();
        details.add(String.format("Could not find the %s method for URL %s", ex.getHttpMethod(), ex.getRequestURL()));

        EmployeeErrorResponse err = new EmployeeErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND, "Method Not Found", details);

        return ResponseEntityBuilder.build(err);

    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {

        List<String> details = new ArrayList<String>();
        details.add(ex.getLocalizedMessage());

        EmployeeErrorResponse err = new EmployeeErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Error occurred", details);

        return ResponseEntityBuilder.build(err);
    }
}
