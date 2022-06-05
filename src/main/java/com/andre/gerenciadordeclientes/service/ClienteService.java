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
		try {
			Cliente cliente = clienteRepository.findByCpfOuCnpjAtivo(cpfOuCnpj);
			return cliente;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<Cliente> findByCidade(Integer id_cidade) {
		try {
			return clienteRepository.findAllByCidade(id_cidade);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public List<Cliente> findAllAtivo() {
		try {
			return clienteRepository.findAllAtivo();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<Cliente> findAllDasativado() {
		try {
			return clienteRepository.findAllDesativado();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public List<Cliente> findAll() {
		try {
			return clienteRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public Cliente create(Cliente obj) {
		try {
			obj.setId(null);
			obj.setAtivo(true);
			return clienteRepository.save(obj);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public Cliente update(Integer id, Cliente cliente) {
		try {
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
			clienteUpdate.setCidade(cliente.getCidade());

			return clienteRepository.save(clienteUpdate);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public Cliente updateIsAtivo(Integer id) {

		try {
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

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

}
