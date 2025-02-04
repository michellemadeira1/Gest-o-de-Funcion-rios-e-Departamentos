package com.cadastro.funcionario.model;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Departamento {

	private Long id;
	private String nome;
	private String descriacao;
	private Date dataCriacao;
	private Date dataAtualizacao;
	
	
	public Departamento() {}
	
	
	public Departamento(Long id, String nome, String descriacao, Date dataCriacao, Date dataAtualizacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descriacao = descriacao;
		this.dataCriacao = dataCriacao;
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


	public String getDescriacao() {
		return descriacao;
	}


	public void setDescriacao(String descriacao) {
		this.descriacao = descriacao;
	}


	public Date getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}


	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	
	
	
}
