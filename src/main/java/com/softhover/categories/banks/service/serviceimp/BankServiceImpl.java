package com.softhover.categories.banks.service.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softhover.categories.banks.dao.BankDao;
import com.softhover.categories.banks.model.Bank;
import com.softhover.categories.banks.service.BankService;
@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankDao bankDao;
	@Override
	public void create(Bank bank) {
		bankDao.create(bank);
	}
	@Override
	public List<Bank> getAll() {
		return bankDao.getAll();
	}

}
