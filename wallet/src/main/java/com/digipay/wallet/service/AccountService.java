package com.digipay.wallet.service;

import com.digipay.wallet.base.BaseService;
import com.digipay.wallet.entities.AccountEntity;

public interface AccountService extends BaseService<AccountEntity, Long> {
    AccountEntity findByUsername(String username);

    AccountEntity findByUsernameAndPassword(String username, String password);

    Boolean existsByUsername(String username);
}
