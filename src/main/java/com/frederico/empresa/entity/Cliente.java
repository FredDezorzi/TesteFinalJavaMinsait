package com.frederico.empresa.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cliente implements Serializable{
	
	// Atributos de Cliente + Validações dos mesmos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;

	@Column(unique = true)
	//Esse é um regexp para validação de CPF
	@Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}", message = "CPF inválido")
	private String cpf;
	
	//Essa é uma atribuição para o relacionamento entre a tabela cliente e a tabela emprestimos(relação um para muitos)
	@JsonIgnore
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL)
	private Set<Emprestimo> emprestimos;
	
	//Esse é um regexp para validação de telefone
	@Pattern(regexp = "\\([1-9]{2}\\)\\d{4,5}\\-\\d{4}", message = "Telefone inválido")
	private String telefone;
	
	@NotNull
	private String rua;
	
	@NotNull
	private String numero;
	
	//Esse é um regexp para validação de CEP
	@Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP inválido")
	private String cep;
	
	@Positive
	private BigDecimal rendimentoMensal;

	public Cliente() {
	
	}

	// Construtores de ClienteDTO
	public Cliente(String nome, String cpf, String telefone, String rua, String numero,
			String cep, BigDecimal rendimentoMensal) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.rendimentoMensal = rendimentoMensal;
	}

	// Getters e Setters de Cliente
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
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public BigDecimal getRendimentoMensal() {
		return rendimentoMensal;
	}

	public void setRendimentoMensal(BigDecimal rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}	
	
	
	public Set<Emprestimo> getEmprestimos() { return emprestimos; }


	public void setEmprestimos(Set<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
}
