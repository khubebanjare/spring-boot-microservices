package com.khube.main.global.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.khube.main.exception.AddressAlreadyPresent;
import com.khube.main.exception.AddressNotFoundException;
import com.khube.main.exception.AddressNotPresent;

public class AddressServiceGlobalExceptionHandler {

	 	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    @ExceptionHandler(AddressNotFoundException.class)
	    public Map<String, String> addressNotFoundException(AddressNotFoundException anfe){
	        Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("errorMessage", anfe.getMessage());
	        return errorMap;
	    }

	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(AddressNotPresent.class)
	    public Map<String, String> addressNotPresent(AddressNotPresent anp){
	        Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("errorMessage", anp.getMessage());
	        return errorMap;
	    }

	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    @ExceptionHandler(AddressAlreadyPresent.class)
	    public Map<String, String> addressAlreadyPresent(AddressAlreadyPresent aap){
	        Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("errorMessage", aap.getMessage());
	        return errorMap;
	    }
	    
	/*
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    @ExceptionHandler(FeignException.class)
	    public Map<String, String> feignException(FeignException fe){
	        Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("Address Response is Null", fe.getMessage());
	        return errorMap;
	    }
	*/

	/*
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    @ExceptionHandler(FeignException.class)
	    public String handleFeignStatusException(FeignException e, HttpServletResponse response) {
	        response.setStatus(e.status());
	        return "Please provide Address Response";
	    }
	*/

	/*
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    @ExceptionHandler(AddressResponseEmpty.class)
	    public Map<String, String> addressResponseEmpty(AddressResponseEmpty enfe){
	        Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("Please provide Address Response", enfe.getMessage());
	        return errorMap;
	    }
	*/
}
