package com.devkhishan.bookstoreapi.repository;

import com.devkhishan.bookstoreapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
}
