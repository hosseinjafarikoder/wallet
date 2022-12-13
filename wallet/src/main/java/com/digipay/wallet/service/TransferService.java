package com.digipay.wallet.service;

import com.digipay.wallet.entities.EBankStatus;
import com.digipay.wallet.exceptions.BaseException;

import java.math.BigDecimal;

public interface TransferService {

    void transferWalletToWallet(String sourceWalletId, String destinationWalletId, BigDecimal amount) throws BaseException;

    void deposit(String sourceWalletId, EBankStatus bankGatewayStatus, BigDecimal amount) throws BaseException;

    void withdraw(String sourceWalletId,EBankStatus bankGatewayStatus,BigDecimal amount) throws BaseException;
}
