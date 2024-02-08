package com.uningen.IntroToSpringData.controller;

import com.uningen.IntroToSpringData.DTO.TransferRequest;
import com.uningen.IntroToSpringData.domain.Account;
import com.uningen.IntroToSpringData.service.TransferService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest transferRequest){
        transferService.transferMoney(
                transferRequest.getSenderAccountId(),
                transferRequest.getReceiverAccountId(),
                transferRequest.getAmount()
        );
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(
            @RequestParam(required = false) String name
    ){
        if(name == null){
            return transferService.getAllAccounts();
        }
        else {
            return transferService.findAccountsByName(name);
        }
    }
}
