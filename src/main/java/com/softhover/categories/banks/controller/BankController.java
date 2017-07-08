package com.softhover.categories.banks.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.softhover.categories.banks.model.Bank;
import com.softhover.categories.banks.service.BankService;

@Controller
@RequestMapping("/bank")
public class BankController {
	@Autowired
	private BankService bankService;
	
	@Autowired
	private HttpSession httpSession;
	
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("bank", "bank", new Bank());
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addBank(@ModelAttribute Bank bank, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("error");
		} else {
			bankService.create(bank);
			return new ModelAndView("bank");
		}
	}
}
