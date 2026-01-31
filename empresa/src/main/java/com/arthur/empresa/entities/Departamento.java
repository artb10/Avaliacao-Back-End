package com.arthur.empresa.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "departamento")
	@JsonManagedReference
	private Set<Funcionario> funcionario;
	
	public Departamento() {
		super();
	}


	public Departamento(Long id, String nome, String email, Set<Funcionario> funcionario) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.funcionario = funcionario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Set<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}
	
}
