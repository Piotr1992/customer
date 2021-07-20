package com.kodilla.customer.provider;

import com.kodilla.customer.connector.CardsConnector;
import com.kodilla.customer.dto.CardDto;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardsProvider {
    private final CardsConnector cardsConnector;

    @HystrixCommand(fallbackMethod = "fallbackGetCards")
    public List<CardDto> getCustomerCards(Long customerId) {
        return cardsConnector.getCards(customerId)
                .getCards()
                .stream()
                .map(card -> new CardDto(
                        card.getId(),
                        card.getTypeCard()
                    )
                )
                .collect(Collectors.toList());

    }

    private List<CardDto> fallbackGetCards(Long customerId) {
        return Collections.emptyList();
    }

}