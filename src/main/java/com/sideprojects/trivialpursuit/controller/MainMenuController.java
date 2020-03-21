package com.sideprojects.trivialpursuit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainMenuController {
	
	GameDAO gameDAO;

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String getMainMenu() {
		
	/*
	public String 
		@RequestParam String gameSearch,
		@RequestParam String playerName,
		RequestAttribute requestAttribute
		)
	
		boolean isGameExisting;
		
		-- THIS METHOD SEARCHES THE DB FOR AN EXISTING GAME
		-- IF IT'S TRUE, THE USER'S SEARCH WILL TAKE THEM
		-- TO THE EXISTING GAME URL
		isGameExisting = gameDAO.gameSearch(gameSearch);
		
		if (isGameExisting == true) {
			return "/gameboard/{gameSearch}";
		} else {
			// flash scope message about not existing
			return "/";
		}
	}
		
		*/
		
		
		return "mainMenu";
	}
	
	@RequestMapping(path="/", method=RequestMethod.POST)
	public String createGame(

	
		if (createGame.equals("createGame")) {
			
		}
		
}
