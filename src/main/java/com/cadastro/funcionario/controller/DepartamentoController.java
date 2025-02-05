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



@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;

	@GetMapping
	public ResponseEntity<List<Departamento>> listarTodos() {
        return departamentoService.listarDepartamento();
    }
    
	@PostMapping
	public ResponseEntity<Departamento> salvar(@RequestBody Departamento departamento) {
        return departamentoService.salvar(departamento);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Departamento> buscarPorId(@PathVariable Long id) {
        return departamentoService.buscarPorId(id);
    }
	
	@GetMapping("/nome/{nome}")
	 public ResponseEntity<List<Departamento>> buscarPorNome(@PathVariable String nome) {
	        return departamentoService.buscarPorNome(nome);
	    }
	 
	@DeleteMapping("/{id}")
	 public ResponseEntity<Void> deletar(@PathVariable Long id){
			return departamentoService.deletar(id);
		}
}
