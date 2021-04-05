package com.marcosweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marcosweb.course.entities.User;
import com.marcosweb.course.repositories.UserRepository;

//classe de configurações de teste, usado pra testar o bd

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{//o command line é pra executar algo
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com",  "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
	} 
	
	

}
