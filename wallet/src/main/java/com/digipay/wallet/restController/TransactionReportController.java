package com.digipay.wallet.restController;

import com.digipay.wallet.dto.TransactionReportDto;
import com.digipay.wallet.exceptions.BaseException;
import com.digipay.wallet.mapper.TransactionReportMapper;
import com.digipay.wallet.service.TransactionReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionReportController {

    private final TransactionReportService transactionReportService;

    private final TransactionReportMapper transactionReportMapper;

    @PostMapping()
    public TransactionReportDto save(@Valid @RequestBody TransactionReportDto transactionReportDto) throws BaseException {
        return transactionReportMapper.
                convertTToDto(transactionReportService.
                        saveOrUpdate( transactionReportMapper.convertDtoToT(transactionReportDto)));
    }

    @PutMapping
    public TransactionReportDto update(@Valid @RequestBody TransactionReportDto transactionReportDto) throws BaseException {
        return transactionReportMapper.
                convertTToDto(transactionReportService.
                        saveOrUpdate(transactionReportMapper.convertDtoToT(transactionReportDto)));
    }

    @GetMapping("/{id}")
    public TransactionReportDto findById(@PathVariable Long id) throws BaseException {
        return transactionReportMapper.convertTToDto(transactionReportService.findById(id));
    }

    @GetMapping
    public List<TransactionReportDto> findAll() throws BaseException {
        return transactionReportMapper.convertListEntityToListDto(transactionReportService.findAll());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) throws BaseException {
        transactionReportService.deleteById(id);
    }
}



