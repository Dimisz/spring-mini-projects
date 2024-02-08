package com.uningen.IntroToSpringData.service;

import com.uningen.IntroToSpringData.domain.Account;
import com.uningen.IntroToSpringData.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(long senderId, long receiverId, BigDecimal amount) {
        Account sender =
                accountRepository.findById(senderId)
                        .orElseThrow(() -> new AccountNotFoundException());
        Account receiver =
                accountRepository.findById(receiverId)
                        .orElseThrow(() -> new AccountNotFoundException());
        BigDecimal senderNewAmount =
                sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount =
                receiver.getAmount().add(amount);
        accountRepository.changeAmount(senderId, senderNewAmount);
        accountRepository.changeAmount(receiverId, receiverNewAmount);
    }

    public Iterable<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Iterable<Account> findAccountsByName(String name){
        return accountRepository.findAccountsByName(name);
    }
}
