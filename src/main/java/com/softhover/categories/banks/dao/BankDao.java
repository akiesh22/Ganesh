package com.softhover.categories.banks.dao;

import java.util.List;

import com.softhover.categories.banks.model.Bank;


public interface BankDao {
public void create(Bank bank);
public List<Bank> getAll();
}
