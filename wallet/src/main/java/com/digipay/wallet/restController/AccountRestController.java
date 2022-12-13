package com.digipay.wallet.restController;//package com.digipay.wallet.restController;

import com.digipay.wallet.dto.AccountDto;
import com.digipay.wallet.exceptions.BaseException;
import com.digipay.wallet.mapper.AccountMapper;
import com.digipay.wallet.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountRestController {
    private final AccountService accountService;

    private final AccountMapper accountMapper;

    @PostMapping()
    public AccountDto save(@Valid @RequestBody AccountDto accountDto) throws BaseException {
        return accountMapper.convertTToDto(accountService.saveOrUpdate( accountMapper.convertDtoToT(accountDto)));
    }

    @PutMapping
    public AccountDto update(Principal principal,@Valid @RequestBody AccountDto accountDto) throws BaseException {
        accountDto.setId(accountService.findByUsername(principal.getName()).getId());
        return accountMapper.convertTToDto(accountService.saveOrUpdate(accountMapper.convertDtoToT(accountDto)));
    }

    @GetMapping("/id")
    public AccountDto findById(@PathVariable Long id) throws BaseException {
        return accountMapper.convertTToDto(accountService.findById(id));
    }

    @GetMapping
    public List<AccountDto> findAll() throws BaseException {
        return accountMapper.convertListEntityToListDto(accountService.findAll());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) throws BaseException {
        accountService.deleteById(id);
    }
}
