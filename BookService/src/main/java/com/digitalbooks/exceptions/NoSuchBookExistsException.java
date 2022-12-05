package com.digitalbooks.exceptions;

public class NoSuchBookExistsException extends RuntimeException {
 
    private String message;
 
    public NoSuchBookExistsException() {}
 
    public NoSuchBookExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    } 
	

}
