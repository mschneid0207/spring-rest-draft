package de.mschneid.tutorial;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.mschneid.tutorial.dao.CustomerDao;
import de.mschneid.tutorial.entity.CustomerEntity;
import de.mschneid.tutorial.repository.CustomerRepository;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);

	}

	@Bean
	public CommandLineRunner demo(CustomerRepository customerRepository) {

		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				List<CustomerEntity> customerList = customerRepository.findByLastName("Bauer");
				customerList.forEach((c) -> System.out.println(c.getFirstName()));
				
				customerList = customerRepository.findByLastNameAndFirstName("Schneider", "Markus");
				customerList.forEach((c) -> System.out.println(c.getId()));
				
				customerList = customerRepository.findQueryByFirstName("Max");
				customerList.forEach((c) -> System.out.println("Firstname: " + c.getId()));
				
				CustomerEntity newCustomer = new CustomerEntity();
				newCustomer.setFirstName("Max");
				newCustomer.setLastName("Mustermann");
				newCustomer = customerRepository.save(newCustomer);
				System.out.println("Id of Max Mustermann: " + newCustomer.getId());
			}
		};
	}
	
	@Bean
	public CommandLineRunner demoWithDelegate(CustomerDao customerDao) {

		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				System.out.println("demoWithDelegate begins");
				
				CustomerEntity newCustomer = new CustomerEntity();
				newCustomer.setFirstName("Lukas");
				newCustomer.setLastName("Schneider");
				customerDao.saveCustomer(newCustomer);
				
			}
		};
	}
	
	
	
}
