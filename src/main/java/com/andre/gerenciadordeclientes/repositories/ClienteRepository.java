package com.andre.gerenciadordeclientes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.andre.gerenciadordeclientes.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	@Query("SELECT obj FROM Cliente obj WHERE obj.cidade.id = :cidade_id ORDER BY nome")
	List<Cliente> findAllByCidade(@Param(value = "cidade_id") Integer cidade_id);
	
	Optional<Cliente> findByCpfOuCnpj(String cpfOuCnpj);

}
