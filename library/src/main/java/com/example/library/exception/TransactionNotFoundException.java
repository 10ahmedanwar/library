package com.example.library.exception;


public class TransactionNotFoundException extends RuntimeException{

    public TransactionNotFoundException(String message){
        super(message);
    }


}
