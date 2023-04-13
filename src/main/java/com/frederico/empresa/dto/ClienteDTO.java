package com.frederico.empresa.dto;

import java.math.BigDecimal;
import java.util.List;

import com.frederico.empresa.entity.Cliente;

public class ClienteDTO {
	
	// Atributos de ClienteDTO
	private String nome;

	private String cpf;
	
	private String telefone;
	
	private String rua;
	
	private String numero;

	private String cep;
	
	private BigDecimal rendimentoMensal;

	// Construtores de ClienteDTO
	public ClienteDTO(String nome, String cpf, String telefone, String rua, String numero,
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
	
	// método para trasnformar um Cliente em CLienteDTO
	public static ClienteDTO retornaCliente(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO(cliente.getNome(),cliente.getCpf(), cliente.getTelefone(), cliente.getRua(), 
				cliente.getNumero(), cliente.getCep(), cliente.getRendimentoMensal());
		return clienteDTO;
	}
	
	// método para trasnformar um ClienteDTO em CLiente
	public static Cliente retornaCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente(clienteDTO.getNome(), clienteDTO.getCpf(), clienteDTO.getTelefone(), clienteDTO.getRua(), 
				clienteDTO.getNumero(), clienteDTO.getCep(), clienteDTO.getRendimentoMensal());
		return cliente;
	}

	// Getters e Setters de ClienteDTO
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
	
}
