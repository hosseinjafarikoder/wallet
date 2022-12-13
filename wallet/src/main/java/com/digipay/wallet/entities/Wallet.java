package com.digipay.wallet.entities;


import com.digipay.wallet.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "wallet")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Wallet extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String walletName;

    private String walletId;

    private BigDecimal balance;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "account_entity_id")
    private AccountEntity account;

    @OneToMany(mappedBy = "wallet")
    private List<TransactionReport> transactionReportList = new ArrayList<>();

}
