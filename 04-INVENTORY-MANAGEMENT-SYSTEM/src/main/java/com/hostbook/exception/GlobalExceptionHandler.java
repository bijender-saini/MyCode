package com.hostbook.exception;

import java.util.ArrayList;

import java.util.Optional;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.hostbook.response.ErrorResponse;
import com.hostbook.response.ResponseHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DataNotFoundException.class)
	ResponseEntity<ErrorResponse> InvalidSSNnumberexception(Exception ex)

	{

		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());

		ErrorResponse errorRespose = new ErrorResponse(new Date(), 400, details);

		return new ResponseEntity<ErrorResponse>(errorRespose, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleException(final Exception e, final WebRequest request) {
		// logger.error("Exception: {}", e);
		return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, e.getMessage());
	}

	@ExceptionHandler(BindException.class)
	public ResponseEntity<Object> handleBindException(BindException ex) {
		// logger.info("Exception of MethodArgumentNotValidException {} {} ", ex,
		// ex.getBindingResult());
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		Optional<FieldError> message = fieldErrors.stream().findFirst();
		if (message.isPresent()) {
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, message.get().getDefaultMessage());
		} else {
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, null);
		}
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		// logger.info("Exception of MethodArgumentNotValidException {} {} ", ex,
		// ex.getBindingResult());
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		Optional<FieldError> message = fieldErrors.stream().findFirst();
		return message
				.map(fieldError -> ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false,
						fieldError.getDefaultMessage()))
				.orElseGet(() -> ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, null));
	}

}
