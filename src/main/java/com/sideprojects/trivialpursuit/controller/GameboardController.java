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
import com.sideprojects.trivialpursuit.model.Player;
import com.sideprojects.trivialpursuit.model.PlayerDAO;

@Controller 
public class GameboardController {
	
	@Autowired
	PlayerDAO playerDAO;
	
	@Autowired
	GameDAO gameDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	/* BASIC VIEW
	
	@RequestMapping(path="/gameboard", method=RequestMethod.GET)
	public String displayGameboard() {
			
		return "/gameboard";
		
	}
	
	*/

	@RequestMapping(path="/gameboard/{gameCode}", method=RequestMethod.GET)
	public String displayGameboard(
			ModelMap model,
			HttpSession session,
			@RequestParam(name = "isRollingDie", required = false) Boolean isRollingDie,
			@RequestParam(name = "isChoosingSpace", required = false) Boolean isChoosingSpace,
			@PathVariable String gameCode) {
		
		Game currentGame = gameDAO.getActiveGame(gameCode);
		model.put("currentGame", currentGame);

		/* TODO FRONT-END: every player object has a Space location, so we can call 
		 * that in the jsp to get all players and their current spaces - we can then 
		 * use each of their spaces and the space.getId() method to actually show 
		 * it via CSS - ALYSSA
		*/
		
		List<Player> playersInGame = currentGame.getActivePlayers();
		model.put("playersInGame", playersInGame);
		
		/* TODO BACK-END: the game table is where the active_player_id is stored, so we need a method
		 * in the game.java class that returns a PLAYER object - note: the
		 * SQL method etc should be done in the JDBCGameDAO file, so you'll need to link
		 * link the player ID to the player table to populate a player OBJECT 
		 * which will be returned in the method we're calling below - ALYSSA
		 */
		
		Player currentPlayerTurn = gameDAO.getActivePlayer(currentGame);
//		 TODO THE IMPLEMENTATION ON THE NEXT LINE IS PREFERED BUT 
//			IS NOT CURRENTLY FUNCTIONAL 
//		Player currentPlayerTurn = currentGame.getActivePlayer();
		
		List<Category> gameCategories = categoryDAO.getCategoriesByGameId(currentGame);
		model.put("gameCategories", gameCategories);
		
		// THIS ATTACHES A RANDOM DIE ROLL TO THE CURRENT PLAYER BEFORE ADDING TO THE MODEL
		// THIS IS FOR IMPLEMENTATION TESTING FOR THE TIME BEING AND NOT LIKELY TO BE THE 
		// FINAL IMPLEMENTATION OF THIS FUNCTIONALITY
		// - JEFF
		
		int diceRoll = 0;
		
		if (isRollingDie != null && isRollingDie == true) {
			diceRoll = Dice.getDiceRoll();
			currentPlayerTurn.setDiceRoll(diceRoll);
			isRollingDie = false;
		} else if (isRollingDie == null || isRollingDie == false) {
			// something? nothing? TBD - ALYSSA
		}
		
		// THIS PASSES REACHABLE SPACES TO THE MODEL BASED ON THE DIE ROLL; THIS WILL
		// NEED TO BE ADJUSTED IF THE DIE ROLL IMPLEMENTATION IS CHANGES
		// -JEFF
		List<Integer> reachableSpaces = currentPlayerTurn.getLocation().getReachableSpaces(diceRoll);		
		
		model.put("reachableSpaces", reachableSpaces);
		
		model.put("currentPlayerTurn", currentPlayerTurn);
		
		/* when the page loads, we need to see if the die has been clicked on - the default
		 * value is no, of course, so the first if clause will only execute after a player
		 * has clicked on the die - ALYSSA
		 
		 
		if (isRollingDie == true) {
			
			// Maybe use currentPlayerTurn.getNewDiceRoll() here -- will update player's roll (can be retrieved & passed to View w/ player.getLastDiceRoll())
			diceRollValue = Dice.getDiceRoll();
			currentPlayerTurn.setDiceRoll(diceRollValue);
			model.put("diceRollValue", diceRollValue);
			
			/*  TODO: Let me know your thoughts on the comments below, comments throughout other files (Player, Gameboard, Game, JDBCGameDAO, JDBCPlayerDAO) 
			 
			    1.  availableSpacesFromRoll = currentPlayerTurn.getReachableSpaces(currentGame.getGameboard());
			   	2.  availableSpacesFromRoll = currentGame.getGameboard().getReachableSpaces(diceRollValue, currentPlayerTurn.getLocation().getId());
			  
			    ^^^ A couple of examples of how what's below could work (the examples asbove use a pair of methods to generate a List<Space>). See: files mentioned above.
			    Let me know if you have other ideas, want anything changed around, don't think it'll be useful, etc.
			    In order for #1 to work, currentPlayerTurn needs to have a dice roll set (see: note on like 78).  
			    See: Player class for additional notes.
			    We could store the game board and it's categorized spaces in the DB, too, which might make things easier overall.  Not sure.  
				
			
			availableSpacesFromRoll = currentPlayerTurn.getReachableSpaces(currentGame.getGameboard());
			model.put("availableSpacesFromRoll", availableSpacesFromRoll);
			
			/* TODO FRONT-END: the jsp file will need to check to see if the diceRollValue
			 * is null - if it isn't, display text telling the user what their roll is.
			 * if it is null, we'll keep the standard "player {name} it's your turn etc".
			 * same thing with the availableSpacesFromRoll - if's null, nothing happens &
			 * if it isn't null, the spaces available to the active player are displayed
			 * - ALYSSA
			 
			
		} else if (isChoosingSpace == true) {
			/* TODO FRONT-END: next week we're getting into JavaScript - we can use JS to
			 * create pop-ups with the questions on them - ALYSSA
			 
			
		} else {
			
			return "gameboard";
			
		}
		
		*/
		
		return "gameboard";

	}
	
	@RequestMapping(path="/gameboard", method=RequestMethod.POST)
	public String displayGameboardWithPlayers(ModelMap model, HttpSession session,
			HttpServletRequest request) {
		
		
		
		/* TODO FRONT-END: the POST method is where we're updating the db from
		 * a player's interactions with the forms (die roll & choosing spaces).
		 * i'm unsure of how JavaScript interacts with POS. i think we can make
		 * our pop-up window send an HTTP POST request with the player's answer
		 * to the question, which we can then use here... we'll see - ALYSSA
		 */
		
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
