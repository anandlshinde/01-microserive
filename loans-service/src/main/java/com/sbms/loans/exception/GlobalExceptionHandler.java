/**
 * 
 */
package com.sbms.loans.exception;

import com.sbms.loans.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * @author anand
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(LoanAlreadyExistsException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResponseDto handleException(LoanAlreadyExistsException ex) {
		return new ErrorResponseDto(HttpStatus.BAD_REQUEST,ex.getMessage(),LocalDateTime.now());
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorResponseDto handleException(ResourceNotFoundException ex) {
		return new ErrorResponseDto(HttpStatus.NOT_FOUND,ex.getMessage(),LocalDateTime.now());
	}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponseDto handleException(Exception ex) {
		return new ErrorResponseDto(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage(),LocalDateTime.now());
	}
}
