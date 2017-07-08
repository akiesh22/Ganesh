package com.softhover.categories.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.softhover.categories.model.Category;
import com.softhover.categories.model.Item;

@Repository
public class ItemDAOImpl implements ItemDAO {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean addItem(Item item, int i) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Category.class);
		criteria.add(Restrictions.eq("id", i));
		Category c = (Category) criteria.uniqueResult();
		item.setCategory(c);
		session.save(item);
		return true;
	}

	@Override
	@Transactional
	public List<Item> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Item.class);
		List<Item> items = (List<Item>) criteria.list();
		return items;
	}

	@Override
	@Transactional
	public List<Item> getAll(int i) {
		System.out.println(i);
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Category.class);
		criteria.add(Restrictions.eq("id", i));
		Category c = (Category) criteria.uniqueResult();
		List<Item> item = c.getItem();
		for (Item ir : item) {
		}
		return item;

	}

}
