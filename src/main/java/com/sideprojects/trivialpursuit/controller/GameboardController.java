package com.sideprojects.trivialpursuit.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sideprojects.trivialpursuit.model.Category;
import com.sideprojects.trivialpursuit.model.CategoryDAO;
import com.sideprojects.trivialpursuit.model.Dice;
import com.sideprojects.trivialpursuit.model.Game;
import com.sideprojects.trivialpursuit.model.GameDAO;
import com.sideprojects.trivialpursuit.model.Gameboard;
import com.sideprojects.trivialpursuit.model.Player;
import com.sideprojects.trivialpursuit.model.PlayerDAO;
import com.sideprojects.trivialpursuit.model.Space;


@Controller 
public class GameboardController {
	
	@Autowired
	PlayerDAO playerDAO;
	
	@Autowired
	GameDAO gameDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	private static final String CURRENT_PLAYER_KEY = "currentPlayerTurn";
	private static final String GAME_KEY = "currentGame";
	
	/* BASIC VIEW
	
	@RequestMapping(path="/gameboard", method=RequestMethod.GET)
	public String displayGameboard() {
			
		return "/gameboard";
		
	} */

	@RequestMapping(path="/gameboard/{gameCode}", method=RequestMethod.GET)
	public String displayGameboard(
			ModelMap model,
			HttpSession session,
			@RequestParam(name = "isRollingDie", required = false) Boolean isRollingDie,
			// @RequestParam(name = "isChoosingSpace", required = false) Boolean isChoosingSpace,
			@PathVariable String gameCode) {
		
		Game currentGame = gameDAO.getActiveGame(gameCode);
		model.put("currentGame", currentGame);
		
		List<Player> playersInGame = currentGame.getActivePlayers();
		model.put("playersInGame", playersInGame);		
		
		Player currentPlayerTurn = gameDAO.getActivePlayer(currentGame);
		model.put("currentPlayerTurn", currentPlayerTurn);
		
		/* THE USE OF SESSIONS IS STILL UP IN THE AIR. - ALYSSA
		
		Player currentPlayerTurn = (Player)session.getAttribute(CURRENT_PLAYER_KEY);
		
		if (currentPlayerTurn == null) {
			currentPlayerTurn = gameDAO.getActivePlayer(currentGame);
			model.put("currentPlayerTurn", currentPlayerTurn);
			session.setAttribute(CURRENT_PLAYER_KEY, currentPlayerTurn);
		} */

		
//		 TODO THE IMPLEMENTATION ON THE NEXT LINE IS PREFERED BUT 
//			IS NOT CURRENTLY FUNCTIONAL 
//		Player currentPlayerTurn = currentGame.getActivePlayer();
		
		boolean isChoosingSpace;
		
		int diceRoll = currentPlayerTurn.getDiceRoll();
		
		if (diceRoll == 0) {
		
			if (isRollingDie != null && isRollingDie == true) {
				diceRoll = Dice.getDiceRoll();
				currentPlayerTurn.setDiceRoll(diceRoll);
				List<Space> reachableSpaces = currentPlayerTurn.getReachableSpaces(currentGame.getGameboard());
				model.put("reachableSpaces", reachableSpaces);
				isRollingDie = false;				
			}
			
		} else {
			isChoosingSpace = true;
			session.setAttribute("isChoosingSpace", isChoosingSpace);
		}
		
		List<Category> gameCategories = categoryDAO.getCategoriesByGame(currentGame);
		model.put("gameCategories", gameCategories);
		
		// THIS PASSES REACHABLE SPACES TO THE MODEL BASED ON THE DIE ROLL; THIS WILL
		// NEED TO BE ADJUSTED IF THE DIE ROLL IMPLEMENTATION IS CHANGES
		// -JEFF
		// List<Integer> reachableSpaces = currentPlayerTurn.getLocation().getReachableSpaces(diceRoll);		
	
		
		model.put("currentPlayerTurn", currentPlayerTurn);
		
		return "gameboard";

	}
	
	@RequestMapping(path="/gameboard/{gameCode}", method=RequestMethod.POST)
	public String displayGameboardWithPlayers(ModelMap model,
			HttpSession session,
			@RequestParam(name = "spaceChoice", required = false) String spaceChoice,
			@PathVariable String gameCode) {
		
		Game currentGame = gameDAO.getActiveGame(gameCode);
		Player currentPlayerTurn = gameDAO.getActivePlayer(currentGame);
		
		if (spaceChoice != null) {
			Space updatedPlayerSpace = currentGame.getGameboard().getSpaces().get(Integer.parseInt(spaceChoice));
			currentPlayerTurn.setLocation(updatedPlayerSpace);
			playerDAO.setPlayerPosition(currentGame);
		}
		
		return "redirect:/gameboard/{gameCode}";
	}
	
	
	

	//AC: my guess is that there will be a form on the jsp that the use will enter the space they want to 
	//go to based on the space methods, which will be the only (???) input needed from the user. from that form
	//there will be an int 1-76 to be passed into the getQuestionFromInt DAO method

	
}
