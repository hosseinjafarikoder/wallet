package com.digipay.wallet.dto;

import com.digipay.wallet.base.BaseDto;
import com.digipay.wallet.entities.TransactionReport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WalletDto extends BaseDto {

    private Long id;

    private String walletName;

    @NotBlank
    private String walletId;

    private BigDecimal balance;

    private Boolean status;

    private List<TransactionReport> transactionReportList = new ArrayList<>();
}

