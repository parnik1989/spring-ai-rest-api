package com.eventsphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventsphere.entity.Customer;

@Repository
public interface CustomerRepository
        extends JpaRepository<Customer, Long> {
}
