package com.github.wesleyegberto.springmicroservices.chapt2examplecustomer.customer.control;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.github.wesleyegberto.springmicroservices.chapt2examplecustomer.customer.entity.Customer;

@RepositoryRestResource
public interface CustomerRespository extends JpaRepository<Customer, Long> {
	Optional<Customer> findByName(@Param("name") String name);
}
