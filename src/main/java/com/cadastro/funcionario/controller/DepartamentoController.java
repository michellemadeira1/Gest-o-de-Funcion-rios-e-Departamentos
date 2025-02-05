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
import com.cadastro.funcionario.model.Departamento;
import com.cadastro.funcionario.service.DepartamentoService;

import io.swagger.v3.oas.annotations.Operation;



@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;

	@Operation(description = "Retorna uma lista de todos os departamentos cadastrados.")
	@GetMapping
	public ResponseEntity<List<Departamento>> listarTodos() {
        return departamentoService.listarDepartamento();
    }
    
	@Operation(description = "Cria um novo departamento com os dados fornecidos.")
	@PostMapping
	public ResponseEntity<Departamento> salvar(@RequestBody Departamento departamento) {
        return departamentoService.salvar(departamento);
    }
	
	@Operation(description = "Retorna o departamento correspondente ao ID fornecido.")
	@GetMapping("/{id}")
	public ResponseEntity<Departamento> buscarPorId(@PathVariable Long id) {
        return departamentoService.buscarPorId(id);
    }
	
	@Operation(description = "Retorna uma lista de departamentos cujo nome contenha o valor fornecido.")
	@GetMapping("/nome/{nome}")
	 public ResponseEntity<List<Departamento>> buscarPorNome(@PathVariable String nome) {
	        return departamentoService.buscarPorNome(nome);
	    }
	 
	@Operation(description = "Deleta o departamento correspondente ao ID fornecido.") 
	@DeleteMapping("/{id}")
	 public ResponseEntity<Void> deletar(@PathVariable Long id){
			return departamentoService.deletar(id);
		}
}
