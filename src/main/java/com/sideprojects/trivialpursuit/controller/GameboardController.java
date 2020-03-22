package com.sideprojects.trivialpursuit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class GameboardController {

	@RequestMapping("/")
	public String displayGameboard() {		
		return "gameboard";
	}
	
	//AC: my guess is that there will be a form on the jsp that the use will enter the space they want to 
	//go to based on the space methods, which will be the only (???) input needed from the user. from that form
	//there will be an int 1-76 to be passed into the getQuestionFromInt DAO method
	
}
