package com.marcosweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcosweb.course.entities.OrderItem;

//aqui ja herda do jpa repository, não precisa da anotação repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
//camada que conecta ao banco (camada baixa)
//faz referencia a tabela User no banco de dados	
}
