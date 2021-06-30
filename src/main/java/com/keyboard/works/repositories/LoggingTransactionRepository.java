package com.keyboard.works.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keyboard.works.models.LoggingTransaction;

@Repository
public interface LoggingTransactionRepository extends JpaRepository<LoggingTransaction, Long> {

}
