package com.cadastro.funcionario.service;

import java.util.List;
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
	
	
	public ResponseEntity<List<Departamento>> listarDepartamento() {
        List<Departamento> departamentos = departamentoRepository.findAll();
		
        if (departamentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(departamentos);
    }
	
	
	public ResponseEntity<Departamento> salvar(Departamento departamento) {
		if (departamento.getId() != null && departamentoRepository.existsById(departamento.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Departamento novoDepartamento = departamentoRepository.save(departamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoDepartamento);
    }
	
	
	 public ResponseEntity<Departamento> buscarPorId(Long id) {
	        return departamentoRepository.findById(id)
	                .map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    }
	 
	 

	public ResponseEntity<List<Departamento>> buscarPorNome(String nome) {
        List<Departamento> departamento = departamentoRepository.findAllByNomeContainingIgnoreCase(nome);
        if (departamento.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(departamento);
    }
	
	
	public ResponseEntity<Departamento> atualizarDepartamento(Long id, Departamento departamentoAtualizado) {
        return departamentoRepository.findById(id)
                .map(departamento -> {
                    departamento.setNome(departamentoAtualizado.getNome());
                    departamento.setDescricao(departamentoAtualizado.getDescricao()); // Corrigido
                    departamento.setDataCriacao(departamentoAtualizado.getDataCriacao());
                    departamento.setDataAtualizacao(departamentoAtualizado.getDataAtualizacao());

                    Departamento atualizado = departamentoRepository.save(departamento);
                    return ResponseEntity.ok(atualizado);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

	
	 public ResponseEntity<Void> deletar(Long id) {
	        if (!departamentoRepository.existsById(id)) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }

	        departamentoRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
}
