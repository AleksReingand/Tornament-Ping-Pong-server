package com.airdr.pingpong.exception;


public class ResponseException extends RuntimeException{

	public ResponseException(String message)
	{
		super(message);
	}
	
	public ResponseException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
