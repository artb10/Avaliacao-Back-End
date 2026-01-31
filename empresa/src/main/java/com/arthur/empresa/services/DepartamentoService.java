package com.arthur.empresa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.arthur.empresa.entities.Departamento;
import com.arthur.empresa.exceptions.NaoEncontradoException;
import com.arthur.empresa.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository repository;
	
	public Departamento procurarPorId(Long Id){
		return repository.findById(Id).
				orElseThrow(() -> new NaoEncontradoException("ID Inválido! Usuário não encontrado."));
		
	}
	
}
