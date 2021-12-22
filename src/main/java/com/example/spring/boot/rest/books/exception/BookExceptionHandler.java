package com.example.spring.boot.rest.books.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.spring.boot.rest.books.model.ResponseMessage;

@ControllerAdvice
public class BookExceptionHandler {

	@ExceptionHandler(Exception.class)
	private ResponseEntity<ResponseMessage> handleGenericException(Exception ex)
	{
		System.out.println("Error Message: " + ex.getMessage());
		ResponseMessage response=new ResponseMessage();
		response.setId(-1);
		response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
		response.setMessage(ex.getMessage());
		return ResponseEntity.badRequest().body(response);
		
	}
}
