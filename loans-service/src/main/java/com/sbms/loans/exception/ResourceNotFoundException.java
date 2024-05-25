/**
 * Author: Sameera De Silva
 * User:anand
 * Date:25-05-2024
 * Time:04:17 pm
 */

package com.sbms.loans.exception;

public class ResourceNotFoundException extends RuntimeException{
   public ResourceNotFoundException(String message){
        super(message);
    }
}
