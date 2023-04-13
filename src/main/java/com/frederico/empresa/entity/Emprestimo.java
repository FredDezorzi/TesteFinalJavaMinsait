package com.frederico.empresa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.frederico.empresa.tipos.Relacionamento;


@Entity
public class Emprestimo{
	
	// Atributos de Cliente + Validações dos mesmos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//Essa é uma atribuição para o relacionamento entre a tabela emprestimo e a tabela cliente(relação muitos para um)
	@ManyToOne
	@JoinColumn(name = "cliente_cpf", referencedColumnName = "cpf")
	private Cliente cliente;
	
	@Positive
	private BigDecimal valorInicial;
	
	private BigDecimal valorFinal;
	
	@NotNull
	private Relacionamento relacionamento;
	
	@NotNull
	private LocalDate dataInicial;
	
	@NotNull
	private LocalDate dataFinal;
	

	public Emprestimo() {
		
	}

	// Construtores de ClienteDTO
	public Emprestimo(Cliente cliente, BigDecimal valorInicial, Relacionamento relacionamento,
			LocalDate dataInicial, LocalDate dataFinal) {
		this.cliente = cliente;
		this.valorInicial = valorInicial;
		this.relacionamento = relacionamento;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	// Getters e Setters de Cliente
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public BigDecimal getValorInicial() {
		return valorInicial;
	}


	public void setValorInicial(BigDecimal valorInicial) {
		this.valorInicial = valorInicial;
	}

	public Relacionamento getRelacionamento() {
		return relacionamento;
	}

	public void setRelacionamento(Relacionamento relacionamento) {
		this.relacionamento = relacionamento;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}


	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	public BigDecimal getValorFinal() {
		return valorFinal;
	}
	
	// Chamada para setar valorFinal com base em um método da classe relacionamento
	public void setValorFinal() {
		if(this.valorInicial!= null) {
			this.valorFinal = this.relacionamento.calculaValorFinal(this);
		}
	}
	
}
