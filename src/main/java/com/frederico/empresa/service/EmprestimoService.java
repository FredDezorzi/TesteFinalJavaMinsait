package com.frederico.empresa.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frederico.empresa.dto.EmprestimoDTO;
import com.frederico.empresa.entity.Cliente;
import com.frederico.empresa.entity.Emprestimo;
import com.frederico.empresa.exception.ClienteNaoEncontradoException;
import com.frederico.empresa.exception.EmprestimoNaoEncontradoException;
import com.frederico.empresa.exception.ValorLimiteExcedido;
import com.frederico.empresa.repository.ClienteRepository;
import com.frederico.empresa.repository.EmprestimoRepository;

@Service
public class EmprestimoService {
	
	private EmprestimoRepository emprestimoRepository;
	
	private ClienteRepository clienteRepository;

	@Autowired
	public EmprestimoService(EmprestimoRepository emprestimoRepository, ClienteRepository clienteRepository) {
		this.emprestimoRepository = emprestimoRepository;
		this.clienteRepository = clienteRepository;
	}
	
	// método para cadastrar um novo emprestimo de um cliente com base em um cpf
	@Transactional
	public Emprestimo cadastraEmprestimo(String cpf, EmprestimoDTO emprestimoDTO) throws ClienteNaoEncontradoException, ValorLimiteExcedido {
		
		if(this.clienteRepository.existsByCpf(cpf)) {
			
			Cliente cliente = this.clienteRepository.findByCpf(cpf);
			BigDecimal valorTotal = new BigDecimal(0);
			
			for (Emprestimo emprestimo : cliente.getEmprestimos()) {
				valorTotal = valorTotal.add(emprestimo.getValorInicial());
		    }
			
			Emprestimo emprestimoCadastrado = EmprestimoDTO.retornaCliente(cliente, emprestimoDTO);	
			BigDecimal multiplicadorLimite = new BigDecimal(10);
			int limiteEmprestimo = valorTotal.add(emprestimoCadastrado.getValorInicial()).compareTo(cliente.getRendimentoMensal().multiply(multiplicadorLimite));
			
			if(limiteEmprestimo > 0) {
				throw new ValorLimiteExcedido(cliente.getRendimentoMensal().multiply(multiplicadorLimite));
			}
			emprestimoCadastrado.setValorFinal();
			return this.emprestimoRepository.save(emprestimoCadastrado);
		}
		throw new ClienteNaoEncontradoException(cpf);
	}  
	
	// método para deletar um emprestimo de um cliente com base em um cpf e id
	@Transactional 
	public void deletarEmprestimo(String cpf, Long id) throws ClienteNaoEncontradoException, EmprestimoNaoEncontradoException {
	    Cliente cliente = this.clienteRepository.findByCpf(cpf);
	    
		if(this.clienteRepository.existsByCpf(cpf)) {
			if(this.emprestimoRepository.findIdByIdAndCpf(id, cliente) != null) {
				this.emprestimoRepository.deleteById(id); 
			}else {
				throw new EmprestimoNaoEncontradoException(id);
			}
		}else{ 
			throw new ClienteNaoEncontradoException(cpf); 
			}
	}
	
	// método para retornar todos os um emprestimo de um cliente com base em um cpf
	public List<EmprestimoDTO> retornaEmprestimosPeloCpf(String cpf) throws ClienteNaoEncontradoException {
		
		if(this.clienteRepository.existsByCpf(cpf)) {
			Cliente cliente = this.clienteRepository.findByCpf(cpf);
			List<Emprestimo> emprestimos = this.emprestimoRepository.findAllByCliente(cliente);
			List<EmprestimoDTO> emprestimosDTO = new ArrayList();
			for(Emprestimo emprestimo : emprestimos) {
				EmprestimoDTO emprestimoDTO = EmprestimoDTO.retornaCliente(emprestimo);
				emprestimosDTO.add(emprestimoDTO);
			}
			return emprestimosDTO;
		}throw new ClienteNaoEncontradoException(cpf);
	}
	
	// método para retornar um emprestimo de um cliente com base em um cpf e id
	public EmprestimoDTO retornaEmprestimo(String cpf, Long id) throws ClienteNaoEncontradoException, EmprestimoNaoEncontradoException {
			
		if(this.clienteRepository.existsByCpf(cpf)) {
			Cliente cliente = this.clienteRepository.findByCpf(cpf);
			Emprestimo emprestimo = this.emprestimoRepository.findEmprestimoByIdAndCliente(id, cliente);
			if(emprestimo != null) {
			    EmprestimoDTO emprestimoDTO = EmprestimoDTO.retornaCliente(emprestimo);
			    return emprestimoDTO; 
			} throw new EmprestimoNaoEncontradoException(id);
		}throw new ClienteNaoEncontradoException(cpf); 
	 }
	
}
