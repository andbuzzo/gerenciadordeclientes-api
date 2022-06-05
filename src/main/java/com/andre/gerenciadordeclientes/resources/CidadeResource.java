package com.andre.gerenciadordeclientes.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andre.gerenciadordeclientes.domain.Cidade;
import com.andre.gerenciadordeclientes.service.CidadeService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {

	@Autowired
	private CidadeService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cidade> findById(@PathVariable Integer id) {
		try {
			Cidade obj = service.findById(id);
			return ResponseEntity.ok().body(obj);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@GetMapping
	public ResponseEntity<List<Cidade>> findAll() {
		try {
			List<Cidade> listCidade = service.findAll();
			return ResponseEntity.ok().body(listCidade);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@PostMapping
	public ResponseEntity<Cidade> create(@Valid @RequestBody Cidade obj) {
		try {
			obj = service.create(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
					.toUri();
			return ResponseEntity.created(uri).build();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Cidade> update(@Valid @PathVariable Integer id, @RequestBody Cidade obj) {
		try {
			Cidade newCidade = service.update(id, obj);
			return ResponseEntity.ok().body(newCidade);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		try {
			service.delete(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

}
