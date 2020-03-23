package com.sideprojects.trivialpursuit.controller;

import org.eclipse.jdt.annotation.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sideprojects.trivialpursuit.model.Game;
import com.sideprojects.trivialpursuit.model.GameDAO;

import com.sideprojects.trivialpursuit.model.GameDAO;

@Controller
public class MainMenuController {
	
	GameDAO gameDAO;

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayMainMenu() {
			return "mainMenu";
	}
	
	@RequestMapping(path="/", method=RequestMethod.POST)
	public String createOrLoadGame(	
		@RequestParam @Nullable String gameSearch,
		@RequestParam @Nullable String playerName,
		@RequestParam @Nullable String gameName,
		ModelMap moldelHolder,
		RedirectAttributes flash) {
	
		/* THIS METHOD SEARCHES THE DB FOR AN EXISTING GAME
		IF IT'S TRUE, THE USER'S SEARCH WILL TAKE THEM
		TO THE EXISTING GAME URL */
			try {
				Game activeGame = gameDAO.getActiveGame(gameSearch);
				moldelHolder.put("activeGame", activeGame);
				return "gameboard";
			} catch(Exception e) {
				
			}
		
		
		/* else if (playerName != null && gameName != null) {
			try {
				
				 TODO there needs to be a method in the JDBCGameDAO file
				 * that allows players to create a new game by typing
				 * in the game code
				 * 
				Game newGame = gameDAO.createNewGame(gameName);
				moldelHolder.put("newGame", newGame);
				
				
				
				// need to return a popup that allows users to join...
				return "mainMenu";
			} catch(Exception e) {			
				return "mainMenu";
			}
		}
		*/

		return "mainMenu";
	}
}
