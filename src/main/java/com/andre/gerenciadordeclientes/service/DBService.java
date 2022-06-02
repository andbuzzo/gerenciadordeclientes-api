package com.andre.gerenciadordeclientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.gerenciadordeclientes.domain.Cidade;
import com.andre.gerenciadordeclientes.domain.Cliente;
import com.andre.gerenciadordeclientes.repositories.CidadeRepository;
import com.andre.gerenciadordeclientes.repositories.ClienteRepository;

@Service
public class DBService {
	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	public void instanciaBaseDeDados() {

		Cidade cidade = new Cidade(null, "Assis", "SP");

		Cliente cliente = new Cliente();
		cliente.setAtivo(true);
		cliente.setCpfOuCnpj("354.008.554-05");
		cliente.setNome("Jose laurindo");
		cliente.setCidade(cidade);

		this.cidadeRepository.save(cidade);
		this.clienteRepository.save(cliente);
	}

}
