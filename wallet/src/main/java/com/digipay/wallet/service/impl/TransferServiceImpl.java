package com.digipay.wallet.service.impl;

import com.digipay.wallet.entities.EBankStatus;
import com.digipay.wallet.entities.EType;
import com.digipay.wallet.entities.TransactionReport;
import com.digipay.wallet.entities.Wallet;
import com.digipay.wallet.exceptions.BaseException;
import com.digipay.wallet.exceptions.NotEnoughBalanceException;
import com.digipay.wallet.exceptions.walletIdNullException;
import com.digipay.wallet.exceptions.walletNotActiveException;
import com.digipay.wallet.repository.WalletRepository;
import com.digipay.wallet.security.jwt.AuthEntryPointJwt;
import com.digipay.wallet.service.TransactionReportService;
import com.digipay.wallet.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


@Service
@Transactional
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);


    private final WalletRepository walletService;

    private final TransactionReportService transactionReportService;

    @Override
    public void transferWalletToWallet(String sourceWalletId, String destinationWalletId, BigDecimal amount) throws BaseException {

        if (sourceWalletId == null || destinationWalletId == null) {
            logger.error("your entity not found: {}", walletIdNullException.class);
            throw new walletIdNullException("your entity not found");
        }

        Wallet sourceWallet = walletService.findByWalletId(sourceWalletId);
        Wallet destinationWallet = walletService.findByWalletId(destinationWalletId);
        TransactionReport sourceTr = TransactionReport.builder().amount(amount)
                .amount(amount)
                .sourceWalletId(sourceWalletId)
                .destinationWalletId(destinationWalletId)
                .type(EType.transfer)
                .wallet(sourceWallet).build();

        if (sourceWallet.getBalance().compareTo(amount)==-1){
            sourceTr.setStatus(false);
            sourceTr.setDescription("balance in not enough");
            transactionReportService.saveOrUpdate(sourceTr);

            logger.error("your balance is not enough : {}", NotEnoughBalanceException.class);
            throw new NotEnoughBalanceException("balance is not enough");
        }else if (!sourceWallet.getStatus() || !destinationWallet.getStatus()) {
            sourceTr.setStatus(false);
            sourceTr.setDescription("wallet is not active");
            transactionReportService.saveOrUpdate(sourceTr);
            logger.error("wallet is not active: {}", walletNotActiveException.class);
            throw new walletNotActiveException("wallet is not active ");
        }else {
            sourceWallet.setBalance(sourceWallet.getBalance().subtract(amount));
            walletService.save(sourceWallet);
            sourceTr.setStatus(true);
            sourceTr.setDescription("successfully");
            transactionReportService.saveOrUpdate(sourceTr);

            destinationWallet.setBalance(destinationWallet.getBalance().subtract(amount));
            walletService.save(destinationWallet);
            TransactionReport destinationTr = TransactionReport.builder().amount(amount)
                    .status(true)
                    .amount(amount)
                    .sourceWalletId(sourceWalletId)
                    .destinationWalletId(destinationWalletId)
                    .type(EType.transfer)
                    .wallet(destinationWallet).build();
            transactionReportService.saveOrUpdate(destinationTr);

        }
    }

    @Override
    public void deposit(String sourceWalletId, EBankStatus bankGatewayStatus, BigDecimal amount) throws BaseException {
        Wallet sourceWallet = walletService.findByWalletId(sourceWalletId);
        TransactionReport transaction = TransactionReport.builder().amount(amount)
                .sourceWalletId(sourceWalletId)
                .type(EType.deposit)
                .wallet(sourceWallet).build();
        if (sourceWallet.getBalance().compareTo(amount)==-1){
            transaction.setStatus(false);
            transaction.setDescription("balance in not enough");
            transactionReportService.saveOrUpdate(transaction);

            logger.error("your balance is not enough : {}", NotEnoughBalanceException.class);
            throw new NotEnoughBalanceException("balance is not enough");
        }else if (bankGatewayStatus==EBankStatus.Fail){
            logger.info("deposit failed");
            transaction.setStatus(false);
            transaction.setDescription("bad GateWay");
            transactionReportService.saveOrUpdate(transaction);

        }else if (sourceWalletId == null ) {
            transaction.setStatus(false);
            transaction.setDescription("id didnt enter");
            transactionReportService.saveOrUpdate(transaction);
            logger.error("wallet id is null: {}", walletIdNullException.class);
            throw new walletIdNullException("wallet id is null");
        }else if (!sourceWallet.getStatus()) {
            transaction.setStatus(false);
            transaction.setDescription("wallet is not active");
            transactionReportService.saveOrUpdate(transaction);
            logger.error("wallet is not active: {}", walletIdNullException.class);
            throw new walletNotActiveException("wallet is not active");
        }else {
            sourceWallet.setBalance(sourceWallet.getBalance().add(amount));
            walletService.save(sourceWallet);
            transaction.setStatus(true);
            transaction.setDescription("successfully");
            transactionReportService.saveOrUpdate(transaction);
        }
    }

    @Override
    public void withdraw(String sourceWalletId,EBankStatus bankGatewayStatus,BigDecimal amount) throws BaseException {
        Wallet sourceWallet = walletService.findByWalletId(sourceWalletId);
        TransactionReport transaction = TransactionReport.builder().amount(amount)
                .sourceWalletId(sourceWalletId)
                .type(EType.withdraw)
                .wallet(sourceWallet).build();
        if (bankGatewayStatus==EBankStatus.Fail){
            logger.info("withdraw failed");
            transaction.setStatus(false);
            transaction.setDescription("bank status failed");
            transactionReportService.saveOrUpdate(transaction);
        }else{
            sourceWallet.setBalance(sourceWallet.getBalance().subtract(amount));
            walletService.save(sourceWallet);
            transaction.setStatus(true);
            transaction.setDescription("successfully");
            transactionReportService.saveOrUpdate(transaction);
        }
    }
}

