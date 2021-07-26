package com.kodilla.customer.service;

import com.kodilla.customer.dto.*;
import com.kodilla.customer.provider.AccountsProvider;
import com.kodilla.customer.provider.CardsProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
//import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import java.util.Optional;
//import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@AutoConfigureMockMvc
/*@SpringBootTest
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = {
                "com.kodilla:accounts:+:stubs:9000"
        }
)                   */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = {
                "com.kodilla:accounts:+:stubs:9000"
        }
)
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void findCustomerAccounts() {
        //Given
        Long customerId = 7L;

        //When
        List<AccountDto> accounts = productService.findCustomerAccounts(customerId);

        //Then
        assertEquals(7, accounts.size());
    }

}