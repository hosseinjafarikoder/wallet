package com.digipay.wallet.mapper;

import com.digipay.wallet.dto.AccountDto;
import com.digipay.wallet.entities.AccountEntity;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper
public interface AccountMapper  {
    AccountEntity convertDtoToT(AccountDto accountDto);

    AccountDto convertTToDto(AccountEntity accountEntity);

    List<AccountEntity> convertListDtoToListEntity(List<AccountDto> accountDtoList);

    List<AccountDto> convertListEntityToListDto(List<AccountEntity> accountEntityList);
}
