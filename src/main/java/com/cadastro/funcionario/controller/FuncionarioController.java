package com.cadastro.funcionario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.funcionario.model.Funcionario;
import com.cadastro.funcionario.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> listarTodos() {
        return funcionarioService.listarFuncionarios(null);
    }
    
	@PostMapping
	public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
        return funcionarioService.salvar(funcionario);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        return funcionarioService.buscarPorId(id);
    }
	
	@GetMapping("/nome/{nome}")
	 public ResponseEntity<List<Funcionario>> buscarPorNome(@PathVariable String nome) {
	        return funcionarioService.buscarPorNome(nome);
	    }
	 
	@DeleteMapping("/{id}")
	 public ResponseEntity<Void> deletar(@PathVariable Long id){
			return funcionarioService.deletar(id);
		}

}
