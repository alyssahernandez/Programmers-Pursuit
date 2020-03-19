package com.sideprojects.trivialpursuit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class GameboardController {

	@RequestMapping("/")
	public String displayGameboard() {		
		return "gameboard";
	}
}
