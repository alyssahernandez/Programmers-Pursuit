package com.sideprojects.trivialpursuit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class GameboardController {
	
	/* back-end add this class!!
	@Autowired
	PlayerDAO playerDAO;
	*/

	@RequestMapping(path="/gameboard", method=RequestMethod.GET)
	public String displayGameboard(Model modelHolder) {
			
		
		/* @RequestParam String toRoll, @RequestParam int playerID) {
		change method name once it's created - int = playerID toRoll = if die was clicked
		
		List<Integer> availableSpaces = playerDAO.roll(toRoll, playerID);
		
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
		
		return "gameboard";
		
	}
	

	//AC: my guess is that there will be a form on the jsp that the use will enter the space they want to 
	//go to based on the space methods, which will be the only (???) input needed from the user. from that form
	//there will be an int 1-76 to be passed into the getQuestionFromInt DAO method

	
}
