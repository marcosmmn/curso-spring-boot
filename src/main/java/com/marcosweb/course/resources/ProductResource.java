package com.marcosweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcosweb.course.entities.Product;
import com.marcosweb.course.services.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductResource { //camada de apresentação dos dados
	

	@Autowired //injeção automatica
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list); //view ultima camada (camada alta)
	}
	
	@GetMapping(value = "/{id}") 
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}