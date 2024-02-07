package com.uningen.RestTemplateConsumer.controller;

import com.uningen.RestTemplateConsumer.domain.Payment;
import com.uningen.RestTemplateConsumer.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentsController {
    private final PaymentsProxy paymentsProxy;

    private Logger logger =
            Logger.getLogger(PaymentsController.class.getName());

    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment){
        logger.info("Payment of " + payment.getAmount() + "processed by RestTemplate consumer");
        return paymentsProxy.createPayment(payment);
    }
}
