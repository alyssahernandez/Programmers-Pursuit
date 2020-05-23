package com.sideprojects.trivialpursuit.controller;



import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.auth0.SessionUtils;
import com.sideprojects.trivialpursuit.model.Category;
import com.sideprojects.trivialpursuit.model.CategoryDAO;
import com.sideprojects.trivialpursuit.model.GameCreationForm;
import com.sideprojects.trivialpursuit.model.Game;
import com.sideprojects.trivialpursuit.model.GameDAO;
import com.sideprojects.trivialpursuit.model.Invitation;
import com.sideprojects.trivialpursuit.model.InvitationDAO;
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
	
	@Autowired
	InvitationDAO invitationDAO;
	
	private AppConfig config;

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayMainMenu(ModelMap map) {
		return "mainMenu";
	}
	
	//// AUTH0 CONTROLLER TO REDIRECT TO THE USERS PROFILE PAGE
	
	@RequestMapping(value = "/profile/{username}", method = RequestMethod.GET)
	protected String home(@PathVariable String username, final Map<String, Object> model, final HttpServletRequest req, Model modelHolder) {
		
		if (!modelHolder.containsAttribute("createGame")) {
			modelHolder.addAttribute("createGame", new GameCreationForm());
		}
		
	    String accessToken = (String) SessionUtils.get(req, "accessToken");
	    String idToken = (String) SessionUtils.get(req, "idToken");
	    String userId = (String) SessionUtils.get(req, "userIdToken");
	    User currentUser = userDAO.getUserByToken(userId);
	    
	    List<Invitation> invitations = invitationDAO.getInvitations(currentUser.getUsername());
		
	    // This is to pair categories with invitations. We could add a categories property to Invitation class, but eh, this seems easier. Checks in JDBCs should ensure that categories always pull - Brooks
	    Map<Invitation, List<Category>> pairs = new HashMap<>();
		for (Invitation i : invitations) {
			String gameCode = i.getGameCode();
			List<Category> cats = gameDAO.getUnstartedGame(gameCode).getUniqueCategories();
			pairs.put(i, cats);
		}
				
		List<Category> categories = categoryDAO.getAllCategories();
		
	    if (accessToken != null) {
		    model.put("currentUser", currentUser);
		    model.put("categories", categories);
		    model.put("invitations", invitations);
		    model.put("pairs", pairs);
		    
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
	public String createGame(@Valid @ModelAttribute("createGame") GameCreationForm selectionForm, 
							 BindingResult result, 
							 final HttpServletRequest req, 
							 RedirectAttributes flash) {
		
		String newGameCode = gameDAO.createNewGame(selectionForm.getPublicOrPrivate());
		Game newGame = gameDAO.getUnstartedGame(newGameCode);
		
		if (result.hasErrors()) {
			flash.addFlashAttribute("createGame", selectionForm);
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "createGame", result);
			
		    String userId = (String) SessionUtils.get(req, "userIdToken");
		    User currentUser = userDAO.getUserByToken(userId);
		    
			return "redirect:/profile/" + currentUser.getUsername();
		}
		int userId = (Integer) SessionUtils.get(req, "userId");
		
		playerDAO.putFirstPlayerIntoGame(newGame, userId);
		categoryDAO.setCategoriesByGameId(newGame, selectionForm.getSelectedCategories());
		questionDAO.setGameQuestions(newGame, selectionForm.getSelectedCategories());
		
		return "redirect:/gameboard/" + newGameCode;
	}
}

