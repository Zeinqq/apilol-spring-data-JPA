package com.zein.apilol;

import com.zein.apilol.Entity.Customer;
import com.zein.apilol.Repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApilolApplication {

	private static final Logger log = LoggerFactory.getLogger(ApilolApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ApilolApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Ivan", "Volkov"));
			repository.save(new Customer("Dura", "XXX"));
			repository.save(new Customer("Suka", "Blyat"));
			repository.save(new Customer("Kim", "Kardashyan"));
			repository.save(new Customer("Pidor", "Blyat"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Blyat'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Blyat").forEach(blyat -> {
				log.info(blyat.toString());
			});
			log.info("");
		};
	}
}
