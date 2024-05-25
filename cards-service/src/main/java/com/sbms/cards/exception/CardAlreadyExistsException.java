/**
 * Author: Sameera De Silva
 * User:anand
 * Date:25-05-2024
 * Time:03:04 pm
 */

package com.sbms.cards.exception;

public class CardAlreadyExistsException extends RuntimeException{
    public CardAlreadyExistsException(String message){
        super(message);
    }
}
