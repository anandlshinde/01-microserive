/**
 * 
 */
package com.javaexpress.accounts.exception;

/**
 * @author anand
 *
 */
public class CustomerAlreadyExistsException extends RuntimeException{
	
	/**
	 * 
	 */
	public CustomerAlreadyExistsException(String message) {
		super(message);
	}

}
