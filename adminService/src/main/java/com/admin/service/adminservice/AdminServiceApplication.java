package com.admin.service.adminservice;

import com.admin.service.adminservice.model.User;
import com.admin.service.adminservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AdminServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);
	}

	private final UserRepository userRepository;

	public AdminServiceApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("Anand", "Anand123", "anand@gmail.com", "1234"));
		userRepository.save(new User("Harsh", "Harsh123", "harsh@gmail.com", "2534"));
		userRepository.save(new User("Ankit", "Ankit123", "ankit@gmail.com", "1784"));
		userRepository.save(new User("Sahil", "Sahil123", "sahil@gmail.com", "4854"));

		userRepository.findAll().forEach(System.out::println);
	}
}
