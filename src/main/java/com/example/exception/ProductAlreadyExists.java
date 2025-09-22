package com.example.exception;

public class ProductAlreadyExists extends Exception{
    public ProductAlreadyExists(String message){
        super(message);
    }
}
