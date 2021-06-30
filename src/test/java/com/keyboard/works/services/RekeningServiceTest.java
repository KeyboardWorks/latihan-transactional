package com.keyboard.works.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.keyboard.works.models.MutasiRekening;
import com.keyboard.works.models.Rekening;
import com.keyboard.works.repositories.MutasiRekeningRepository;
import com.keyboard.works.repositories.RekeningRepository;
import com.keyboard.works.services.impls.RekeningServiceImpl;

@SpringBootTest
public class RekeningServiceTest {

	@Mock
	private RekeningRepository rekeningRepository;
	
	@Mock
	private MutasiRekeningRepository mutasiRekeningRepository;
	
	@Mock
	private LoggingTransactionService loggingTransactionService;
	
	@Captor
	private ArgumentCaptor<MutasiRekening> mutasiRekeningCaptor;
	
	@InjectMocks
	private RekeningServiceImpl rekeningService;
	
	@Test
	public void insertDataTest() {
		
		Rekening rekening = new Rekening();
		rekening.setUser("ini adalah user");
		rekening.setSaldo(new BigDecimal(10_000));
		
		when(rekeningRepository.save(any())).thenReturn(rekening);
		
		rekeningService.insertData();
		
		verify(rekeningRepository).save(rekening);
		verify(mutasiRekeningRepository).save(mutasiRekeningCaptor.capture());
		verify(loggingTransactionService, times(2)).createLogging(anyString());
		
		MutasiRekening mutasiRekening = mutasiRekeningCaptor.getValue();
		
		assertEquals(mutasiRekening.getUser(), rekening.getUser());
		assertEquals(mutasiRekening.getSaldo(), rekening.getSaldo());
		assertNotNull(mutasiRekening.getDate());
	}
	
	@AfterEach
	public void tearDown() {
		
		verifyNoMoreInteractions(rekeningRepository, mutasiRekeningRepository, loggingTransactionService);
		
	}
	
}
