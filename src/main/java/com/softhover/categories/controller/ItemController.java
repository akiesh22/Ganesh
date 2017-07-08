package com.softhover.categories.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softhover.categories.dao.CategoryDAO;
import com.softhover.categories.dao.ItemDAO;
import com.softhover.categories.model.Item;

@Controller
public class ItemController {
	@Autowired
	CategoryDAO categoryDao;

	@Autowired
	ItemDAO itemDao;
	
	@RequestMapping(value = "/addItem", method = RequestMethod.GET)
	public String addItem(Model model, HttpSession session, @RequestParam("id") int id) {
		model.addAttribute("catList", categoryDao.getAll());
		model.addAttribute("itemList", itemDao.getAll(id));		
		return "addItem";


	}

	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public String addItem(Model model, HttpSession session, @ModelAttribute Item item) {
		int id = (int) session.getAttribute("id");
		if (itemDao.addItem(item, id)) {
			model.addAttribute("itemList", itemDao.getAll());
			model.addAttribute("catList", categoryDao.getAll());
			return "home";
		} else
			return "home";

	}	

	@RequestMapping(value = "/viewItem", method = RequestMethod.GET)
	public String viewItem(Model model, HttpSession session, @RequestParam("id") int id) {
		model.addAttribute("catList", categoryDao.getAll());
		model.addAttribute("itemList", itemDao.getAll(id));		
		return "home";


	}

}
