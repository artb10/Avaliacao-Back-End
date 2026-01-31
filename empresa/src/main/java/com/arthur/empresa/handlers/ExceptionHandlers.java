package com.arthur.empresa.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.arthur.empresa.exceptions.DadosInvalidosException;
import com.arthur.empresa.exceptions.NaoEncontradoException;

@ControllerAdvice
public class ExceptionHandlers {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	@ExceptionHandler(NaoEncontradoException.class)
	public String usuarioNaoEncontrado(Exception ex) {
		return ex.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(DadosInvalidosException.class)
	public String dadosInvalidos(Exception ex) {
		return ex.getMessage();
	}
	
}
