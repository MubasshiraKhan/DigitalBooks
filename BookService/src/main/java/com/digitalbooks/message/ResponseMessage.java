package com.digitalbooks.message;

public class ResponseMessage {
	  private String message;
	  Boolean status;

	  public ResponseMessage(String message) {
	    this.message = message;
	  }
	  public ResponseMessage(String message ,Boolean status) {
		    this.message = message;
		    this.status=status;
		    
		    
		  }
	  public String getMessage() {
	    return message;
	  }

	  public void setMessage(String message) {
	    this.message = message;
	  }

	}
