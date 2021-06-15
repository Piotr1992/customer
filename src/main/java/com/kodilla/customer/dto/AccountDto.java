package com.kodilla.customer.dto;

import lombok.Data;

@Data
public class AccountDto {

    private Long id;
    private String nrb;
    private String currency;
    private double availableFunds;

}
