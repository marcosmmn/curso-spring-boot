package com.marcosweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosweb.course.entities.Product;
import com.marcosweb.course.repositories.ProductRepository;


@Service //registrar como um componente do spring
public class ProductService {// camada de serviço
	
	@Autowired
	private ProductRepository repository;
	
	//faz o meio de campo entre o banco e o controller (model) (camada media)
	
	public List<Product> findAll(){
		return repository.findAll();	
	}
	
	public Product findById(Long id) { //antes de levar pro Resource, faz a requisição aqui
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}

}
