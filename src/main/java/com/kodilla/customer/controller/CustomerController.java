package com.kodilla.customer.controller;

import com.kodilla.customer.dto.CustomerDto;
import com.kodilla.customer.mapper.CustomerMapper;
import com.kodilla.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RefreshScope
@RestController
@RequestMapping(value = "/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    @Value("${application.allow-get-customer}")
    private boolean allowGetCustomers;

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @GetMapping(value = "/{customerId}")
    public GetCustomerResponse getCustomers(@PathVariable("customerId") Long customerId) {

        if(!allowGetCustomers) {
            log.info("Getting customer is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting customers is disabled");
        }

        CustomerDto customer = customerMapper.mapToCustomerDto(customerService.getCustomer(customerId).orElse(null));

        return GetCustomerResponse.of(customer);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCustomer(@RequestBody CustomerDto customer) {
        customerService.save(customerMapper.mapToCustomer(customer));
    }

}