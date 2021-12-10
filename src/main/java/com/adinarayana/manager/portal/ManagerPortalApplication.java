package com.adinarayana.manager.portal;

import com.adinarayana.manager.portal.models.Manager;
import com.adinarayana.manager.portal.models.Role;
import com.adinarayana.manager.portal.repositories.ManagerRepository;
import com.adinarayana.manager.portal.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ManagerPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerPortalApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(RoleRepository roleRepository) {
		return args -> {
			//If we want to do something on startup of the application
			roleRepository.save(Role.builder().description("Admin Role - Able to add, delete, update , retrieve employees").name("ADMIN").build());
			roleRepository.save(Role.builder().description("Admin Trainee Role - Able to retrieve employees").name("ADMINTRAINEE").build());
		};
	}
}
