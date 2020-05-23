package com.sideprojects.trivialpursuit.controller;

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
import com.sideprojects.trivialpursuit.model.Game;
import com.sideprojects.trivialpursuit.model.GameDAO;
import com.sideprojects.trivialpursuit.model.PlayerDAO;
import com.sideprojects.trivialpursuit.model.User;
import com.sideprojects.trivialpursuit.model.UserDAO;

@Controller
public class InvitationController {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	GameDAO gameDAO;
	
	@Autowired
	PlayerDAO playerDAO;

	@RequestMapping(path="/gameboard/{gameCode}/sendInvitation", method=RequestMethod.POST)
	public String sendInvitation(@RequestParam String username, @PathVariable String gameCode, final HttpServletRequest req, ModelMap map, RedirectAttributes flash) {
		
		if (username == null || username.length() == 0) {
			flash.addAttribute("invalidEntry", true);
			return "redirect:/gameboard/" + gameCode;
		}
		
		Boolean isValid = userDAO.validateUsername(username);
		if (!isValid) {
			flash.addAttribute("userNotFound", true);
			return "redirect:/gameboard/" + gameCode;
		}
		
	    String userId = (String) SessionUtils.get(req, "userIdToken");
	    User currentUser = userDAO.getUserByToken(userId);
	    	
		gameDAO.sendInvitation(gameCode, username, currentUser.getUsername());
		
		return "redirect:/gameboard/" + gameCode;
	}
	
	@RequestMapping(path="/joinGame", method=RequestMethod.POST)
	public String joinGame(@RequestParam String gameCode, final HttpServletRequest req) {
		
	    String userId = (String) SessionUtils.get(req, "userIdToken");
	    User currentUser = userDAO.getUserByToken(userId);
	    
    	if (gameDAO.doesInvitationExist(gameCode, currentUser.getUsername())) {
    		gameDAO.deleteInvitation(gameCode, currentUser.getUsername());
    	}
	  
	    Game newGame = gameDAO.getUnstartedGame(gameCode);
	    
	    // As within rejectGame() below, the next 14 lines are to handle goobers who hit the back button and try to Join/Reject the game again.  We should figure out a better solution, but this works for now (tho hitting Reject will remove from game if already in as a deterrent)
	    if (newGame == null) {
	    	newGame = gameDAO.getActiveGame(gameCode);
	    	if (newGame == null) {
	    		return "redirect:/profile/" + currentUser.getUsername();
	    	} else {
	    	    boolean playerAlreadyInGame = playerDAO.isPlayerAlreadyInGame(newGame.getGameID(), currentUser.getUserId());
	    	    if (playerAlreadyInGame) return "redirect:/gameboard/" + gameCode;
	    	    else return "redirect:/profile/" + currentUser.getUsername();
	    	}
	    }
	    
	    boolean playerAlreadyInGame = playerDAO.isPlayerAlreadyInGame(newGame.getGameID(), currentUser.getUserId());
	    if (playerAlreadyInGame) {
	    	return "redirect:/gameboard/" + gameCode;
	    }
	   
	    Integer numberOfPlayers = gameDAO.getPlayerCountByGame(gameCode);
	    if (numberOfPlayers <= 0 || numberOfPlayers >= 6 || numberOfPlayers == null) {
	    	return "redirect:/profile/" + currentUser.getUsername();
	    }
	    
	    Integer playerColorId = numberOfPlayers + 1;
	    playerDAO.putPlayerIntoGame(newGame.getGameID(), currentUser.getUserId(), playerColorId);
	    
	    return "redirect:/gameboard/" + gameCode;
	}
	
	@RequestMapping(path="/rejectGame", method=RequestMethod.POST)
	public String rejectGame(@RequestParam String gameCode, final HttpServletRequest req) {
		
	    String userId = (String) SessionUtils.get(req, "userIdToken");
	    User currentUser = userDAO.getUserByToken(userId);
	    String username = currentUser.getUsername();
	    
	    gameDAO.deleteInvitation(gameCode, username);
	    
	    Game newGame = gameDAO.getUnstartedGame(gameCode);

	    if (newGame == null) {
	    	newGame = gameDAO.getActiveGame(gameCode);
	    	if (newGame == null) {
	    		return "redirect:/profile/" + currentUser.getUsername();
	    	} else {
	    	    boolean playerAlreadyInGame = playerDAO.isPlayerAlreadyInGame(newGame.getGameID(), currentUser.getUserId());
	    	    if (playerAlreadyInGame) {
	    	    	return "redirect:/gameboard/" + gameCode;
	    	    }
	    	    return "redirect:/profile/" + currentUser.getUsername();
	    	}
	    } 
	    
	    boolean playerAlreadyInGame = playerDAO.isPlayerAlreadyInGame(newGame.getGameID(), currentUser.getUserId());
	    if (playerAlreadyInGame) {
	    	return "redirect:/gameboard/" + gameCode;
	    }
	    
	    return "redirect:/profile/" + username;
	}
}
