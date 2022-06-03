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
		Optional<Cidade> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id:" + id + ", Tipo: " + Cidade.class.getName()));
	}
	
	public List<Cidade> findAll(){
		return repository.findAll();
	}
	
	public Cidade create(Cidade cidade) {
		cidade.setId(null);
		return repository.save(cidade);
	}
	
	public Cidade update(Integer id, Cidade cidade) {
		Cidade cidadeUpdate = findById(id);
		cidadeUpdate.setNome(cidade.getNome());
		cidadeUpdate.setUf(cidade.getUf());
		return repository.save(cidadeUpdate);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Cidade não pode ser deletada, possui clientes cadastrados!");
		}
	}
	
}
