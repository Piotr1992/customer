package com.kodilla.customer.service;

import com.kodilla.customer.dto.AccountDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void findCustomerAccounts() {
        //Given
        Long customerId = 1L;

        //When
        List<AccountDto> accounts = productService.findCustomerAccounts(customerId);

        //Then
        assertEquals(0, accounts.size());
    }

}