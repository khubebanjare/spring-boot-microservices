package com.khube.crm.enquiry.main.global.exception;

import java.time.LocalDateTime;

import org.junit.gen5.commons.util.ExceptionUtils;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.khube.crm.enquiry.main.exception.EnquiryAlreadyPresentException;
import com.khube.crm.enquiry.main.exception.EnquiryIsNotPresentException;
import com.khube.crm.enquiry.main.exception.EnquiryNotFoundException;
import com.khube.crm.enquiry.main.response.error.EnquiryErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class CrmEnquiresGlobalException {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler
	public ResponseEntity<EnquiryErrorResponse> handleProductNotFoundException(EnquiryNotFoundException ex,
			HttpServletRequest request) {
		EnquiryErrorResponse enquiryErrorResponse = new EnquiryErrorResponse();

		enquiryErrorResponse.setTimestamp(LocalDateTime.now());
		enquiryErrorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		enquiryErrorResponse.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		enquiryErrorResponse.setMessage(ex.getMessage());
		enquiryErrorResponse.setTrace(ExceptionUtils.readStackTrace(ex));
		enquiryErrorResponse.setPath(request.getRequestURI());
		return new ResponseEntity<EnquiryErrorResponse>(enquiryErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler
	public ResponseEntity<EnquiryErrorResponse> handleProductIsNotPresentException(EnquiryIsNotPresentException ex,
			HttpServletRequest request) {
		EnquiryErrorResponse enquiryErrorResponse = new EnquiryErrorResponse();

		enquiryErrorResponse.setTimestamp(LocalDateTime.now());
		enquiryErrorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		enquiryErrorResponse.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		enquiryErrorResponse.setMessage(ex.getMessage());
		enquiryErrorResponse.setTrace(ExceptionUtils.readStackTrace(ex));
		enquiryErrorResponse.setPath(request.getRequestURI());
		return new ResponseEntity<EnquiryErrorResponse>(enquiryErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler
	public ResponseEntity<EnquiryErrorResponse> handleProductIsNotPresentException(EnquiryAlreadyPresentException ex,
			HttpServletRequest request) {
			EnquiryErrorResponse enquiryErrorResponse = new EnquiryErrorResponse();

			enquiryErrorResponse.setTimestamp(LocalDateTime.now());
			enquiryErrorResponse.setStatus(HttpStatus.CONFLICT.value());
			enquiryErrorResponse.setError(HttpStatus.CONFLICT.getReasonPhrase());
			enquiryErrorResponse.setMessage(ex.getMessage());
			enquiryErrorResponse.setTrace(ExceptionUtils.readStackTrace(ex));
			enquiryErrorResponse.setPath(request.getRequestURI());
			return new ResponseEntity<EnquiryErrorResponse>(enquiryErrorResponse, HttpStatus.CONFLICT);
	}
	
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler
	public ResponseEntity<EnquiryErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex,
			HttpServletRequest request) {
			EnquiryErrorResponse enquiryErrorResponse = new EnquiryErrorResponse();

			enquiryErrorResponse.setTimestamp(LocalDateTime.now());
			enquiryErrorResponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			enquiryErrorResponse.setError(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase());
			enquiryErrorResponse.setMessage(ex.getMessage());
			enquiryErrorResponse.setTrace(ExceptionUtils.readStackTrace(ex));
			enquiryErrorResponse.setPath(request.getRequestURI());
			return new ResponseEntity<EnquiryErrorResponse>(enquiryErrorResponse, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	public ResponseEntity<EnquiryErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex,
			HttpServletRequest request) {
			EnquiryErrorResponse enquiryErrorResponse = new EnquiryErrorResponse();

			enquiryErrorResponse.setTimestamp(LocalDateTime.now());
			enquiryErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			enquiryErrorResponse.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
			enquiryErrorResponse.setMessage(ex.getMessage());
			enquiryErrorResponse.setTrace(ExceptionUtils.readStackTrace(ex));
			enquiryErrorResponse.setPath(request.getRequestURI());
			return new ResponseEntity<EnquiryErrorResponse>(enquiryErrorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler
	public ResponseEntity<EnquiryErrorResponse> handleNotFoundException(NotFoundException ex,
			HttpServletRequest request) {
			EnquiryErrorResponse enquiryErrorResponse = new EnquiryErrorResponse();

			enquiryErrorResponse.setTimestamp(LocalDateTime.now());
			enquiryErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
			enquiryErrorResponse.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
			enquiryErrorResponse.setMessage(ex.getMessage());
			enquiryErrorResponse.setTrace(ExceptionUtils.readStackTrace(ex));
			enquiryErrorResponse.setPath(request.getRequestURI());
			return new ResponseEntity<EnquiryErrorResponse>(enquiryErrorResponse, HttpStatus.NOT_FOUND);
	}
}
