package com.arthur.empresa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthur.empresa.entities.Funcionario;
import com.arthur.empresa.exceptions.DadosInvalidosException;
import com.arthur.empresa.exceptions.NaoEncontradoException;
import com.arthur.empresa.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repository;
	
	public Funcionario procurarPorId(Long Id){
		return repository.findById(Id).
				orElseThrow(() -> new NaoEncontradoException("ID Inválido! Funcionario não encontrado."));
		
	}
	
	public List<Funcionario> procurarTodos(){
		List<Funcionario> listaFunc = repository.findAll();
		return listaFunc;
		
	}
	
	public String criarFuncionario(Funcionario func) {
		
		if (func.getEmail() == null || func.getEmail().isBlank()) {
			throw new DadosInvalidosException("Email é obrigatório.");
		}
		if(func.getNome() == null || func.getNome().isBlank()) {
			throw new DadosInvalidosException("Nome é obrigatório.");
		}
		
		repository.save(func);
		return "Funcionário salvo no sistema";
		
	}
	
	public String editarFuncionario(Long id, Funcionario func) {
		Funcionario response = procurarPorId(id);
		
		if(func.getEmail() != null) {
			response.setEmail(func.getEmail());
		}
		
		if(func.getNome() != null) {
			response.setNome(func.getNome());
		}
		
		repository.save(response);
		return "Funcionario atualizado com sucesso";
	}
	
	public String deletarFuncionario(Long id) {
		Funcionario response = procurarPorId(id);
		repository.delete(response);
		return "Funcionario deletado.";
	}
	
	
}
