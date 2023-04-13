package com.frederico.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frederico.empresa.entity.Cliente;

public interface ClienteRepository extends JpaRepository< Cliente, Long>{
	//metodos para implementar nas chamadas http
		boolean existsByCpf(String cpf);
		Cliente findByCpf(String cpf);
		void deleteByCpf(String cpf);
}
