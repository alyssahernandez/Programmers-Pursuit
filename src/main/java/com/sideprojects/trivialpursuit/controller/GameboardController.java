package com.sideprojects.trivialpursuit.controller;


import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sideprojects.trivialpursuit.model.Player;
import com.sideprojects.trivialpursuit.model.PlayerDAO;

@Controller 
public class GameboardController {
	
	@Autowired
	PlayerDAO playerDAO;

	// HttpSession session
	// session.setAttribute(CART_KEY, cart);
	// ShoppingCart cart = (ShoppingCart)session.getAttribute(CART_KEY);

	@RequestMapping(path="/gameboard", method=RequestMethod.GET)
	public String displayGameboard(Model modelHolder) {
		return "gameboard";
	}
		
	// store current game in session instead of db (but still create it upon
	// create game from main menu) - like the shopping cart
	
	@RequestMapping(path="/gameboard", method=RequestMethod.POST)
	public String displayGameboardWithPlayers(Model molderHolder, HttpSession session,
			HttpServletRequest request) {
		
		// TODO method here for pulling activePlayerID from db
				
		@SuppressWarnings("unchecked")
		List<Player> playersInGame = (List<Player>) session.getAttribute("playersInGame"); 
		
		// Player currentPlayer = playerDAO.getPlayerById(1L);
		
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
