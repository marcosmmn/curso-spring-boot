package com.marcosweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosweb.course.entities.Category;
import com.marcosweb.course.repositories.CategoryRepository;


@Service //registrar como um componente do spring
public class CategoryService {// camada de serviço
	
	@Autowired
	private CategoryRepository repository;
	
	//faz o meio de campo entre o banco e o controller (model) (camada media)
	
	public List<Category> findAll(){
		return repository.findAll();	
	}
	
	public Category findById(Long id) { //antes de levar pro Resource, faz a requisição aqui
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}

}
