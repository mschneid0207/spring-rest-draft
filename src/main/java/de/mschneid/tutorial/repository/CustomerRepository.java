package de.mschneid.tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import de.mschneid.tutorial.entity.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

	List<CustomerEntity> findByLastName(String lastName);
	List<CustomerEntity> findByLastNameAndFirstName(String lastName, String firstName);
	CustomerEntity findById(Long id);
	
	@Query("from customer c where c.firstName = ?")
	List<CustomerEntity> findQueryByFirstName(String firstName);

}
