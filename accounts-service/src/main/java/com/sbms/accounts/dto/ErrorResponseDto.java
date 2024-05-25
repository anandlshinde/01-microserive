/**
 * 
 */
package com.sbms.accounts.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author anand
 *
 */
@Data
@AllArgsConstructor
public class ErrorResponseDto {
	
	private HttpStatus errorCode;
	private String errorMessage;
	private LocalDateTime dateTime;

}
