package com.sideprojects.trivialpursuit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class GameboardController {

	@RequestMapping(path="/Gameboard", method=RequestMethod.GET)
	public String displayGameboard(Model modelHolder) {		
		return "gameboard";
	}
}
