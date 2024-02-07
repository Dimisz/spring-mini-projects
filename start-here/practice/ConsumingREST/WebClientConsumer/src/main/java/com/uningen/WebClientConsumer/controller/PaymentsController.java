package com.uningen.WebClientConsumer.controller;

import com.uningen.WebClientConsumer.domain.Payment;
import com.uningen.WebClientConsumer.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentsController {
    private final PaymentsProxy paymentsProxy;
    private final Logger logger = Logger.getLogger(PaymentsController.class.getName());

    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/payment")
    public Mono<Payment> createPayment(@RequestBody Payment payment){
        String requestId = UUID.randomUUID().toString();
        logger.info("Procesing payment of $" +
                payment.getAmount() + " with WebClient.");
        return paymentsProxy.createPayment(requestId, payment);
    }
}
