package com.khube.main.global.exception;

import com.khube.main.exception.AddressResponseEmpty;
import com.khube.main.exception.EmployeeAlreadyPresent;
import com.khube.main.exception.EmployeeIsNotPresent;
import com.khube.main.exception.EmployeeNotFoundException;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class EmployeeServiceGlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public Map<String, String> employeeNotFoundException(EmployeeNotFoundException enfe){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", enfe.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmployeeIsNotPresent.class)
    public Map<String, String> employeeIsEmpty(EmployeeIsNotPresent einp){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", einp.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EmployeeAlreadyPresent.class)
    public Map<String, String> employeeAlreadyPresent(EmployeeAlreadyPresent eap){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", eap.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(FeignException.class)
    public Map<String, String> feignException(FeignException fe){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("Address Response is Null", fe.getMessage());
        return errorMap;
    }


/*
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(FeignException.class)
    public String handleFeignStatusException(FeignException e, HttpServletResponse response) {
        response.setStatus(e.status());
        return "Please provide Address Response";
    }
*/

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(AddressResponseEmpty.class)
    public Map<String, String> addressResponseEmpty(AddressResponseEmpty enfe){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("Please provide Address Response", enfe.getMessage());
        return errorMap;
    }
}
