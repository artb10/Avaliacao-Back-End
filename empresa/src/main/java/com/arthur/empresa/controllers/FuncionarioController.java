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


@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Funcionario> procurarPorId(@PathVariable Long id){
		Funcionario func = service.procurarPorId(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(func);
	}
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> procurarTodos(){
		List<Funcionario> lista = service.procurarTodos();
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
	@PostMapping
	public ResponseEntity<String> criarFuncionario(@PathVariable Long id, @RequestBody Funcionario func){
		String response = service.editarFuncionario(id, func);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<String> editarFuncionario(@PathVariable Long id, @RequestBody Funcionario func){
		String resposta = service.editarFuncionario(id, func);
		return ResponseEntity.status(HttpStatus.OK).body(resposta);
	}
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<String> deletarFuncionario(@PathVariable Long id){
		String response = service.deletarFuncionario(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
