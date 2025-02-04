package com.cadastro.funcionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.funcionario.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
