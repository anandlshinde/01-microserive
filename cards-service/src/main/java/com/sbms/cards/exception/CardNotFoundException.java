/**
 * Author: Sameera De Silva
 * User:anand
 * Date:25-05-2024
 * Time:03:04 pm
 */

package com.sbms.cards.exception;

public class CardNotFoundException extends RuntimeException{
    public CardNotFoundException(String message){
        super(message);
    }
}
