 package com.frederico.empresa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frederico.empresa.dto.ClienteDTO;
import com.frederico.empresa.entity.Cliente;
import com.frederico.empresa.exception.ClienteJaExiste;
import com.frederico.empresa.exception.ClienteNaoEncontradoException;
import com.frederico.empresa.repository.ClienteRepository;

@Service
public class ClienteService{
	
	private ClienteRepository clienteRepository;
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		
		this.clienteRepository = clienteRepository;
	}

	// método para cadastrar um novo cliente
	public Cliente cadastraCliente(Cliente cliente) throws ClienteJaExiste {
		String cpf = cliente.getCpf();
		if(this.clienteRepository.existsByCpf(cpf)) {
			throw new ClienteJaExiste(cpf);
		}
		return this.clienteRepository.save(cliente);
	}
	
	// método para retornar todos os clientes cadastrados
	public List<ClienteDTO> retornaTodosOsClientes(){
		
		List<Cliente> clientes = this.clienteRepository.findAll();
		List<ClienteDTO> clientesDTO = new ArrayList<>();
		for(Cliente cliente : clientes) {
			ClienteDTO clienteDTO = ClienteDTO.retornaCliente(cliente);
			clientesDTO.add(clienteDTO);
		}
		return clientesDTO;
	}
	
	// método para retornar um cliente específico pelo CPF
	public Cliente retornaClientePeloCpf(String cpf) throws ClienteNaoEncontradoException {
		
		if(this.clienteRepository.existsByCpf(cpf)) {
			return this.clienteRepository.findByCpf(cpf);
		}
		throw new ClienteNaoEncontradoException(cpf);
	}
	
	// método para deletar um cliente específico pelo CPF
	@Transactional
	public void deletarCliente(String cpf) throws ClienteNaoEncontradoException {
		
		if(this.clienteRepository.existsByCpf(cpf)) {
			this.clienteRepository.deleteByCpf(cpf);
		}else{
			throw new ClienteNaoEncontradoException(cpf);
		}
	}
	
	// método para alterar um cliente específico pelo CPF
	public Cliente alteraCliente(String cpf, @Valid Cliente cliente) throws ClienteNaoEncontradoException {

		if(this.clienteRepository.existsByCpf(cpf)) {
			Cliente clienteASerAlterado = this.clienteRepository.findByCpf(cpf);
			cliente.setId(clienteASerAlterado.getId());
			cliente.setCpf(cpf);	
			return this.clienteRepository.save(cliente);
		}
			throw new ClienteNaoEncontradoException(cpf);	
	}
}
