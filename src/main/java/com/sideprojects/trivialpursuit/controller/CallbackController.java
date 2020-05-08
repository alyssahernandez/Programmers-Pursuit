package com.sideprojects.trivialpursuit.controller;

import java.io.IOException;

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
import com.auth0.client.auth.AuthAPI;
import com.auth0.json.auth.UserInfo;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sideprojects.trivialpursuit.model.User;
import com.sideprojects.trivialpursuit.model.UserDAO;

import org.json.JSONArray;
import org.json.JSONObject;



@Controller
public class CallbackController {

	@Autowired
	private AuthController controller;
	
	@Autowired
	private UserDAO user;
	
	
	@RequestMapping(value = "/callback", method = RequestMethod.GET)
	protected String getCallback(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, 
	IOException, UnirestException {
	  try {
	      Tokens tokens = controller.handle(req, res);
	      SessionUtils.set(req, "accessToken", tokens.getAccessToken());
	      SessionUtils.set(req, "idToken", tokens.getIdToken());
	      
	      //call DAO method and try to load userID with the id token
	      //if it works put the user id into the session
	      //if it doesnt work then call DAO method to create new user param(id)
	      
		
	      AuthAPI auth = new AuthAPI("dev-3pru6zrv.auth0.com", "0mWzxq2llBlbc7a3up2rOISQV96i847w",
					"8KCBnXpiGUyqjxhX1WEGMSYI76-fesU5qh8OuP7g_vnE_dcdmH9TdKyQFt6ID1aj");
	      
	      String accessToken = (String) SessionUtils.get(req, "accessToken");
	      UserInfo result = auth.userInfo(accessToken).execute();
	      
	      String idToken = (String) result.getValues().values().toArray()[0];
	      
	      
	      HttpResponse<String> response = Unirest.post("https://dev-3pru6zrv.auth0.com/oauth/token")
	  		.header("content-type", "application/json")
	  		.body("{\"client_id\":\"0mWzxq2llBlbc7a3up2rOISQV96i847w\",\"client_secret\":\"8KCBnXpiGUyqjxhX1WEGMSYI76-fesU5qh8OuP7g_vnE_dcdmH9TdKyQFt6ID1aj\",\"audience\":\"https://dev-3pru6zrv.auth0.com/api/v2/\",\"grant_type\":\"client_credentials\"}")
	  		.asString();
	  			  
	  	  String body = response.getBody();
	  	  JSONObject bodyJSON = new JSONObject(body);
	  			 
	  			
	  	  HttpResponse<String> readUserResponse = Unirest.get("https://dev-3pru6zrv.auth0.com/api/v2/users/" + idToken)
	  	  	.header("content-type", "application/json")
	  	  	.header("authorization", "Bearer " + bodyJSON.getString("access_token"))
	  	  	.asString();
	  	  
	  	  String userInfo = readUserResponse.getBody();
	  	  JSONObject userJSON = new JSONObject(userInfo);
	  	  
	  	  JSONArray identities = userJSON.getJSONArray("identities");
	  	  JSONObject ids = identities.getJSONObject(0);
	  	  
	  	  String userId = ids.getString("user_id");
	  	  String nickname = userJSON.getString("nickname");
	  	  String email = userJSON.getString("email");
	  	  String picture = userJSON.getString("picture");
	  	  
	  	  SessionUtils.set(req, "userId", userId);
	      
	      if(user.getUserByToken(userId) != null) {
	    	  User currentUser = user.getUserByToken(idToken);
	      } else {
	    	  user.createUser(nickname, userId, email, picture);
	      }
	 
	      return "redirect:/profile";
	  } catch (IdentityVerificationException e) {
	      return "redirect:/login";
	  }
	}

}
