package com.digipay.wallet.entities;

import com.digipay.wallet.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transaction_reports")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionReport extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean status;

    private BigDecimal amount;

    private String sourceWalletId;

    private String destinationWalletId;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EType type;

    @ManyToOne
    @JoinColumn(name = "wallet_entity_id")
    private Wallet wallet;

}
