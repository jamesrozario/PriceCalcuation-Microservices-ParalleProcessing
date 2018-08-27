package com.james.price.config;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
	 * ErrorMessage.
	 * 
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	//@Data
	public class ErrorMessage {

	    private int code;
	    private String message;
	    private String path;
	}
