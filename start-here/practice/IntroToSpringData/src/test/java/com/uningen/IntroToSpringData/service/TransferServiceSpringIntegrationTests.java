package com.uningen.IntroToSpringData.service;

import com.uningen.IntroToSpringData.domain.Account;
import com.uningen.IntroToSpringData.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransferServiceSpringIntegrationTests {
    @MockBean
    private AccountRepository accountRepository;

    // injecting a real object
    @Autowired
    private TransferService transferService;

    @Test
    void transferServiceTransferAmounttest(){
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account receiver = new Account();
        receiver.setId(2);
        receiver.setAmount(new BigDecimal(1000));

        when(accountRepository.findById(1L))
                .thenReturn(Optional.of(sender));
        when(accountRepository.findById(2L))
                .thenReturn(Optional.of(receiver));

        transferService
                .transferMoney(1L, 2L, new BigDecimal(100));

        verify(accountRepository)
                .changeAmount(1L, new BigDecimal(900));
        verify(accountRepository)
                .changeAmount(2L, new BigDecimal(1100));
    }
}
