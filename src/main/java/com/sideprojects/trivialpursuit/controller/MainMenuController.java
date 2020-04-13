package com.sideprojects.trivialpursuit.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sideprojects.trivialpursuit.model.Game;
import com.sideprojects.trivialpursuit.model.GameDAO;
import com.sideprojects.trivialpursuit.model.Player;
import com.sideprojects.trivialpursuit.model.PlayerDAO;

import com.sideprojects.trivialpursuit.model.auth.AuthProvider;
import com.sideprojects.trivialpursuit.model.auth.User;


@Controller
public class MainMenuController {
	
	@Autowired
	GameDAO gameDAO;
	
	@Autowired
	PlayerDAO playerDAO;
	
	@Autowired
	private AuthProvider auth;

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayMainMenu(ModelMap map) {
		map.put("user", auth.getCurrentUser());
		return "mainMenu";
	}
	
	@RequestMapping(path="/", method=RequestMethod.POST)
	public String createOrLoadGame(	
		@RequestParam(required=false) String gameSearch,
		@RequestParam(required=false) String playerName,
		@RequestParam(required=false) String gameName,
		ModelMap moldelHolder,
		RedirectAttributes flash) {
			
		
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
				flash.addFlashAttribute("message", "Game Not Found");
				return "mainMain";
			}
	}
			
			
	@RequestMapping(path="/create", method=RequestMethod.GET)
	public String displayCreateGameForm() {
		return "createGame";
	}
	
	@RequestMapping(path="/create", method=RequestMethod.POST)
	public String createGame(
			@RequestParam String gameCode,
			@RequestParam String playerOne, @RequestParam(required=false) String playerTwo,
			@RequestParam String playerThree, @RequestParam String playerFour,
			@RequestParam String playerFive, @RequestParam String playerSix
			) {
		
		List<String> playerNames = new ArrayList<>();
		playerNames.add(playerOne);
		playerNames.add(playerTwo);
		playerNames.add(playerThree);
		playerNames.add(playerFour);
		playerNames.add(playerFive);
		playerNames.add(playerSix);
		
		playerDAO.createPlayers(playerNames);
		
		
		/*
		 * if(playerTwo != null) { Player player = new Player();
		 * player.setName(playerTwo); players.add(player); }
		 */
		
		return "redirect:/gameboard/${gamecode}";
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

