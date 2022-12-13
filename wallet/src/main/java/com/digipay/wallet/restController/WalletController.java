package com.digipay.wallet.restController;


import com.digipay.wallet.dto.WalletDto;
import com.digipay.wallet.entities.Wallet;
import com.digipay.wallet.exceptions.BaseException;
import com.digipay.wallet.mapper.WalletMapper;
import com.digipay.wallet.service.AccountService;
import com.digipay.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    private final AccountService accountService;

    private final WalletMapper walletMapper;

    @PostMapping()
    public WalletDto save(Principal principal, @Valid @RequestBody WalletDto walletDto) throws BaseException {
        Wallet wallet = walletMapper.convertDtoToT(walletDto);
        wallet.setAccount(accountService.findByUsername(principal.getName()));
        return walletMapper.convertTToDto(walletService.saveOrUpdate(wallet));
    }

    @PutMapping
    public WalletDto update(@Valid @RequestBody WalletDto walletDto) throws BaseException {
        return walletMapper.convertTToDto(walletService.saveOrUpdate(walletMapper.convertDtoToT(walletDto)));
    }

    @GetMapping("/{id}")
    public WalletDto findById(@PathVariable Long id) throws BaseException {
        return walletMapper.convertTToDto(walletService.findById(id));
    }

    @GetMapping
    public List<WalletDto> findAll() throws BaseException {
        return walletMapper.convertListEntityToListDto(walletService.findAll());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) throws BaseException {
        walletService.deleteById(id);
    }
}
