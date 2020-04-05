package com.sideprojects.trivialpursuit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sideprojects.trivialpursuit.model.Game;
import com.sideprojects.trivialpursuit.model.GameDAO;

@Controller
public class MainMenuController {
	
	@Autowired
	GameDAO gameDAO;

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayMainMenu() {
			return "mainMenu";
	}
	
	@RequestMapping(path="/", method=RequestMethod.POST)
	public String createOrLoadGame(	
		@RequestParam(required=false) String gameSearch,
		@RequestParam(required=false) String playerName,
		@RequestParam(required=false) String gameName,
		ModelMap moldelHolder,
		RedirectAttributes flash) {
		
		/* next week we should be learning the javascript
		 * we need to create a pop-up form when a player
		 * clicks create game instead of searching for one,
		 * so i'm not sure which of this code will need to
		 * be rewritten - Alyssa
		 */
			
		
		/* TODO from the main menu, we need to create
		 * and store a list of users in the database based on the
		 * names of players that are typed into the create game
		 * form - Alyssa
		 */
		
//		THIS SECTION SEARCHES FOR AND RETURNS AN ACTIVE GAME; THE REDIRECT IN  - JEFF
			Game activeGame = gameDAO.getActiveGame(gameSearch.toUpperCase());
			
			if (activeGame.getGameCode() != null) {				
				moldelHolder.put("activeGame", activeGame);
				return "redirect:/gameboard/" + activeGame.getGameCode();
			} else {
				return "redirect:/";
			}
			
		
		/* else if (playerName != null && gameName != null) {
			try {
				
				 TODO there needs to be a method in the JDBCGameDAO file
				 * that allows players to create a new game by typing
				 * in the game code - there is a setGameCode() method
				 * i think - Alyssa
				 * 
				Game newGame = gameDAO.createNewGame(gameName.toUpperCase());
				moldelHolder.put("newGame", newGame);
				
				
				
				// need to return a popup that allows users to join...
				return "mainMenu";
			} catch(Exception e) {			
				return "mainMenu";
			}
		}
		*/

	//	return "redirect:/";
	}
}
