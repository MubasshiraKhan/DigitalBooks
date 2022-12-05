package com.digitalbooks.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value
            = NoSuchBookExistsException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public @ResponseBody ErrorResponse
handleException(NoSuchBookExistsException ex)
{
		 return new ErrorResponse(
		            HttpStatus.NOT_FOUND.value(), ex.getMessage());
}
}
