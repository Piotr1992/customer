package com.kodilla.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Getter
@Setter
public class AccountDto {

    private Long id;
    private String nrb;
    private String currency;
    private double availableFunds;
    private Long idCustomer;

}
