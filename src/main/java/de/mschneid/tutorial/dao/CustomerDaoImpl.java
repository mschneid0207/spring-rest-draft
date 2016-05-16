package de.mschneid.tutorial.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.mschneid.tutorial.entity.CustomerEntity;
import de.mschneid.tutorial.repository.CustomerRepository;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void saveCustomer(CustomerEntity customer) {
		customerRepository.save(customer);
		System.out.println("New Customer was successfully saved with id: " + customer.getId());
	}

}
