package com.softhover.categories.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.softhover.categories.dao.CategoryDAO;
import com.softhover.categories.dao.ItemDAO;
import com.softhover.categories.model.Category;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CategoryController {
	@Autowired
	CategoryDAO categoryDao;

	@Autowired
	ItemDAO itemDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "bank";
	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public String newCategory(Model model, HttpSession session, @ModelAttribute Category category) {
		if (categoryDao.addCategory(category)) {
			model.addAttribute("catList", categoryDao.getAll());
			model.addAttribute("itemList", itemDao.getAll());
			return "home";
		} else
			model.addAttribute("Msg", "Item not added");
		return "home";

	}


}
