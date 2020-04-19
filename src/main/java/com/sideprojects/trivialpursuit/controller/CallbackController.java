package com.sideprojects.trivialpursuit.controller;

import java.io.IOException;
import java.net.HttpURLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.auth0.IdentityVerificationException;
import com.auth0.SessionUtils;
import com.auth0.Tokens;

@Controller
public class CallbackController {

	
	@Autowired
	private AuthController controller;
	
	@RequestMapping(value = "/callback", method = RequestMethod.GET)
	protected String getCallback(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
	  try {
	      Tokens tokens = controller.handle(req, res);
	      SessionUtils.set(req, "accessToken", tokens.getAccessToken());
	      SessionUtils.set(req, "idToken", tokens.getIdToken());
	      
	      //call DAO method and try to load userID with the id token
	      //if it works put the user id into the session
	      //if it doesnt work then call DAO method to create new user param(id)
	      
	      return "redirect:/profile";
	  } catch (IdentityVerificationException e) {
	      return "redirect:/login";
	  }
	}
}
