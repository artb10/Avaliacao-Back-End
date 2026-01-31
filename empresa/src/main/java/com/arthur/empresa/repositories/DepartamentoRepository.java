package com.arthur.empresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arthur.empresa.entities.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
