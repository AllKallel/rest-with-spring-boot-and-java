package com.example.demo.exceptions;

import java.io.Serializable;
import java.util.Date;


public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date timestamp;
	private String massege;
	private String details;
	
	public ExceptionResponse(Date timestamp, String massege, String details) {
		this.timestamp = timestamp;
		this.massege = massege;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMassege() {
		return massege;
	}

	public String getDetails() {
		return details;
	}
	
	
}
