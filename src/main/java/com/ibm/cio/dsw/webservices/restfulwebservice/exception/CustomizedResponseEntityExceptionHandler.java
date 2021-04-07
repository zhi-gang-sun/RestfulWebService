package com.ibm.cio.dsw.webservices.restfulwebservice.exception;

import java.util.Date;

import javax.validation.ValidationException;

import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ibm.cio.dsw.webservices.restfulwebservice.user.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	public CustomizedResponseEntityExceptionHandler() {
		// TODO Auto-generated constructor stub
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Request Resource is not existed",
				request.getDescription(false));

		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				ex.getBindingResult().toString());

		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);

	}
}
