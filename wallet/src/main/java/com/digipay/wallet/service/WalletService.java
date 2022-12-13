package com.digipay.wallet.service;

import com.digipay.wallet.entities.Wallet;
import com.digipay.wallet.exceptions.BaseException;

import java.util.List;

public interface WalletService  {

    Wallet saveOrUpdate(Wallet t) throws BaseException;

    void deleteById(Long id) throws BaseException;

    Wallet findById(Long id) throws BaseException;

    List<Wallet> findAll() throws BaseException;

    Wallet findByWalletId(String walletId) throws BaseException;

}
