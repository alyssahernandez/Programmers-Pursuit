package com.sideprojects.trivialpursuit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sideprojects.trivialpursuit.model.Category;
import com.sideprojects.trivialpursuit.model.CategoryDAO;

@Controller
public class LobbyController {
	
	@Autowired
	CategoryDAO categoryDAO;	
	
	@RequestMapping(value = "/lobby", method = RequestMethod.GET)
	protected String lobby(
			ModelMap model
			) {
		List<Category> categories = categoryDAO.getAllCategories();

		model.put("categories", categories);
		
	    return "lobby";
	}
	
}
