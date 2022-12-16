package com.RoamBus3.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorDetails> myAdminExceptionHandler(AdminException ae,WebRequest req){
		
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),ae.getMessage(),req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
		
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> myLoginExceptionHandler(LoginException le,WebRequest req){
		
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),le.getMessage(),req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(BusException.class)
	public ResponseEntity<MyErrorDetails> myBusExceptionHandler(BusException be,WebRequest req){
		
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),be.getMessage(),req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(RouteException.class)
	public ResponseEntity<MyErrorDetails> myRouteExceptionHandler(RouteException re,WebRequest req){
		
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),re.getMessage(),req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
}
