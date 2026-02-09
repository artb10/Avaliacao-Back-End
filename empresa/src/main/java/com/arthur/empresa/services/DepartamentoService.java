package com.arthur.empresa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthur.empresa.entities.Departamento;
import com.arthur.empresa.exceptions.DadosInvalidosException;
import com.arthur.empresa.exceptions.NaoEncontradoException;
import com.arthur.empresa.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository repository;
	
	public Departamento procurarPorId(Long Id){
		return repository.findById(Id).
				orElseThrow(() -> new NaoEncontradoException("ID Inválido! Departamento não encontrado."));
		
	}
	
	public List<Departamento> procurarTodos(){
		List<Departamento> listaDpto = repository.findAll();
		return listaDpto;
		
	}
	
	public String criarDepartamento(Departamento dpto) {
		
		if (dpto.getEmail() == null || dpto.getEmail().isBlank()) {
			throw new DadosInvalidosException("Email é obrigatório.");
		}
		if(dpto.getNome() == null || dpto.getNome().isBlank()) {
			throw new DadosInvalidosException("Nome é obrigatório.");
		}
		
		repository.save(dpto);
		return "Departamento salvo no sistema";
		
	}
	
	public String editarDepartamento(Long id, Departamento dpto) {
		Departamento response = procurarPorId(id);
		
		if(dpto.getEmail() != null || !dpto.getEmail().isBlank()) {
			response.setEmail(dpto.getEmail());
		}
		
		if(dpto.getNome() != null || !dpto.getNome().isBlank()) {
			response.setNome(dpto.getNome());
		}
		
		repository.save(response);
		return "Departamento atualizado com sucesso";
	}
	
	public String deletarDepartamento(Long id) {
		Departamento response = procurarPorId(id);
		repository.delete(response);
		return "Departamento deletado.";
	}
}
