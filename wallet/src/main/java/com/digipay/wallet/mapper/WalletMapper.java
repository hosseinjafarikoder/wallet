package com.digipay.wallet.mapper;

import com.digipay.wallet.dto.WalletDto;
import com.digipay.wallet.entities.Wallet;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface WalletMapper  {
    Wallet convertDtoToT(WalletDto walletDto);

    WalletDto convertTToDto(Wallet wallet);

    List<Wallet> convertListDtoToListEntity(List<WalletDto> walletDtoList);

    List<WalletDto> convertListEntityToListDto(List<Wallet> walletList);
}
