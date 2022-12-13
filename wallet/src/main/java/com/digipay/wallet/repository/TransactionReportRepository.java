package com.digipay.wallet.repository;

import com.digipay.wallet.entities.TransactionReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionReportRepository extends JpaRepository<TransactionReport, Long> {
}
