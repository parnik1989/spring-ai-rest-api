package com.eventsphere.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eventsphere.entity.Customer;
import com.eventsphere.repositories.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> getAll() {
        return repository.findAll();
    }

    public Customer getById(Long id) {
        return repository.findById(id)
                .orElseThrow();
    }
}
