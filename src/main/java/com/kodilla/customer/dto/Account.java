package com.kodilla.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long iddto;

    @Column(name = "nrb")
    private String nrb;

    @Column(name = "currency")
    private String currency;

    @Column(name = "available_funds")
    private double availableFunds;

    @Column(name = "customer_id")
    private Long idCustomer;

}