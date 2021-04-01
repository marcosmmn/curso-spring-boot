package com.marcosweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosweb.course.entities.User;
import com.marcosweb.course.repositories.UserRepository;


@Service //registrar como um componente do spring
public class UserService {// camada de serviço
	
	@Autowired
	private UserRepository repository;
	
	//faz o meio de campo entre o banco e o controller (model) (camada media)
	
	public List<User> findAll(){
		return repository.findAll();	
	}
	
	public User findById(Long id) { //cria aqui primeiro
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

}
