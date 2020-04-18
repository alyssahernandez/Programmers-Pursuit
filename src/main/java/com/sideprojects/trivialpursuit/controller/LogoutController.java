package com.sideprojects.trivialpursuit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {

	  private final String domain = "";
	  private final String clientId = "";
	    
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	protected String logout(final HttpServletRequest req) {
	    invalidateSession(req);

	    String returnTo = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort();

	    // Build logout URL like:
	    // https://{YOUR-DOMAIN}/v2/logout?client_id={YOUR-CLIENT-ID}&returnTo=http://localhost:3000
	    String logoutUrl = String.format("https://%s/v2/logout?client_id=%s&returnTo=%s", domain, clientId, returnTo);
	    
	    return "redirect:" + logoutUrl;
	}

	private void invalidateSession(HttpServletRequest request) {
	    if (request.getSession() != null) {
	        request.getSession().invalidate();
	    }
	}
}
