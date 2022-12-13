package com.digipay.wallet.service.impl;

import com.digipay.wallet.base.BaseServiceImpl;
import com.digipay.wallet.entities.TransactionReport;
import com.digipay.wallet.exceptions.BaseException;
import com.digipay.wallet.repository.TransactionReportRepository;
import com.digipay.wallet.service.TransactionReportService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class TransactionReportServiceImpl extends BaseServiceImpl<TransactionReport,
        Long, TransactionReportRepository> implements TransactionReportService {

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public TransactionReport saveOrUpdate(TransactionReport transactionReport) throws BaseException {
        return super.saveOrUpdate(transactionReport);
    }

    public TransactionReportServiceImpl(TransactionReportRepository repository) {
        super(repository);
    }

}
