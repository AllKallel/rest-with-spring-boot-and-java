package com.example.demo.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exceptions.ExceptionResponse;
import com.example.demo.exceptions.UnsupportedMathOperationException;

@RestController //Concentra o tratamento de de todos os controllers espalhados. 
public class CustumizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest Request) {
		ExceptionResponse exceptionRequest = new ExceptionResponse(
				null, 
				ex.getMessage(),
				Request.getDescription(false));
		return new ResponseEntity<>(exceptionRequest, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UnsupportedMathOperationException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest Request) {
		ExceptionResponse exceptionRequest = new ExceptionResponse(
				null,
				ex.getMessage(), 
				Request.getDescription(false));
		return new ResponseEntity<>(exceptionRequest, HttpStatus.BAD_REQUEST);
	}
}
 