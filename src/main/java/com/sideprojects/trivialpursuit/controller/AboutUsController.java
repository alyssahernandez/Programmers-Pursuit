package com.sideprojects.trivialpursuit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AboutUsController {
	
	@RequestMapping(path="/about", method=RequestMethod.GET)
	public String displayMainMenu(ModelMap map) {
		return "aboutUs";
	}
}
