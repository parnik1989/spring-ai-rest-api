package com.eventsphere.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventsphere.entity.Customer;
import com.eventsphere.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/createCustomer")
    public Customer create(@RequestBody Customer customer) {

        return service.create(customer);
    }

    @GetMapping("/getAll")
    public List<Customer> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public Customer getById(
            @PathVariable Long id) {

        return service.getById(id);
    }
}
