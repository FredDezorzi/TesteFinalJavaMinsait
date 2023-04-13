package com.frederico.empresa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.frederico.empresa.dto.ClienteDTO;
import com.frederico.empresa.entity.Cliente;
import com.frederico.empresa.exception.ClienteJaExiste;
import com.frederico.empresa.exception.ClienteNaoEncontradoException;
import com.frederico.empresa.service.ClienteService;
import com.frederico.empresa.service.MensagemDeSucesso;

@RestController
@RequestMapping("/api/v1/empresa/clientes")
public class ClienteController {
	
	private ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	// método para cadastrar um novo cliente
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente cadastraCliente(@Valid @RequestBody Cliente cliente) throws ClienteJaExiste {
		return this.clienteService.cadastraCliente(cliente);
	}
	
	// método para retornar todos os clientes cadastrados
	@GetMapping()
	public List <ClienteDTO> retornaTodosOsClientes() {
		List <ClienteDTO> retorno = this.clienteService.retornaTodosOsClientes();
		return retorno;
	}
	
	// método para retornar um cliente específico pelo CPF
	@GetMapping("/{cpf}")
	public ClienteDTO retornaClientePeloCpf(@PathVariable String cpf) throws ClienteNaoEncontradoException{
		Cliente clienteRecuperado = this.clienteService.retornaClientePeloCpf(cpf);
		return ClienteDTO.retornaCliente(clienteRecuperado);
	}
	
	// método para deletar um cliente específico pelo CPF
	@DeleteMapping("/{cpf}")
	public ResponseEntity<MensagemDeSucesso> deletarCliente(@PathVariable String cpf) throws ClienteNaoEncontradoException{
		clienteService.deletarCliente(cpf);
		MensagemDeSucesso mensagem = new MensagemDeSucesso("Cliente Excluido com Sucesso!!!");
		return ResponseEntity.ok(mensagem);
	}
	
	// método para alterar um cliente específico pelo CPF
	@PutMapping("/{cpf}")
	public ClienteDTO alterarCliente (@PathVariable String cpf, @Valid @RequestBody ClienteDTO cliente) throws ClienteNaoEncontradoException {
		Cliente clienteRequest = ClienteDTO.retornaCliente(cliente);
		Cliente clienteAlterado = this.clienteService.alteraCliente(cpf, clienteRequest);
		return ClienteDTO.retornaCliente(clienteAlterado);
	}

}