package com.kodilla.customer.controller;

import com.kodilla.customer.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class GetCustomerResponse {

    private CustomerDto customer;

}