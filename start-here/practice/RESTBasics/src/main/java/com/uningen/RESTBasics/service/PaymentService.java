package com.uningen.RESTBasics.service;

import com.uningen.RESTBasics.domain.PaymentDetails;
import com.uningen.RESTBasics.exceptions.NotEnoughMoneyException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment(){
        throw new NotEnoughMoneyException();
    }
}
