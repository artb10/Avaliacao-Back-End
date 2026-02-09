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
import com.arthur.empresa.entities.Departamento;
import com.arthur.empresa.services.DepartamentoService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/departamento")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService service;
	
	@Operation(summary = "Procurar departamento por id",
			description = "Procura departamentos somente pelo id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Departamento> procurarPorId(@PathVariable Long id){
		Departamento dpto = service.procurarPorId(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(dpto);
	}
	
	@Operation(summary = "Lista completa de departamentos",
			description = "Metodo que retorna uma lista com todos os departamentos")
	@GetMapping
	public ResponseEntity<List<Departamento>> procurarTodos(){
		List<Departamento> lista = service.procurarTodos();
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
	@Operation(summary = "Adicionando departamentos no sistema",
			description = "Metodo que adiciona novos departamentos ao sistema")
	@PostMapping
	public ResponseEntity<String> criarDepartamento(@RequestBody Departamento dpto){
		String response = service.criarDepartamento(dpto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@Operation(summary = "Editar departamentos",
			description = "Método que possibilita a edição das informações dos departamentos")
	@PutMapping(value = "/{id}")
	public ResponseEntity<String> editarDepartamento(@PathVariable Long id, @RequestBody Departamento dpto){
		String resposta = service.editarDepartamento(id, dpto);
		return ResponseEntity.status(HttpStatus.OK).body(resposta);
	}
	
	@Operation(summary = "Deletar departamentos",
			description = "Método que deleta departamentos do sistema")
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<String> deletarDepartamento(@PathVariable Long id){
		String response = service.deletarDepartamento(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
}
