package com.digipay.wallet.service.impl;


import com.digipay.wallet.entities.Wallet;
import com.digipay.wallet.exceptions.BaseException;
import com.digipay.wallet.repository.WalletRepository;
import com.digipay.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class WalletServiceImpl  implements WalletService {

    private final WalletRepository walletRepository;

    @Override
    public Wallet saveOrUpdate(Wallet wallet) throws BaseException {
        SecureRandom secureRandom = new SecureRandom();
        long secureRandomWalletId = Math.abs(secureRandom.nextLong());
        wallet.setWalletId(Long.toString(secureRandomWalletId));
        return walletRepository.save(wallet);
    }

    @Override
    public void deleteById(Long id) throws BaseException {
        walletRepository.deleteById(id);
    }

    @Override
    public Wallet findById(Long id) throws BaseException {
        return walletRepository.findById(id).get();
    }

    @Override
    public List<Wallet> findAll() throws BaseException {
        return walletRepository.findAll();
    }

    @Override
    public Wallet findByWalletId(String walletId) throws BaseException {
        return walletRepository.findByWalletId(walletId);
    }

}
