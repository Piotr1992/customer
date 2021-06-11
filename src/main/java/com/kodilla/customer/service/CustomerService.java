package com.kodilla.customer.service;

import com.kodilla.customer.dto.Customer;
import com.kodilla.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Optional<Customer> getCustomer(final Long id) { return repository.findById(id); }

    public void save(Customer customer) { repository.save(customer); }

}
