package com.keyboard.works.services.impls;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.keyboard.works.models.LoggingTransaction;
import com.keyboard.works.repositories.LoggingTransactionRepository;
import com.keyboard.works.services.LoggingTransactionService;

@Service
public class LoggingTransactionServiceImpl implements LoggingTransactionService{

	@Autowired
	private LoggingTransactionRepository loggingTransactionRepository;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW) //Create new transaction manager
	public void createLogging(String message) {
		
		LoggingTransaction loggingTransaction = new LoggingTransaction();
		loggingTransaction.setDate(new Date());
		loggingTransaction.setMessage(message);
		
		loggingTransactionRepository.save(loggingTransaction);
		
	}

}
