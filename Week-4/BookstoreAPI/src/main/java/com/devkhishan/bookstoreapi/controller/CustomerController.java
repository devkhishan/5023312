package com.devkhishan.bookstoreapi.controller;

import com.devkhishan.bookstoreapi.dto.CustomerRegistrationDTO;
import com.devkhishan.bookstoreapi.model.Customer;
import com.devkhishan.bookstoreapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer createdCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@ModelAttribute CustomerRegistrationDTO registrationDTO){
        Customer customer = new Customer();
        customer.setName(registrationDTO.getName());
        customer.setEmail(registrationDTO.getEmail());

        Customer createdCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(createdCustomer,HttpStatus.CREATED);
    }
}
