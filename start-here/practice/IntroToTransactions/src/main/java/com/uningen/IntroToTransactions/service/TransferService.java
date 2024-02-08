package com.uningen.IntroToTransactions.service;


import com.uningen.IntroToTransactions.domain.Account;
import com.uningen.IntroToTransactions.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
    private final AccountRepository accountRepository;
    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(long senderId,
                              long receiverId,
                              BigDecimal amount){
        Account sender =
                accountRepository.findAccountById(senderId);
        Account receiver =
                accountRepository.findAccountById(receiverId);

        BigDecimal senderNewAmount =
                sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount =
                receiver.getAmount().add(amount);

        accountRepository.changeAmount(senderId, senderNewAmount);
        accountRepository.changeAmount(receiverId, receiverNewAmount);

        // testing rollback in case of runtime Exception
        throw new RuntimeException("Oh no something went wrong(((");
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAllAccounts();
    }
}
