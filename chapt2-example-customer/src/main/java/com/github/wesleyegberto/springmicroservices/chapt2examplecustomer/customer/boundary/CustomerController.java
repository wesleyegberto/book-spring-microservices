package com.github.wesleyegberto.springmicroservices.chapt2examplecustomer.customer.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.wesleyegberto.springmicroservices.chapt2examplecustomer.customer.control.CustomerRegister;
import com.github.wesleyegberto.springmicroservices.chapt2examplecustomer.customer.entity.Customer;

@RestController
   class CustomerController{
     @Autowired
     CustomerRegister customerRegistrar;
     
     @PostMapping("/register")
     Customer register(@RequestBody Customer customer){
       return customerRegistrar.register(customer);
     }
}