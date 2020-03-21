package com.sideprojects.trivialpursuit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainMenuController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String getMainMenu() {
		return "mainMenu";
	}
	
}
