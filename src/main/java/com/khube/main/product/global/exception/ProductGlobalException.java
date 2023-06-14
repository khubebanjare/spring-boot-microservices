package com.khube.main.product.global.exception;

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

import com.khube.main.product.exception.ProductAlreadyPresent;
import com.khube.main.product.exception.ProductIsEmptyException;
import com.khube.main.product.exception.ProductIsNotPresent;
import com.khube.main.product.exception.ProductNotFoundException;
import com.khube.main.product.response.error.ProductErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ProductGlobalException {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler
	public ResponseEntity<ProductErrorResponse> handleProductNotFoundException(ProductNotFoundException ex,
			HttpServletRequest request) {
		ProductErrorResponse productErrorResponse = new ProductErrorResponse();

		productErrorResponse.setTimestamp(LocalDateTime.now());
		productErrorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		productErrorResponse.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		productErrorResponse.setMessage(ex.getMessage());
		productErrorResponse.setTrace(ExceptionUtils.readStackTrace(ex));
		productErrorResponse.setPath(request.getRequestURI());
		return new ResponseEntity<ProductErrorResponse>(productErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler
	public ResponseEntity<ProductErrorResponse> handleProductIsNotPresentException(ProductIsNotPresent ex,
			HttpServletRequest request) {
		ProductErrorResponse productErrorResponse = new ProductErrorResponse();

		productErrorResponse.setTimestamp(LocalDateTime.now());
		productErrorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		productErrorResponse.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		productErrorResponse.setMessage(ex.getMessage());
		productErrorResponse.setTrace(ExceptionUtils.readStackTrace(ex));
		productErrorResponse.setPath(request.getRequestURI());
		return new ResponseEntity<ProductErrorResponse>(productErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler
	public ResponseEntity<ProductErrorResponse> handleProductAlreadyPresent(ProductAlreadyPresent ex,
			HttpServletRequest request) {
		ProductErrorResponse productErrorResponse = new ProductErrorResponse();

		productErrorResponse.setTimestamp(LocalDateTime.now());
		productErrorResponse.setStatus(HttpStatus.CONFLICT.value());
		productErrorResponse.setError(HttpStatus.CONFLICT.getReasonPhrase());
		productErrorResponse.setMessage(ex.getMessage());
		productErrorResponse.setTrace(ExceptionUtils.readStackTrace(ex));
		productErrorResponse.setPath(request.getRequestURI());
		return new ResponseEntity<ProductErrorResponse>(productErrorResponse, HttpStatus.CONFLICT);
	}
	
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler
	public ResponseEntity<ProductErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex,
			HttpServletRequest request) {
		ProductErrorResponse productErrorResponse = new ProductErrorResponse();

		productErrorResponse.setTimestamp(LocalDateTime.now());
		productErrorResponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
		productErrorResponse.setError(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase());
		productErrorResponse.setMessage(ex.getMessage());
		productErrorResponse.setTrace(ExceptionUtils.readStackTrace(ex));
		productErrorResponse.setPath(request.getRequestURI());
			return new ResponseEntity<ProductErrorResponse>(productErrorResponse, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	public ResponseEntity<ProductErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex,
			HttpServletRequest request) {
		ProductErrorResponse productErrorResponse = new ProductErrorResponse();

		productErrorResponse.setTimestamp(LocalDateTime.now());
		productErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		productErrorResponse.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
		productErrorResponse.setMessage(ex.getMessage());
		productErrorResponse.setTrace(ExceptionUtils.readStackTrace(ex));
		productErrorResponse.setPath(request.getRequestURI());
			return new ResponseEntity<ProductErrorResponse>(productErrorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler
	public ResponseEntity<ProductErrorResponse> handleNotFoundException(NotFoundException ex,
			HttpServletRequest request) {
		ProductErrorResponse productErrorResponse = new ProductErrorResponse();

		productErrorResponse.setTimestamp(LocalDateTime.now());
		productErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		productErrorResponse.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
		productErrorResponse.setMessage(ex.getMessage());
		productErrorResponse.setTrace(ExceptionUtils.readStackTrace(ex));
		productErrorResponse.setPath(request.getRequestURI());
			return new ResponseEntity<ProductErrorResponse>(productErrorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler
	public ResponseEntity<ProductErrorResponse> handleProductIsEmptyException(ProductIsEmptyException ex,
			HttpServletRequest request) {
		ProductErrorResponse productErrorResponse = new ProductErrorResponse();

		productErrorResponse.setTimestamp(LocalDateTime.now());
		productErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		productErrorResponse.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
		productErrorResponse.setMessage(ex.getMessage());
		productErrorResponse.setTrace(ExceptionUtils.readStackTrace(ex));
		productErrorResponse.setPath(request.getRequestURI());
			return new ResponseEntity<ProductErrorResponse>(productErrorResponse, HttpStatus.NOT_FOUND);
	}
	
}
