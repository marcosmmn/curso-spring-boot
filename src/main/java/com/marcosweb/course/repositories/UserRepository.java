package com.marcosweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcosweb.course.entities.User;

//aqui ja herda do jpa repository, não precisa da anotação repository
public interface UserRepository extends JpaRepository<User, Long> {
//camada que conecta ao banco (camada baixa)
}
