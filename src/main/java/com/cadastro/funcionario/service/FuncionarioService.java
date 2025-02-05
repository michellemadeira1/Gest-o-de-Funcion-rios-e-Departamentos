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
        List<Funcionario> funcionariosExistentes = funcionarioRepository.findByNome(funcionario.getNome());
        
        if(funcionariosExistentes.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        } else {
            return ResponseEntity.ok(funcionariosExistentes);  
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
        List<Funcionario> funcionarios = funcionarioRepository.findAllByNomeContainingIgnoreCase(nome);
        if (funcionarios.isEmpty()) {
            return ResponseEntity.noContent().build();  
        }
        return ResponseEntity.ok(funcionarios);  
    }
    
    
    public ResponseEntity<Funcionario> atualizarFuncionario(Long id, Funcionario funcionarioAtualizado){
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
        if(funcionarioOptional.isPresent()) {
            Funcionario funcionario = funcionarioOptional.get();
            funcionario.setNome(funcionarioAtualizado.getNome());
            funcionario.setCpf(funcionarioAtualizado.getCpf());
            funcionario.setEmail(funcionarioAtualizado.getEmail());
            funcionario.setCargo(funcionarioAtualizado.getCargo());
            funcionario.setSalario(funcionarioAtualizado.getSalario());
            funcionario.setDataContratacao(funcionarioAtualizado.getDataContratacao());
            funcionario.setDataAtualizacao(funcionarioAtualizado.getDataAtualizacao());
            Funcionario funcionarioAtualizadoSalvo = funcionarioRepository.save(funcionario);
            return ResponseEntity.ok(funcionarioAtualizadoSalvo);  
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  
        }
    }
    
   
    public ResponseEntity<Void> deletar(Long id) {
        if (!funcionarioRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  
        }

        funcionarioRepository.deleteById(id); 
        return ResponseEntity.noContent().build();  
    }
}
