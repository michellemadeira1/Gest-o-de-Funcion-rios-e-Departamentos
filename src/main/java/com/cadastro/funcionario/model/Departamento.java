package com.cadastro.funcionario.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
@Schema(description = "Representa um departamento dentro da organização")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "ID único do departamento", example = "1")
	private Long id;
	
	@NotNull
	@Schema(description = "Nome do departamento", example = "Recursos Humanos")
	private String nome;
	
	@NotNull
	@Schema(description = "Descrição do departamento", example = "Responsável pela gestão de pessoas.")
	private String descricao;
	
	@NotNull
	@Schema(description = "Data de criação do departamento", example = "2023-01-15T10:00:00Z")
	private Date dataCriacao;
	
	@NotNull
	@Schema(description = "Data da última atualização do departamento", example = "2023-01-15T10:00:00Z")
	private Date dataAtualizacao;
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "Funcionario_id")
	@Schema(description = "Funcionário responsável pelo departamento")
	private Funcionario funcionario;
	
	
	public Departamento() {}
	
	
	public Departamento(Long id, String nome, String descriacao, Date dataCricao, Date dataAtualizacao,Funcionario funcionario) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descriacao;
		this.dataCriacao = dataCricao;
		this.dataAtualizacao = dataAtualizacao;
		this.funcionario = funcionario;
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


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descriacao) {
		this.descricao = descriacao;
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


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
	
}
