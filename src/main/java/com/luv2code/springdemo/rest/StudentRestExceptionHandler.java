package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

		//add exception handling code here
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		
		//create a student error response
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMesssage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		//return responseentity
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	//add another exception handler to catch generic unexpected edge case exceptions:
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMesssage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		//return responseentity
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
