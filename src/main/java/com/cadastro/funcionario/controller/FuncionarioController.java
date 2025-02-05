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

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@Operation(description = "Retorna uma lista de todos os funcionarios cadastrados.")
	@GetMapping
	public ResponseEntity<List<Funcionario>> listarTodos() {
        return funcionarioService.listarFuncionarios(null);
    }
    
	@Operation(description = "Cria um novo funcionário com os dados fornecidos.")
	@PostMapping
	public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
        return funcionarioService.salvar(funcionario);
    }
	
	@Operation(description = "Retorna o funcionário correspondente ao ID fornecido.")
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        return funcionarioService.buscarPorId(id);
    }
	
	@Operation(description = "Retorna uma lista de funcionários cujo nome contenha o valor fornecido.")
	@GetMapping("/nome/{nome}")
	 public ResponseEntity<List<Funcionario>> buscarPorNome(@PathVariable String nome) {
	        return funcionarioService.buscarPorNome(nome);
	    }
	 
	@Operation(description = "Deleta o funcionário correspondente ao ID fornecido.")
	@DeleteMapping("/{id}")
	 public ResponseEntity<Void> deletar(@PathVariable Long id){
			return funcionarioService.deletar(id);
		}

}
