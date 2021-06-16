package com.kodilla.customer.provider;

import com.kodilla.customer.connector.CardsConnector;
import com.kodilla.customer.dto.CardDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardsProvider {
    private final CardsConnector accountsConnector;

    @HystrixCommand(fallbackMethod = "fallbackGetCards")
    public List<CardDto> getCustomerAccounts(Long customerId) {
        return accountsConnector.getCards(customerId)
                .getCards()
                .stream()
                .map(account -> new CardDto(
                                account.getId(),
                                account.getNrb(),
                                account.getCurrency(),
                                account.getAvailableFunds()
                        )
                )
//                .map(account -> new AccountDto())
                .collect(Collectors.toList());

/*
*
*     private Long id;
    private String nrb;
    private String currency;
    private double availableFunds;
*
* */

    }

    private List<CardDto> fallbackGetCards(Long customerId) {
        return Collections.emptyList();
    }

}