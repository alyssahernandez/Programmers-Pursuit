package com.sideprojects.trivialpursuit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.auth0.SessionUtils;
import com.sideprojects.trivialpursuit.model.User;
import com.sideprojects.trivialpursuit.model.UserDAO;

@Controller
public class AboutUsController {
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(path="/about", method=RequestMethod.GET)
	public String displayMainMenu(ModelMap map, final HttpServletRequest req) {
		
	    String userId = (String) SessionUtils.get(req, "userIdToken");
	    User currentUser = userDAO.getUserByToken(userId);
	    
	    if (currentUser == null) map.put("currentUser", null);
	    else map.put("currentUser", currentUser);
	    
		return "aboutUs";
	}
}
