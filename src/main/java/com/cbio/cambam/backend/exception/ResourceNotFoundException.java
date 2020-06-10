package com.cbio.cambam.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super("Cannot find the given resource");
	}
}
