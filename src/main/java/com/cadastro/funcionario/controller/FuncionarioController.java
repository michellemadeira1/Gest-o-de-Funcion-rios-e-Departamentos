package com.cadastro.funcionario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.funcionario.model.Funcionario;
import com.cadastro.funcionario.service.FuncionarioService;

@RestController
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	
	public ResponseEntity<List<Funcionario>> listarTodos() {
        return funcionarioService.listarFuncionarios(null);
    }
    
	
	public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
        return funcionarioService.salvar(funcionario);
    }
	
	public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        return funcionarioService.buscarPorId(id);
    }
	
	 public ResponseEntity<List<Funcionario>> buscarPorNome(@PathVariable String nome) {
	        return funcionarioService.buscarPorNome(nome);
	    }
	 
	 public ResponseEntity<Object>deletar(@PathVariable Long id){
			return funcionarioService.deletar(id);
		}

}
