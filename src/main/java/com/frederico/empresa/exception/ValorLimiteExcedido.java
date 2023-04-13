package com.frederico.empresa.exception;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Classe que retorna uma exceção de valor de emprestimo excedido
@ResponseStatus(HttpStatus.CONFLICT)
public class ValorLimiteExcedido extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public ValorLimiteExcedido (BigDecimal limiteEmprestimo) {
		super (String.format("A soma total dos emprestimos não pode exceder %s",limiteEmprestimo.toString()));
	}

}
