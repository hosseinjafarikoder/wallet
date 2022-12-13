package com.digipay.wallet.dto;

import com.digipay.wallet.entities.EBankStatus;

import java.math.BigDecimal;

public class DepositDto {

    private String sourceWalletId;
    private EBankStatus status;
    private BigDecimal amount;

    public String getSourceWalletId() {
        return sourceWalletId;
    }

    public void setSourceWalletId(String sourceWalletId) {
        this.sourceWalletId = sourceWalletId;
    }

    public EBankStatus getStatus() {
        return status;
    }

    public void setStatus(EBankStatus status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
