package com.arthur.empresa.exceptions;

public class DadosInvalidosException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public DadosInvalidosException(String msg) {
		super(msg);
	}

}
