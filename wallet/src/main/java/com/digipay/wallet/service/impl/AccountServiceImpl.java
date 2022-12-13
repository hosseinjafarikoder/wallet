package com.digipay.wallet.service.impl;

import com.digipay.wallet.base.BaseServiceImpl;
import com.digipay.wallet.entities.AccountEntity;
import com.digipay.wallet.exceptions.NotFoundExceptions;
import com.digipay.wallet.repository.AccountRepository;
import com.digipay.wallet.security.jwt.AuthEntryPointJwt;
import com.digipay.wallet.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl extends BaseServiceImpl<AccountEntity,
        Long, AccountRepository> implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

    public AccountServiceImpl(AccountRepository repository) {
        super(repository);
    }

    @Override
    public AccountEntity findByUsername(String username) {
        AccountEntity accountEntity = repository.findByUsername(username);
        if (accountEntity.getId() == null) {
            throw new NotFoundExceptions("your entity not found");
        } else
            return repository.findByUsername(username);
    }


    @Override
    public AccountEntity findByUsernameAndPassword(String username, String password) {
        AccountEntity accountEntity = repository.findByUsernameAndPassword(username, password);
        if (accountEntity.getId() == null) {
            throw new NotFoundExceptions("your entity not found");
        } else
            return repository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return null;
    }
}
