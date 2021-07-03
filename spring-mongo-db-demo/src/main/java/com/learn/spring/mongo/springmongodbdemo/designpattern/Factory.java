package com.learn.spring.mongo.springmongodbdemo.designpattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Factory {

    public static void main(String[] args) {
        final PaymentSystem paymentSystem = MessageFactory.getMessagingInstance(InstanceType.PAYPAL);
        if (paymentSystem.validate()) log.info("Paymenet Status : {}", paymentSystem.processPayment());
    }
    
}


class MessageFactory {

    private MessageFactory() {}

    public static PaymentSystem getMessagingInstance(InstanceType type) {
        PaymentSystem paymentSystem = null;
        switch (type) {
            case CREDIT_CARD:
                paymentSystem = new CreditCardPaymentSystem();
                break;
            case PAYPAL:
                paymentSystem = new PayPalPaymentSystem();
                break;
            default:
                throw new RuntimeException("Provided payment system is not implemented " + type);

        }
        return paymentSystem;
    }
}

interface PaymentSystem {
    boolean validate();
    Status processPayment();
}

class CreditCardPaymentSystem implements PaymentSystem {

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public Status processPayment() {

        return Status.APPROVED;
    }

}

class PayPalPaymentSystem implements PaymentSystem {

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public Status processPayment() {
        return Status.DECLINED;
    }

}

enum Status {
    APPROVED, DECLINED, PENDING, CANCELLED
}

enum InstanceType {
    CREDIT_CARD,
    PAYPAL
}