package com.sideprojects.trivialpursuit.controller;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.auth0.SessionUtils;
import com.sideprojects.trivialpursuit.model.Category;
import com.sideprojects.trivialpursuit.model.CategoryDAO;
import com.sideprojects.trivialpursuit.model.Game;
import com.sideprojects.trivialpursuit.model.GameDAO;
import com.sideprojects.trivialpursuit.model.Invitation;
import com.sideprojects.trivialpursuit.model.Player;
import com.sideprojects.trivialpursuit.model.PlayerDAO;
import com.sideprojects.trivialpursuit.model.QuestionDAO;
import com.sideprojects.trivialpursuit.model.User;
import com.sideprojects.trivialpursuit.model.UserDAO;
import com.sideprojects.trivialpursuit.model.auth.*;


@Controller
public class MainMenuController {
	
	@Autowired
	GameDAO gameDAO;
	
	@Autowired
	PlayerDAO playerDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	QuestionDAO questionDAO;
	
	private AppConfig config;

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayMainMenu(ModelMap map) {
		return "mainMenu";
	}
	
	//// AUTH0 CONTROLLER TO REDIRECT TO THE USERS PROFILE PAGE
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	protected String home(final Map<String, Object> model, final HttpServletRequest req) {
		
		// Would be used to display a category selection in gameCreation.jsp
		List<Category> categories = categoryDAO.getAllCategories();
		
		
	    String accessToken = (String) SessionUtils.get(req, "accessToken");
	    String idToken = (String) SessionUtils.get(req, "idToken");
	    String userId = (String) SessionUtils.get(req, "userIdToken");
	    
	    User currentUser = userDAO.getUserByToken(userId);
	    
	    List<Invitation> invitations = gameDAO.getInvitations(currentUser.getUsername());
	    		
	    if (accessToken != null) {
		    model.put("currentUser", currentUser);
		    model.put("categories", categories);
		    model.put("invitations", invitations);
		    
		} else if (idToken != null) {
		    model.put("currentUser", currentUser);
		    model.put("categories", categories);
		    model.put("invitations", invitations);
		}
	    req.getRemoteUser();
	    
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
				return "mainMenu";
			}
	}
			
			
	@RequestMapping(path="/create", method=RequestMethod.POST)
	public String createGame(@RequestParam List<Integer> categorySelection, final HttpServletRequest req) {
		
		int userId = (Integer) SessionUtils.get(req, "userId");
	
	/*  Because we removed the Player table, these methods are no longer used. 
	 * 	
		playerDAO.createPlayer(userId, nickname);
		Player newPlayer = playerDAO.getPlayer(userId);
	*/	
		
		
		String newGameCode = gameDAO.createNewGame();
		//Game newGame = gameDAO.getActiveGame(gameCode);
		Game newGame = gameDAO.getUnstartedGame(newGameCode);
		
		playerDAO.putFirstPlayerIntoGame(newGame, userId);
		
		categoryDAO.setCategoriesByGameId(newGame, categorySelection);
		questionDAO.setGameQuestions(newGame, categorySelection);
		
		return "redirect:/gameboard/" + newGameCode;
	}
	
	

}

