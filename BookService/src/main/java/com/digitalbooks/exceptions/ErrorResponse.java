package com.digitalbooks.exceptions;


public class ErrorResponse {
	private int statusCode;
    private String message;
 
    public ErrorResponse(int i, String message)
    {
        super();
        this.message = message;
    }
}
