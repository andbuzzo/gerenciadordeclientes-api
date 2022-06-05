package com.andre.gerenciadordeclientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.gerenciadordeclientes.domain.Cidade;
import com.andre.gerenciadordeclientes.repositories.CidadeRepository;
import com.andre.gerenciadordeclientes.service.exceptions.DataIntegrityViolationException;
import com.andre.gerenciadordeclientes.service.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;
	
	public Cidade findById(Integer id) {
		try {
			Optional<Cidade> obj = repository.findById(id);
			return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id:" + id + ", Tipo: " + Cidade.class.getName()));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public List<Cidade> findAll(){
		try {
			return repository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public Cidade create(Cidade cidade) {
		try {
			cidade.setId(null);
			return repository.save(cidade);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public Cidade update(Integer id, Cidade cidade) {
		try {
			Cidade cidadeUpdate = findById(id);
			cidadeUpdate.setNome(cidade.getNome());
			cidadeUpdate.setUf(cidade.getUf());
			return repository.save(cidadeUpdate);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public void delete(Integer id) {
		try {
			findById(id);
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Cidade não pode ser deletada, possui clientes cadastrados!");
		}
	}
	
}
