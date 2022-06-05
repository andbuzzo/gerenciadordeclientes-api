package com.andre.gerenciadordeclientes.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andre.gerenciadordeclientes.domain.Cliente;
import com.andre.gerenciadordeclientes.service.ClienteService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	ClienteService clienteService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) {

		try {
			Cliente obj = clienteService.findById(id);
			return ResponseEntity.ok().body(obj);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@GetMapping(value = "/c/{cpfOuCnpj}")
	public ResponseEntity<Cliente> findByCpfOuCnpj(@PathVariable String cpfOuCnpj) {
		try {
			Cliente obj = clienteService.findByCpfOuCnpj(cpfOuCnpj);
			return ResponseEntity.ok().body(obj);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@GetMapping(value = "/cidades/{id}")
	public ResponseEntity<List<Cliente>> findByCidade(@PathVariable Integer id) {

		try {
			List<Cliente> list = clienteService.findByCidade(id);
			return ResponseEntity.ok().body(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(
			@RequestParam(value = "cidade", defaultValue = "0") Integer cidade_id) {
		try {
			List<Cliente> list = clienteService.findAllAtivo();
			return ResponseEntity.ok().body(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Integer id, @Valid @RequestBody Cliente obj) {
		try {
			Cliente newObj = clienteService.update(id, obj);
			return ResponseEntity.ok().body(newObj);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@PutMapping(value = "status/{id}")
	public ResponseEntity<Cliente> updateIsAtivo(@PathVariable Integer id) {
		try {
			Cliente newObj = clienteService.updateIsAtivo(id);
			return ResponseEntity.ok().body(newObj);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@PostMapping
	public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente obj) {
		try {
			Cliente newObj = clienteService.create(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/clientes/{id}")
					.buildAndExpand(newObj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

}
