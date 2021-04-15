package com.marcosweb.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.marcosweb.course.entities.User;
import com.marcosweb.course.repositories.UserRepository;
import com.marcosweb.course.services.exceptions.DatabaseException;
import com.marcosweb.course.services.exceptions.ResourceNotFoundException;


@Service //registrar como um componente do spring
public class UserService {// camada de serviço
	
	@Autowired
	private UserRepository repository;
	
	//faz o meio de campo entre o banco e o controller (model) (camada media)
	
	public List<User> findAll(){
		return repository.findAll();	
	}
	
	public User findById(Long id) { //antes de levar pro Resource, faz a requisição aqui
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try {
		User entity = repository.getOne(id);
		updateData(entity,obj);
		return repository.save(entity);
		}catch(EntityNotFoundException e) {
			
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
			
	}

}
