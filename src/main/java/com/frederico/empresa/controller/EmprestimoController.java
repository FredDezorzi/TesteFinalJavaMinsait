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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.frederico.empresa.dto.EmprestimoDTO;
import com.frederico.empresa.entity.Emprestimo;
import com.frederico.empresa.exception.ClienteNaoEncontradoException;
import com.frederico.empresa.exception.EmprestimoNaoEncontradoException;
import com.frederico.empresa.exception.ValorLimiteExcedido;
import com.frederico.empresa.service.EmprestimoService;
import com.frederico.empresa.service.MensagemDeSucesso;


@RestController
@RequestMapping("/api/v1/empresa/clientes")
public class EmprestimoController {
	
	private EmprestimoService emprestimoService;
	
	@Autowired
	public EmprestimoController(EmprestimoService emprestimoService) {
		this.emprestimoService = emprestimoService;
	}

	// método para cadastrar um novo emprestimo de um cliente com base em um cpf
	@PostMapping("/{cpf}/emprestimos")
	@ResponseStatus(HttpStatus.CREATED)
	public Emprestimo cadastraEmprestimo(@PathVariable String cpf, @Valid @RequestBody EmprestimoDTO emprestimoDTO) throws ClienteNaoEncontradoException, ValorLimiteExcedido {
		
		return this.emprestimoService.cadastraEmprestimo(cpf,emprestimoDTO);
	}
	
	// método para deletar um emprestimo de um cliente com base em um cpf e id
	@DeleteMapping("/{cpf}/emprestimos/{id}")
	public ResponseEntity<MensagemDeSucesso> deletarCliente(@PathVariable String cpf,@PathVariable Long id) throws ClienteNaoEncontradoException, EmprestimoNaoEncontradoException{
		emprestimoService.deletarEmprestimo(cpf,id);
		MensagemDeSucesso mensagem = new MensagemDeSucesso("Emprestimo Excluido com Sucesso!!!");
		return ResponseEntity.ok(mensagem);
	}
	
	// método para retornar todos os um emprestimo de um cliente com base em um cpf
	@GetMapping("/{cpf}/emprestimos")
	public List <EmprestimoDTO> retornaEmprestimosPeloCpf(@PathVariable String cpf) throws ClienteNaoEncontradoException {
		List <EmprestimoDTO> retorno = this.emprestimoService.retornaEmprestimosPeloCpf(cpf);
		return retorno;
	}
	
	// método para retornar um emprestimo de um cliente com base em um cpf e id
	@GetMapping("/{cpf}/emprestimos/{id}")
	public EmprestimoDTO retornaEmprestimosPeloCpfeId(@PathVariable String cpf,@PathVariable Long id) throws ClienteNaoEncontradoException, EmprestimoNaoEncontradoException {
		EmprestimoDTO retorno = this.emprestimoService.retornaEmprestimo(cpf, id);
		return retorno;
	}
	
	
}
