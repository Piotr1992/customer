package com.kodilla.customer.service;

import com.kodilla.customer.dto.Account;
import com.kodilla.customer.dto.AccountDto;
import com.kodilla.customer.dto.CardDto;
import com.kodilla.customer.provider.AccountsProvider;
import com.kodilla.customer.provider.CardsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final AccountsProvider accountProvider;

    private final CardsProvider cardsProvider;

    public List<AccountDto> findCustomerAccounts(Long customerId) {
        return accountProvider.getCustomerAccounts(customerId);
    }

/*    public Optional<AccountDto> findCustomerAccount2(Long customerId) {
        return accountProvider.getCustomerAccount2(customerId);
    }               */

    public List<CardDto> findCustomerCards(Long customerId) {
        return cardsProvider.getCustomerCards(customerId);
    }

}