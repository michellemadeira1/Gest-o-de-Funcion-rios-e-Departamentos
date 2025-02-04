package com.cadastro.funcionario.model;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Funcionario {

	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private String cargo;
	private String salario;
	private Date dataContratacao;
	private Date dataAtualizacao;
	
	
	
	
	public Funcionario() {}
	
	
	public Funcionario(Long id, String nome, String cpf, String email, String cargo, String salario,
			Date dataContratacao, Date dataAtualizacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.cargo = cargo;
		this.salario = salario;
		this.dataContratacao = dataContratacao;
		this.dataAtualizacao = dataAtualizacao;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getSalario() {
		return salario;
	}


	public void setSalario(String salario) {
		this.salario = salario;
	}


	public Date getDataContratacao() {
		return dataContratacao;
	}


	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}


	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}


	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	
	
	
	
}
