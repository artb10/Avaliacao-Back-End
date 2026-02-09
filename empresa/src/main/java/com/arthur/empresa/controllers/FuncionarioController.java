package com.arthur.empresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthur.empresa.entities.Funcionario;
import com.arthur.empresa.services.FuncionarioService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;
	
	@Operation(summary = "Procurar funcionario por id",
			description = "Procura funcionarios somente pelo id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Funcionario> procurarPorId(@PathVariable Long id){
		Funcionario func = service.procurarPorId(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(func);
	}
	
	@Operation(summary = "Lista completa de funcionarios",
			description = "Metodo que retorna uma lista com todos os funcionarios")
	@GetMapping
	public ResponseEntity<List<Funcionario>> procurarTodos(){
		List<Funcionario> lista = service.procurarTodos();
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	@Operation(summary = "Adicionando funcionarios no sistema",
			description = "Metodo que adiciona novos funcionários ao sistema")
	@PostMapping
	public ResponseEntity<String> criarFuncionario(@RequestBody Funcionario func){
		String response = service.criarFuncionario(func);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@Operation(summary = "Editar funcionários",
			description = "Método que possibilita a edição das informações dos funcionários")
	@PutMapping(value = "/{id}")
	public ResponseEntity<String> editarFuncionario(@PathVariable Long id, @RequestBody Funcionario func){
		String resposta = service.editarFuncionario(id, func);
		return ResponseEntity.status(HttpStatus.OK).body(resposta);
	}
	
	@Operation(summary = "Deletar Funcionarios",
			description = "Método que deleta funcionários do sistema")
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<String> deletarFuncionario(@PathVariable Long id){
		String response = service.deletarFuncionario(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
