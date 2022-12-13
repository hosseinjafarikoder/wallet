package com.digipay.wallet.dto;

import com.digipay.wallet.entities.EBankStatus;

import java.math.BigDecimal;

public class WithdrawDto {
    private String sourceWalletId;
    private EBankStatus bankGatewayStatus;
    private BigDecimal amount;

    public String getSourceWalletId() {
        return sourceWalletId;
    }

    public void setSourceWalletId(String sourceWalletId) {
        this.sourceWalletId = sourceWalletId;
    }

    public EBankStatus getBankGatewayStatus() {
        return bankGatewayStatus;
    }

    public void setBankGatewayStatus(EBankStatus bankGatewayStatus) {
        this.bankGatewayStatus = bankGatewayStatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
