package com.frederico.empresa.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.frederico.empresa.entity.Cliente;
import com.frederico.empresa.entity.Emprestimo;
import com.frederico.empresa.tipos.Relacionamento;

public class EmprestimoDTO {
	
	// Atributos de EmprestimoDTO
	private BigDecimal valorInicial;
	
	private BigDecimal valorFinal;
	
	private Relacionamento relacionamento;
	
	private LocalDate dataInicial;
	
	private LocalDate dataFinal;

	// Construtores de EmprestimoDTO
	public EmprestimoDTO(BigDecimal valorInicial,BigDecimal valorFinal, Relacionamento relacionamento, LocalDate dataInicial,
			LocalDate dataFinal) {
		this.valorInicial = valorInicial;
		this.valorFinal = valorFinal;
		this.relacionamento = relacionamento;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}
	
	// método para trasnformar um Emprestimo em EmprestimoDTO
	public static EmprestimoDTO retornaCliente(Emprestimo emprestimo) {
		EmprestimoDTO emprestimoDTO = new EmprestimoDTO(emprestimo.getValorInicial(),emprestimo.getValorFinal(),emprestimo.getRelacionamento(),
				emprestimo.getDataInicial(),emprestimo.getDataFinal());
		return emprestimoDTO;
	}
	
	// método para trasnformar um EmprestimoDTO em Emprestimo
	public static Emprestimo retornaCliente(Cliente cliente, EmprestimoDTO emprestimoDTO) {
		Emprestimo emprestimo = new Emprestimo(cliente, emprestimoDTO.getValorInicial(), emprestimoDTO.getRelacionamento(),
				emprestimoDTO.getDataInicial(), emprestimoDTO.getDataFinal());
		return emprestimo;
	}
	
	// Getters e Setters de EmpretestimoDTO
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

	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}	
	
	
}
