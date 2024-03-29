package com.example.sqch11ex1.controllers;

import com.example.sqch11ex1.model.Payment;
import com.example.sqch11ex1.proxy.PaymentProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentController {

    Logger logger = Logger.getLogger(PaymentController.class.getName());

    private final PaymentProxy paymentProxy;

    public PaymentController(PaymentProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    @PostMapping("/payment")
    public Payment createPayment(
            @RequestBody Payment payment
    ) {
        String requestId = UUID.randomUUID().toString();
        Payment returnedPayment = paymentProxy.createPayment(requestId, payment);

        logger.info("Create with ID " + requestId +
                " ;Payment Amount: " + returnedPayment.getAmount());

        return returnedPayment;
    }
}
