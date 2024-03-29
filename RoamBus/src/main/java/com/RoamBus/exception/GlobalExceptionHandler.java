package com.RoamBus.exception;

import java.time.LocalDateTime;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.RoamBus.access.exception.*;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), "Validation Error",
				me.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BusException.class)
	public ResponseEntity<MyErrorDetails> BusExceptionHandler(BusException be, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), be.getMessage(), req.getDescription(false));
		System.out.println("err   " + err);
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ReservationException.class)
	public ResponseEntity<MyErrorDetails> ReservationExceptionHandler(ReservationException re, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), re.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> UserExceptionHandler(UserException user, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), user.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RouteException.class)
	public ResponseEntity<MyErrorDetails> RouteExceptionHandler(RouteException route, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), route.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorDetails> myAdminExceptionHandler(AdminException ae, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ae.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<MyErrorDetails> myAdminExceptionHandler(HttpRequestMethodNotSupportedException ue,WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ue.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> myAdminExceptionHandler(LoginException le, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), le.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<MyErrorDetails> myAdminExceptionHandler(ConstraintViolationException le, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), le.getMessage(), req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

}
