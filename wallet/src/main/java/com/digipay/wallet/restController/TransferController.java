package com.digipay.wallet.restController;

import com.digipay.wallet.dto.DepositDto;
import com.digipay.wallet.dto.TransferDto;
import com.digipay.wallet.dto.WithdrawDto;
import com.digipay.wallet.entities.AccountEntity;
import com.digipay.wallet.entities.Wallet;
import com.digipay.wallet.exceptions.BaseException;
import com.digipay.wallet.exceptions.NotFoundExceptions;
import com.digipay.wallet.payload.response.MessageResponse;
import com.digipay.wallet.service.AccountService;
import com.digipay.wallet.service.TransferService;
import com.digipay.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/transfer")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;
    
    private final WalletService walletService;
    
    private final AccountService accountService;

    @PostMapping("/wTow")
    public ResponseEntity<?> transferWalletToWallet(Principal principal, @RequestBody TransferDto transferDto) throws BaseException {
        AccountEntity accountEntity = accountService.findByUsername(principal.getName());
        Wallet wallet = walletService.findByWalletId(transferDto.getSourceWalletId());
        if (!wallet.getAccount().equals(accountEntity)){
            throw new NotFoundExceptions("this wallet id is not yours");
        }else {
            transferService.transferWalletToWallet(
                    transferDto.getSourceWalletId(),
                    transferDto.getDestinationWalletId(),
                    transferDto.getAmount()
            );
        }
        return ResponseEntity.ok(new MessageResponse("transfer wallet to wallet successfully"));
    }

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(Principal principal, @RequestBody DepositDto depositDto) throws BaseException {
        AccountEntity accountEntity = accountService.findByUsername(principal.getName());
        Wallet wallet = walletService.findByWalletId(depositDto.getSourceWalletId());
        if (!wallet.getAccount().equals(accountEntity)){
            throw new NotFoundExceptions("this wallet id is not yours");
        }
        else {
            transferService.deposit(
                    depositDto.getSourceWalletId(),
                    depositDto.getStatus(),
                    depositDto.getAmount()
            );
        }
        return ResponseEntity.ok(new MessageResponse("deposit action successfully"));
    }

    @PostMapping("/withdraw")
    public ResponseEntity<?> withdraw(Principal principal, @RequestBody WithdrawDto withDrawDto) throws BaseException {
        AccountEntity accountEntity = accountService.findByUsername(principal.getName());
        Wallet wallet = walletService.findByWalletId(withDrawDto.getSourceWalletId());
        if (!wallet.getAccount().equals(accountEntity)){
            throw new NotFoundExceptions("this wallet id is not yours");
        }
        else {
            transferService.deposit(
                    withDrawDto.getSourceWalletId(),
                    withDrawDto.getBankGatewayStatus(),
                    withDrawDto.getAmount()
            );
        }
        return ResponseEntity.ok(new MessageResponse("withdraw action successfully"));
    }

}
