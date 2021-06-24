package com.kodilla.customer;

import com.kodilla.customer.dto.Customer;
import com.kodilla.customer.repository.CustomerRepository;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;
import java.util.Optional;

import static org.mockito.Mockito.when;

@Disabled
@ExtendWith(SpringExtension.class)
@SpringBootTest

public class ContractVerifierBase {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private CustomerRepository repository;

    @BeforeEach
    public void setUp() {
        RestAssuredMockMvc.webAppContextSetup(context);
        when(repository.findById(1L)).thenReturn(
            Optional.of(
                new Customer(1L, "Jan", "Kowalski")
            )
        );
    }
}