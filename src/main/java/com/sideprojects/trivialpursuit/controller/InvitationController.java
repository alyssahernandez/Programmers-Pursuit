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
import com.sideprojects.trivialpursuit.model.InvitationDAO;
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
	
	@Autowired
	InvitationDAO invitationDAO;

	@RequestMapping(path="/gameboard/{gameCode}/sendInvitation", method=RequestMethod.POST)
	public String sendInvitation(@RequestParam String username, @PathVariable String gameCode, final HttpServletRequest req, ModelMap map, RedirectAttributes flash) {
		
	    String userIdToken = (String) SessionUtils.get(req, "userIdToken");
	    User currentUser = userDAO.getUserByToken(userIdToken);
	    if (currentUser == null) return "redirect:/";
	    
		if (username == null || username.length() == 0) {
			flash.addAttribute("invalidEntry", true);
			return "redirect:/gameboard/" + gameCode;
		}
		
		// This isn't doing anything as of now  - Brooks
		Boolean isValid = userDAO.validateUsername(username);
		if (!isValid) {
			flash.addAttribute("userNotFound", true);
			return "redirect:/gameboard/" + gameCode;
		}
	    	
	    invitationDAO.sendInvitation(gameCode, username, currentUser.getUsername());
		
		return "redirect:/gameboard/" + gameCode;
	}
	
	@RequestMapping(path="/joinGame", method=RequestMethod.POST)
	public String joinGame(@RequestParam String gameCode, final HttpServletRequest req) {
		
	    String userIdToken = (String) SessionUtils.get(req, "userIdToken");
	    User currentUser = userDAO.getUserByToken(userIdToken);
	    if (currentUser == null) return "redirect:/";
	    
    	if (invitationDAO.doesInvitationExist(gameCode, currentUser.getUsername())) {
    		invitationDAO.deleteInvitation(gameCode, currentUser.getUsername());
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
		
	    String userIdToken = (String) SessionUtils.get(req, "userIdToken");
	    User currentUser = userDAO.getUserByToken(userIdToken);
	    if (currentUser == null) return "redirect:/";
	    String username = currentUser.getUsername();
	    
	    invitationDAO.deleteInvitation(gameCode, username);
	    
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
	
	@RequestMapping(path="/addFriend", method=RequestMethod.POST)
	public String addFriend(@RequestParam String username, final HttpServletRequest req) {
		
	    String userIdToken = (String) SessionUtils.get(req, "userIdToken");
	    User currentUser = userDAO.getUserByToken(userIdToken);
	    if (currentUser == null) return "redirect:/";
		
		invitationDAO.addFriend(currentUser.getUsername(), username);
		
		return "redirect:/profile/" + username;
	}
	
	@RequestMapping(path="/acceptFriendRequest", method=RequestMethod.POST)
	public String acceptFriendRequest(@RequestParam String username, final HttpServletRequest req) {
		
	    String userIdToken = (String) SessionUtils.get(req, "userIdToken");
	    User currentUser = userDAO.getUserByToken(userIdToken);
	    if (currentUser == null) return "redirect:/";
		
		invitationDAO.acceptFriendRequest(username, currentUser.getUsername());
		
		return "redirect:/profile/" + currentUser.getUsername();
	}
	
	@RequestMapping(path="/rejectFriendRequest", method=RequestMethod.POST)
	public String rejectFriendRequest(@RequestParam String username, final HttpServletRequest req) {
		
	    String userIdToken = (String) SessionUtils.get(req, "userIdToken");
	    User currentUser = userDAO.getUserByToken(userIdToken);
	    if (currentUser == null) return "redirect:/";
		
		invitationDAO.rejectFriendRequest(currentUser.getUsername(), username);
		
		return "redirect:/profile/" + currentUser.getUsername();
	}
	
	@RequestMapping(path="/removeFriend", method=RequestMethod.POST)
	public String removeFriend(@RequestParam String username, final HttpServletRequest req) {
		
	    String userIdToken = (String) SessionUtils.get(req, "userIdToken");
	    User currentUser = userDAO.getUserByToken(userIdToken);
	    if (currentUser == null) return "redirect:/";
		
		invitationDAO.removeFriend(username, currentUser.getUsername());
		
		return "redirect:/profile/" + username;
	}
	
	@RequestMapping(path="/cancelFriendRequest", method=RequestMethod.POST)
	public String cancelFriendRequest(@RequestParam String username, final HttpServletRequest req) {
		
	    String userIdToken = (String) SessionUtils.get(req, "userIdToken");
	    User currentUser = userDAO.getUserByToken(userIdToken);
	    if (currentUser == null) return "redirect:/";
		
		invitationDAO.cancelFriendRequest(currentUser.getUsername(), username);
		
		return "redirect:/profile/" + username;
	}

}
