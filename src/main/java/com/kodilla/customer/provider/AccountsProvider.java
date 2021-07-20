package com.kodilla.customer.provider;

import com.kodilla.customer.connector.AccountsConnector;
import com.kodilla.customer.dto.Account;
import com.kodilla.customer.dto.AccountDto;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountsProvider {

    private final AccountsConnector accountsConnector;

//    public final Logger log = Logger.getLogger(getClass().getName());
/*        List<AccountDto> valLong = accountsConnector.getAccounts(customerId)
                .getAccounts()
                .stream()
                .map(account -> new AccountDto(
                                account.getIddto(),
                                account.getNrb(),
                                account.getCurrency(),
                                account.getAvailableFunds()
                        )
                )
//                .findAny().get().getIddto();
                .collect(Collectors.toList());
        log.log(Level.INFO, "XXX:" + valLong + "YYY");                          */

    @HystrixCommand(fallbackMethod = "fallbackGetAccounts")
    public List<AccountDto> getCustomerAccounts(Long customerId) {
        return accountsConnector.getAccounts(customerId)
                .getAccounts()
                .stream()
                .map(account -> new AccountDto(
                            account.getIddto(),
                            account.getNrb(),
                            account.getCurrency(),
                            account.getAvailableFunds(),
                            account.getIdCustomer()
                        )
                    )
                .collect(Collectors.toList());
    }

/*    public Optional<AccountDto> getCustomerAccount2(Long customerId) {
        return accountsConnector.getAccounts(customerId)
                .getAccounts()
                .stream()
                .map(account -> new AccountDto(
                            account.getIddto(),
                            account.getNrb(),
                            account.getCurrency(),
                            account.getAvailableFunds(),
                            account.getIdCustomer()
                        )
                    )
                .findFirst();
                //.collect(Collectors.toList());
    }                   */

    private List<AccountDto> fallbackGetAccounts(Long customerId) {
        return Collections.emptyList();
    }

}