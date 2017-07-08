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

@Repository
public class addCategoryDAOImpl implements CategoryDAO{
@Resource
private SessionFactory sessionFactory;
	@Override
	@Transactional
	public boolean addCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		session.save(category);
		return true;
	}
	@Override
	@Transactional
	public List<Category> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Category.class);
		List<Category> catList = (List<Category>) criteria.list();
		return catList;
	}
	
	
	
	

}
