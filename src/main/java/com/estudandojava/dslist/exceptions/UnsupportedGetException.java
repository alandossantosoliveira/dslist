package com.estudandojava.dslist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedGetException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public UnsupportedGetException(String ex) {
		super(ex);
	}
}
