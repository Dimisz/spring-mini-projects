package com.uningen.RESTBasics.controllers;

import com.uningen.RESTBasics.domain.PaymentDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentController {
//    private final PaymentService paymentService;
    private static Logger logger =
        Logger.getLogger(PaymentController.class.getName());

//    public PaymentController(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    // STRAIGHTFORWARD WAY OF HANDLING EXCEPTIONS
//    @PostMapping("/payment")
//    public ResponseEntity<?> makePayment() {
//        try {
//            PaymentDetails paymentDetails =
//                    paymentService.processPayment();
//            return ResponseEntity
//                    .status(HttpStatus.ACCEPTED)
//                    .body(paymentDetails);
//        }
//        catch(NotEnoughMoneyException e){
//            ErrorDetails errorDetails =
//                    new ErrorDetails();
//            errorDetails.setMessage("Not enough money to make payment");
//            return ResponseEntity
//                    .badRequest()
//                    .body(errorDetails);
//        }
//    }

    // USING ADVICE TO HANDLE EXEPTIONS
    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment(@RequestBody PaymentDetails paymentDetails){
        logger.info("Received payment " + paymentDetails.getAmount());
//        PaymentDetails paymentDetails =
//                paymentService.processPayment();
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }
}
