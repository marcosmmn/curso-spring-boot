package com.marcosweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcosweb.course.entities.Category;

//aqui ja herda do jpa repository, não precisa da anotação repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
//camada que conecta ao banco (camada baixa)
//faz referencia a tabela User no banco de dados	
}
