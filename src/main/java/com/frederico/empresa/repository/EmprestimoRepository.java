package com.frederico.empresa.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.frederico.empresa.entity.Cliente;
import com.frederico.empresa.entity.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{
	
	//metodos para implementar nas chamadas http
	Emprestimo findByCliente(Cliente cliente);
	List <Emprestimo> findAllByCliente(Cliente cliente);
	
	@Query("SELECT e.id FROM Emprestimo e WHERE e.id = :id AND e.cliente = :cliente")
    Long findIdByIdAndCpf(@Param("id") Long id, @Param("cliente") Cliente cliente);
	
    Emprestimo findEmprestimoByIdAndCliente(Long id, Cliente cliente) throws EmptyResultDataAccessException;

}
