package com.sideprojects.trivialpursuit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@Autowired
	private AuthController controller;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	protected String login(final HttpServletRequest req, final HttpServletResponse res) {
	    String redirectUrl = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() +
	    		req.getContextPath() + "/callback";
	    String authorizeUrl = controller.buildAuthorizeUrl(req, res, redirectUrl);
	    return "redirect:" + authorizeUrl;
	}
	
}
 