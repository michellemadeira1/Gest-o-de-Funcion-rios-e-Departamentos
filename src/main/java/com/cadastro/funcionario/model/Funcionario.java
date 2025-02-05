package com.cadastro.funcionario.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String cpf;
	
	@NotNull
	 @Email
	private String email;
	
	@NotNull
	private String cargo;
	
	@NotNull
	private String salario;
	
	@NotNull
	private Date dataContratacao;
	
	@NotNull
	private Date dataAtualizacao;
	
	
	@OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("funcionario")
	 private List<Departamento> departamento;
	
	 
	public Funcionario() {}
	
	
	public Funcionario(Long id, String nome, String cpf, String email, String cargo, String salario,
			Date dataContratacao, Date dataAtualizacao, List<Departamento> departamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.cargo = cargo;
		this.salario = salario;
		this.dataContratacao = dataContratacao;
		this.dataAtualizacao = dataAtualizacao;
		this.departamento = departamento;
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


	public List<Departamento> getDepartamento() {
		return departamento;
	}


	public void setDepartamento(List<Departamento> departamento) {
		this.departamento = departamento;
	}
	
	
	
	
	
}
