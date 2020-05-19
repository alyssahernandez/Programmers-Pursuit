package com.sideprojects.trivialpursuit.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.auth0.SessionUtils;
import com.sideprojects.trivialpursuit.model.Category;
import com.sideprojects.trivialpursuit.model.Dice;
import com.sideprojects.trivialpursuit.model.Game;
import com.sideprojects.trivialpursuit.model.GameDAO;
import com.sideprojects.trivialpursuit.model.Player;
import com.sideprojects.trivialpursuit.model.PlayerDAO;
import com.sideprojects.trivialpursuit.model.Space;
import com.sideprojects.trivialpursuit.model.User;
import com.sideprojects.trivialpursuit.model.UserDAO;


@Controller 
public class GameboardController {
	
	@Autowired
	private PlayerDAO playerDAO;
	
	@Autowired
	private GameDAO gameDAO;
	
	@Autowired
	private UserDAO userDAO;

	@RequestMapping(path="/gameboard/{gameCode}", method=RequestMethod.GET)
	public String displayGameboard(
			ModelMap model,
			@PathVariable String gameCode) {
				
		Game currentGame = gameDAO.getActiveGame(gameCode);
		
        if (currentGame != null) {
            model.put("currentGame", currentGame);
            
            if (currentGame.getIsActivePlayerAnsweringQuestion()) {
                return "redirect:/question/{gameCode}";
            }
                    
        } else {
        	
        	currentGame = gameDAO.getUnstartedGame(gameCode);
        	if (currentGame == null) {
                currentGame = gameDAO.getCompletedGame(gameCode);
                model.put("currentGame", currentGame);
        	} else {
        		model.put("currentGame", currentGame);
        	}
        }
        
		List<Player> playersInGame = currentGame.getActivePlayers();
		model.put("playersInGame", playersInGame);
		
		Player currentPlayerTurn = currentGame.getActivePlayer();
		model.put("currentPlayerTurn", currentPlayerTurn);
		
		List<Category> gameCategories = currentGame.getCategories();
		model.put("gameCategories", gameCategories);
		
		List<Space> reachableSpaces = currentPlayerTurn.getReachableSpaces(currentGame.getGameboard());
		model.put("reachableSpaces", reachableSpaces);
		
		boolean questionHUD = true;
		model.put("questionHUD", questionHUD);
			
		return "gameboard";
	
	}
	
	@RequestMapping(path="/gameboard/{gameCode}", method=RequestMethod.POST)
	public String displayGameboardWithPlayers(ModelMap model,
			@RequestParam(name = "spaceChoice", required = false) Integer spaceChoice,
			@PathVariable String gameCode) {
		
		Game currentGame = gameDAO.getActiveGame(gameCode);
		Player currentPlayerTurn = gameDAO.getActivePlayer(currentGame);
		Space updatedPlayerSpace = null;
		
		if (spaceChoice != null) {
			updatedPlayerSpace = currentGame.getGameboard().getSpaces().get(spaceChoice);
			currentPlayerTurn.setLocation(updatedPlayerSpace);
			playerDAO.setPlayerPosition(currentGame, currentPlayerTurn);
		}
		
		if (updatedPlayerSpace.isRollAgain()) {
			
	        int diceRoll = Dice.getDiceRoll();        
	        gameDAO.setActivePlayerDiceRoll(currentGame, diceRoll);
			
			return "redirect:/gameboard/{gameCode}";
		}
				
		return "redirect:/question/{gameCode}";
	}
	
	@RequestMapping(path="/gameboard/{gameCode}/sendInvitation", method=RequestMethod.POST)
	public String sendInvitation(@RequestParam String username, @PathVariable String gameCode, final HttpServletRequest req) {
		
	    String userId = (String) SessionUtils.get(req, "userIdToken");
	    User currentUser = userDAO.getUserByToken(userId);
	    
		Game game = gameDAO.getUnstartedGame(gameCode);
		Integer game_id = game.getGameID();
		
		gameDAO.sendInvitation(game_id, username, currentUser.getUsername());
		
		return "redirect:/gameboard/" + gameCode;
	}
}