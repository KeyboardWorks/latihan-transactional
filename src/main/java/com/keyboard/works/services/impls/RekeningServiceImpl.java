package com.keyboard.works.services.impls;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keyboard.works.models.MutasiRekening;
import com.keyboard.works.models.Rekening;
import com.keyboard.works.repositories.MutasiRekeningRepository;
import com.keyboard.works.repositories.RekeningRepository;
import com.keyboard.works.services.LoggingTransactionService;
import com.keyboard.works.services.RekeningService;

@Service
@Transactional //Default REQUIRED
public class RekeningServiceImpl implements RekeningService {

	@Autowired
	private RekeningRepository rekeningRepository;
	
	@Autowired
	private MutasiRekeningRepository mutasiRekeningRepository;
	
	@Autowired
	private LoggingTransactionService loggingTransactionService;
	
	@Override
	public void insertData() {
		
		Rekening rekening = new Rekening();
		rekening.setUser("ini adalah user");
		rekening.setSaldo(new BigDecimal(10_000));
		
		rekening = rekeningRepository.save(rekening);
		
		loggingTransactionService.createLogging("Rekening created!");
		
		MutasiRekening mutasiRekening = new MutasiRekening();
		BeanUtils.copyProperties(rekening, mutasiRekening, "id");
		
		mutasiRekening.setDate(new Date());
		
		mutasiRekeningRepository.save(mutasiRekening);
		
		loggingTransactionService.createLogging("Mutasi Rekening created!");
		
	}

}
