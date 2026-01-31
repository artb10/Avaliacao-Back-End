package com.arthur.empresa.exceptions;

public class NaoEncontradoException extends RuntimeException{
	private static final long serialVersionUid = 1L;
	
	public NaoEncontradoException(String msg) {
		super(msg);
	}

}
