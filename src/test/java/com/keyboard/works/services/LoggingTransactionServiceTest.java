package com.keyboard.works.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.keyboard.works.models.LoggingTransaction;
import com.keyboard.works.repositories.LoggingTransactionRepository;
import com.keyboard.works.services.impls.LoggingTransactionServiceImpl;

@SpringBootTest
class LoggingTransactionServiceTest {

	@Mock
	private LoggingTransactionRepository loggingTransactionRepository;
	
	@Captor
	private ArgumentCaptor<LoggingTransaction> loggingTransactionCaptor;
	
	@InjectMocks
	private LoggingTransactionServiceImpl loggingTransactionService;
	
	@Test
	void testSave() {
		
		loggingTransactionService.createLogging("createLogging");
	
		verify(loggingTransactionRepository).save(loggingTransactionCaptor.capture());
		
		LoggingTransaction loggingTransaction = loggingTransactionCaptor.getValue();
		
		assertEquals("createLogging", loggingTransaction.getMessage());
		assertNotNull(loggingTransaction.getDate());
	}

	@AfterEach
	public void tearDown() {
		
		verifyNoMoreInteractions(loggingTransactionRepository);
		
	}
	
}
