package de.mschneid.tutorial;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.mschneid.tutorial.dao.CustomerDao;
import de.mschneid.tutorial.entity.AddressEntity;
import de.mschneid.tutorial.entity.CarEntity;
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
//				List<CustomerEntity> customerList = customerRepository.findByLastName("Bauer");
//				customerList.forEach((c) -> System.out.println(c.getFirstName()));
//				
//				customerList = customerRepository.findByLastNameAndFirstName("Schneider", "Markus");
//				customerList.forEach((c) -> System.out.println(c.getId()));
//				
//				customerList = customerRepository.findQueryByFirstName("Max");
//				customerList.forEach((c) -> System.out.println("Firstname: " + c.getId()));
				
				// new customer
				CustomerEntity newCustomer = new CustomerEntity();
				newCustomer.setFirstName("Max");
				newCustomer.setLastName("Mustermann");
				// address
				AddressEntity address = new AddressEntity();
				address.setZipCode("84339");
				newCustomer.setAddress(address);
				// list of cars
				CarEntity car = new CarEntity();
				car.setBrand("BMW");
				car.setRegistrationDate(new Date());
				Set<CarEntity> cars = new HashSet<CarEntity>();
				cars.add(car);
				newCustomer.setCars(cars);
				
				newCustomer = customerRepository.save(newCustomer);
				System.out.println("Id of Max Mustermann: " + newCustomer.getId());
				
//				CustomerEntity customerWithId24 = customerRepository.findById(31L);
//				customerRepository.delete(customerWithId24);
				//System.out.println(customerWithId24);
				
			}
		};
	}
	
	@Bean
	public CommandLineRunner demoWithDelegate(CustomerDao customerDao) {

		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				System.out.println("demoWithDelegate begins");
				
//				CustomerEntity newCustomer = new CustomerEntity();
//				newCustomer.setFirstName("Lukas");
//				newCustomer.setLastName("Schneider");
//				customerDao.saveCustomer(newCustomer);
				
			}
		};
	}
	
	
	
}
