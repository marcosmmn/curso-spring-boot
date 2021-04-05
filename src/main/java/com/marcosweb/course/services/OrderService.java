package com.marcosweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosweb.course.entities.Order;
import com.marcosweb.course.repositories.OrderRepository;


@Service //registrar como um componente do spring
public class OrderService {// camada de serviço
	
	@Autowired
	private OrderRepository repository;
	
	//faz o meio de campo entre o banco e o controller (model) (camada media)
	
	public List<Order> findAll(){
		return repository.findAll();	
	}
	
	public Order findById(Long id) { //antes de levar pro Resource, faz a requisição aqui
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}

}
