package com.skillwilltest.exception;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.skillwilltest.BaseResponse;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	@Autowired
	private BaseResponse errorResponse;
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<BaseResponse> handleNotFound(Exception ex, WebRequest req) {
		
		errorResponse.setError(true);
		errorResponse.setResponseCode("student.not.found");
		errorResponse.setResponseMsg(ex.getMessage());
		errorResponse.setTimestamp(LocalDateTime.now());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}


	//generic error handler
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<BaseResponse> handleError(Exception ex, WebRequest req) {

		errorResponse.setError(true);
		errorResponse.setResponseCode("internal.server.error");
		errorResponse.setResponseMsg(ex.getMessage());
		errorResponse.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
