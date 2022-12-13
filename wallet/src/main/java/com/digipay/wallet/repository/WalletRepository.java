package com.digipay.wallet.repository;

import com.digipay.wallet.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Wallet findByWalletId(String walletId);

}
