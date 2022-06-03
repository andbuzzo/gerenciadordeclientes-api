package com.andre.gerenciadordeclientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.gerenciadordeclientes.domain.Cliente;
import com.andre.gerenciadordeclientes.repositories.ClienteRepository;
import com.andre.gerenciadordeclientes.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	CidadeService cidadeService;

	public Cliente findById(Integer id) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		return clienteOptional.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não enontrado!! ID: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	public Cliente findByCpfOuCnpj(String cpfOuCnpj) {
		Optional<Cliente> clienteOptional = clienteRepository.findByCpfOuCnpj(cpfOuCnpj);
		return clienteOptional.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não enontrado!! cpfOuCnpj: " + cpfOuCnpj + ", Tipo: " + Cliente.class.getName()));
	}
	
	public List<Cliente> findByCidade(Integer id_cidade) {
		return clienteRepository.findAllByCidade(id_cidade);
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente create(Cliente cliente) {
		cliente.setId(null);
		return clienteRepository.save(cliente);
	}

	public Cliente update(Integer id, Cliente cliente) {
		Cliente clienteUpdate = clienteRepository.getById(id);
		clienteUpdate.setNome(cliente.getNome());
		clienteUpdate.setCpfOuCnpj(cliente.getCpfOuCnpj());
		clienteUpdate.setAtivo(cliente.isAtivo());
		clienteUpdate.setBairro(cliente.getBairro());
		clienteUpdate.setEndereco(cliente.getEndereco());
		clienteUpdate.setEmail(cliente.getEmail());
		clienteUpdate.setNumero(cliente.getNumero());
		clienteUpdate.setTelefone(cliente.getTelefone());
		clienteUpdate.setCep(cliente.getCep());

		return clienteRepository.save(clienteUpdate);
	}

	public Cliente updateIsAtivo(Integer id) {
		Cliente clienteUpdate = clienteRepository.getById(id);
		if (clienteUpdate.isAtivo()) {
			clienteUpdate.setAtivo(false);
			return clienteRepository.save(clienteUpdate);
		}
		if (!clienteUpdate.isAtivo()) {
			clienteUpdate.setAtivo(true);
			return clienteRepository.save(clienteUpdate);
		}
		return clienteRepository.save(clienteUpdate);
	}

}
