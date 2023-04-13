package com.frederico.empresa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Classe que retorna uma exceção de cliente já existente
@ResponseStatus(HttpStatus.CONFLICT)
public class ClienteJaExiste  extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ClienteJaExiste (String cpf) {
		super (String.format("Já existe um cliente com o cpf %s",cpf));
	}
}
