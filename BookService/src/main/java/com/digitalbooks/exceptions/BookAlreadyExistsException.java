package com.digitalbooks.exceptions;

public class BookAlreadyExistsException extends RuntimeException{
	private String message;
	public BookAlreadyExistsException() {}
	 
    public BookAlreadyExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
