package com.frederico.empresa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Classe que retorna uma exceção de emprestimo não encontrado
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmprestimoNaoEncontradoException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public EmprestimoNaoEncontradoException (Long id) {
		super (String.format("o Emprestimo %s nao foi encontrado para esse cliente",id));
	}
}
