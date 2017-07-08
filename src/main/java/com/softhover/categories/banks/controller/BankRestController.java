package com.softhover.categories.banks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softhover.categories.banks.model.Bank;
import com.softhover.categories.banks.service.BankService;
import com.softhover.categories.dao.CategoryDAO;
import com.softhover.categories.model.Category;

@RestController
@RequestMapping(value="/rest")
public class BankRestController {
	@Autowired
	private BankService bankService;
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Bank>> restGet(){
		List<Bank> bankList = bankService.getAll();
		ResponseEntity<List<Bank>> response = new ResponseEntity<>(bankList, HttpStatus.OK);
		return response;
	}
}
