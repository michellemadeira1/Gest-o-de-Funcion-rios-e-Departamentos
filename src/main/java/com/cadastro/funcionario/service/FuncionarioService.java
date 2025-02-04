package com.cadastro.funcionario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cadastro.funcionario.model.Funcionario;
import com.cadastro.funcionario.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	
	
	public ResponseEntity<List<Funcionario>> listarFuncionarios(Funcionario funcionario){
		List<Funcionario> funcionarioExist = funcionarioRepository.findByNome(funcionario.getNome());
		
		if(funcionarioExist.isEmpty()) {
			return ResponseEntity.status(406).build();
		}else {
			return ResponseEntity.status(200).body(funcionarioExist);
		}
	}
	
	
	public ResponseEntity<Funcionario> salvar(Funcionario funcionario) {
        if (funcionario.getId() != null && funcionarioRepository.findById(funcionario.getId()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Funcionario novoFuncionario = funcionarioRepository.save(funcionario);
        return ResponseEntity.ok(novoFuncionario);
    }
	
	
	public ResponseEntity<Funcionario> buscarPorId(Long id) {
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
        if (funcionarioOptional.isPresent()) {
            return ResponseEntity.ok(funcionarioOptional.get()); 
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
	
	
	public ResponseEntity<List<Funcionario>> buscarPorNome(String nome) {
        List<Funcionario> funcionario = funcionarioRepository.findAllByNomeContainingIgnoreCase(nome);
        if (funcionario.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(funcionario);
    }
	
	
	public  ResponseEntity<Funcionario> AtualizarFuncionario (Long id, Funcionario funcionarioatualizado){
		 Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
		 if(funcionarioOptional.isPresent()) {
			 Funcionario funcionario = funcionarioOptional.get();
			 funcionario.setNome(funcionarioatualizado.getNome());
			 funcionario.setCpf(funcionarioatualizado.getCpf());
			 funcionario.setEmail(funcionarioatualizado.getEmail());
			 funcionario.setCargo(funcionarioatualizado.getCargo());
			 funcionario.setSalario(funcionarioatualizado.getSalario());
			 funcionario.setDataContratacao(funcionarioatualizado.getDataContratacao());
			 funcionario.setDataAtualizacao(funcionarioatualizado.getDataAtualizacao());
			 Funcionario funcionarioatualizadoSalvo = funcionarioRepository.save(funcionario);
		        return ResponseEntity.ok(funcionarioatualizadoSalvo);
		 }else {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		    }		
	}
	
	
	public ResponseEntity<Object> deletar(Long id) {
	    Optional<Funcionario> idExistente = funcionarioRepository.findById(id);
	    if (idExistente.isEmpty()) {
	        return ResponseEntity.status(400).build();
	    } else {
	        funcionarioRepository.deleteById(id);
	        return ResponseEntity.status(200).build();
	    }
	}
}
