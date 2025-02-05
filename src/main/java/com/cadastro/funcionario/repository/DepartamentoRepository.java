package com.cadastro.funcionario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cadastro.funcionario.model.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
	
	List<Departamento> findByNome(String nome);

	List<Departamento> findAllByNomeContainingIgnoreCase(String nome);
}
