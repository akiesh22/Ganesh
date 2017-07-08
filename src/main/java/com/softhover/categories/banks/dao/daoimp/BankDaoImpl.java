package com.softhover.categories.banks.dao.daoimp;

import java.util.List;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softhover.categories.banks.dao.BankDao;
import com.softhover.categories.banks.model.Bank;

@Repository
@Transactional
public class BankDaoImpl implements BankDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void create(Bank bank) {
		Session session = sessionFactory.getCurrentSession();
		session.save(bank);
	}
	@Override
	public List<Bank> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Bank.class).list();
	}
}
