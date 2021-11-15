package com.unto.gulliver.traveller.backend.login;

import com.unto.gulliver.traveller.backend.login.repositories.UsuarioRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = UsuarioRepository.class)
public class GulliverTravellerBackendLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulliverTravellerBackendLoginApplication.class, args);
	}

}
