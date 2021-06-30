package com.keyboard.works.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keyboard.works.services.RekeningService;

@RestController
@RequestMapping(path = "/rekening")
public class RekeningController {

	@Autowired
	private RekeningService rekeningService;
	
	@GetMapping(path = "/init")
	public String initData() {
		
		rekeningService.insertData();
		
		return "succeed";
	}
	
}
