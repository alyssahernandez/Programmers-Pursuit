package com.sideprojects.trivialpursuit.controller;


import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sideprojects.trivialpursuit.model.Player;
import com.sideprojects.trivialpursuit.model.PlayerDAO;
import com.sideprojects.trivialpursuit.model.Space;
import com.sideprojects.trivialpursuit.model.Dice;
import com.sideprojects.trivialpursuit.model.Game;
import com.sideprojects.trivialpursuit.model.GameDAO;

@Controller 
public class GameboardController {
	
	@Autowired
	PlayerDAO playerDAO;
	
	@Autowired
	GameDAO gameDAO;

	// HttpSession session
	// session.setAttribute(CART_KEY, cart);
	// ShoppingCart cart = (ShoppingCart)session.getAttribute(CART_KEY);

	// GET method is simply loading the current game state
	@RequestMapping(path="/gameboard/{gameCode}", method=RequestMethod.GET)
	public String displayGameboard(
			ModelMap model,
			@RequestParam(name = "isRollingDie", required = false) Boolean isRollingDie,
			@RequestParam(name = "isChoosingSpace", required = false) Boolean isChoosingSpace,
			@PathVariable String gameCode) {
		
		int dieRoll;
		Space activePlayerSpace = null;
		
		Game currentGame = gameDAO.getActiveGame(gameCode);
		model.put("currentGame", currentGame);

		/* every player object has a Space location, so we can call that in the jsp
		* to get all players and their current spaces - we can then use each of their
		* spaces and the space.getId() method to actually show it via CSS - ALYSSA
		*/
		
		List<Player> playersInGame = playerDAO.getAllPlayersInAGame(currentGame.getGameID());
		model.put("playersInGame", playersInGame);
		
		/* TODO BACK-END: the game table is where the active_player_id is stored, so we need a method
		 * in the game.java class that returns a PLAYER object - note: the
		 * SQL method etc should be done in the JDBCGameDAO file, so you'll need to link
		 * link the player ID to the player table to populate a player OBJECT 
		 * which will be returned in the method we're calling below - ALYSSA
		 */
		
		Player currentPlayerTurn = currentGame.getActivePlayer();
		model.put("currentPlayerTurn", currentPlayerTurn);
		
		/* when the page loads, we need to see if the die has been clicked on - the default
		 * value is no, of course, so the first if clause will only execute after a player
		 * has clicked on the die - ALYSSA
		 */
		if (isRollingDie != null && isChoosingSpace != null) {
			dieRoll = Dice.getDiceRoll();
			
		} else if {
			
		} else if {
			
		} else {
			return "gameboard";
		}

	}
		
	// store current game in session instead of db (but still create it upon
	// create game from main menu) - like the shopping cart
	
	@RequestMapping(path="/gameboard", method=RequestMethod.POST)
	public String displayGameboardWithPlayers(ModelMap model, HttpSession session,
			HttpServletRequest request) {
		
		// TODO method here for updating activePlayerID in db
		
		return "redirect:/gameboard";
	}
	
		
		
		/*
		 * main menu functionality: players add their names in a pop-up on
		 * the main menu when they create a game
		 */
		
		/* @RequestParam String toRoll, @RequestParam int playerID) {
		change method name once it's created - int = playerID toRoll = if die was clicked
		
		there is a dice class so change this: int playerDieRoll = player.getDiceRoll();
		
		back-end needs to create a roll() method in the JDBCPlayerDAO.java file
		that generates a # 1-6 & calls reachableSpaces() from space.java
		
		public List<Integer> roll(String toRoll, integer playerID) {
			String sqlStatement = "SELECT playerSpaceID FROM game_player
					INNER JOIN game_player & player WHERE player_id = player_id"
			all the sql stuff to pull from the db...
			
			similar method to availSpace in space.java to return List<Integer>
		
		}
		
		modelHolder.put("avaiableSpaces", availableSpaces); 
		*/
	
	

	//AC: my guess is that there will be a form on the jsp that the use will enter the space they want to 
	//go to based on the space methods, which will be the only (???) input needed from the user. from that form
	//there will be an int 1-76 to be passed into the getQuestionFromInt DAO method

	
}
