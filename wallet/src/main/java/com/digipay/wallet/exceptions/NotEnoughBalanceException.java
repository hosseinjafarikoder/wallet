package com.digipay.wallet.exceptions;

public class NotEnoughBalanceException extends RuntimeException {

    public NotEnoughBalanceException(String message) {
        super(message);
    }
}
