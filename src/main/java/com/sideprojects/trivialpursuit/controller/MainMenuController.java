package com.sideprojects.trivialpursuit.controller;


import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.auth0.SessionUtils;
import com.sideprojects.trivialpursuit.model.Game;
import com.sideprojects.trivialpursuit.model.GameDAO;
import com.sideprojects.trivialpursuit.model.Player;
import com.sideprojects.trivialpursuit.model.PlayerDAO;



@Controller
public class MainMenuController {
	
	@Autowired
	GameDAO gameDAO;
	
	@Autowired
	PlayerDAO playerDAO;
	

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayMainMenu(ModelMap map) {
		return "mainMenu";
	}
	
	//// AUTH0 CONTROLLER TO REDIRECT TO THE USERS PROFILE PAGE
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	protected String home(final Map<String, Object> model, final HttpServletRequest req, ModelMap map) {
	    String accessToken = (String) SessionUtils.get(req, "accessToken");
	    String idToken = (String) SessionUtils.get(req, "idToken");
	    if (accessToken != null) {
	        model.put("userId", accessToken);
	        map.put("userId", accessToken);
	    } else if (idToken != null) {
	        model.put("userId", idToken);
	        map.put("userId", idToken);
	        
	    }
	    return "profilePage";
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

