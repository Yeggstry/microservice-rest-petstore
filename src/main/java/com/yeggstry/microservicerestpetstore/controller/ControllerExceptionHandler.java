package com.yeggstry.microservicerestpetstore.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.yeggstry.microservicerestpetstore.exception.PetNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler({ ConversionFailedException.class, IllegalArgumentException.class,
			DataIntegrityViolationException.class, HttpMessageNotReadableException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		var errors = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			errors.put(((FieldError) error).getField(), error.getDefaultMessage());
		});
		return errors;
	}

	@ExceptionHandler(PetNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<String> handlePetNotFound(RuntimeException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}