package com.kodilla.customer.repository;

import com.kodilla.customer.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Override
    List<Customer> findAll();

    @Override
    Customer save(Customer task);

    @Override
    Optional<Customer> findById(Long id);

    void deleteById(Long id);

}