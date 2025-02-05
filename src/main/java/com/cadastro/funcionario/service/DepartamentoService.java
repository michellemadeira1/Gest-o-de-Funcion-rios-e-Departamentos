package com.cadastro.funcionario.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cadastro.funcionario.model.Departamento;
import com.cadastro.funcionario.repository.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public ResponseEntity<List<Departamento>> listarFuncionarios(Departamento departamento){
		List<Departamento> departamentoExist = departamentoRepository.findByNome(departamento.getNome());
		
		if(departamentoExist.isEmpty()) {
			return ResponseEntity.status(406).build();
		}else {
			return ResponseEntity.status(200).body(departamentoExist);
		}
	}
	
	public ResponseEntity<Departamento> salvar(Departamento departamento) {
        if (departamento.getId() != null && departamentoRepository.findById(departamento.getId()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Departamento novoDepartamento = departamentoRepository.save(departamento);
        return ResponseEntity.ok(novoDepartamento);
    }
	
	public ResponseEntity<Departamento> buscarPorId(Long id) {
        Optional<Departamento> departamentoOptional = departamentoRepository.findById(id);
        if (departamentoOptional.isPresent()) {
            return ResponseEntity.ok(departamentoOptional.get()); 
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

	public  ResponseEntity<Departamento> AtualizarDepartamento (Long id, Departamento departamentoatualizado){
		 Optional<Departamento> departamentoOptional = departamentoRepository.findById(id);
		 if(departamentoOptional.isPresent()) {
			 Departamento departamento = departamentoOptional.get();
			 departamento.setNome( departamentoatualizado.getNome());
			 departamento.setDescriacao(departamentoatualizado.getDescriacao());
			 departamento.setDataCriacao(departamentoatualizado.getDataCriacao());
			 departamento.setDataAtualizacao(departamentoatualizado.getDataAtualizacao());
			 Departamento  departamentoatualizadoSalvo =  departamentoRepository.save( departamento);
		        return ResponseEntity.ok( departamentoatualizadoSalvo);
		 }else {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		    }		
	}
	
	public ResponseEntity<Object> deletar(Long id) {
	    Optional<Departamento> idExistente = departamentoRepository.findById(id);
	    if (idExistente.isEmpty()) {
	        return ResponseEntity.status(400).build();
	    } else {
	        departamentoRepository.deleteById(id);
	        return ResponseEntity.status(200).build();
	    }
	}
}
