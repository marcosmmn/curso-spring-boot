package com.marcosweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcosweb.course.entities.Order;

//aqui ja herda do jpa repository, não precisa da anotação repository
public interface OrderRepository extends JpaRepository<Order, Long> {
//camada que conecta ao banco (camada baixa)
//faz referencia a tabela User no banco de dados	
}
