package com.khube.crm.enquiry.main.global.exception;

import java.time.LocalDateTime;

import org.junit.gen5.commons.util.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
