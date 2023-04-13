package com.frederico.empresa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Classe que retorna uma exceção de cliente não encontrado
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNaoEncontradoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public ClienteNaoEncontradoException (String CPF) {
		super (String.format("o cpf %s nao foi encontrado",CPF));
	}

}
