package com.softhover.categories.banks.service;

import java.util.List;

import com.softhover.categories.banks.model.Bank;

public interface BankService {
	public void create(Bank bank);
	public List<Bank> getAll();
}
