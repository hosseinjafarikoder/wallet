package com.digipay.wallet.mapper;

import com.digipay.wallet.dto.TransactionReportDto;
import com.digipay.wallet.dto.WalletDto;
import com.digipay.wallet.entities.TransactionReport;
import com.digipay.wallet.entities.Wallet;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TransactionReportMapper {
    TransactionReport convertDtoToT(TransactionReportDto transactionReportDto);

    TransactionReportDto convertTToDto(TransactionReport transactionReport);

    List<TransactionReport> convertListDtoToListEntity(List<TransactionReportDto> transactionReportDtoList);

    List<TransactionReportDto> convertListEntityToListDto(List<TransactionReport> transactionReportList);

}