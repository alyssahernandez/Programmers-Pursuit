package com.sideprojects.trivialpursuit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sideprojects.trivialpursuit.model.Category;
import com.sideprojects.trivialpursuit.model.CategoryDAO;
import com.sideprojects.trivialpursuit.model.Game;
import com.sideprojects.trivialpursuit.model.GameDAO;
import com.sideprojects.trivialpursuit.model.Player;
import com.sideprojects.trivialpursuit.model.Question;
import com.sideprojects.trivialpursuit.model.QuestionDAO;
import com.sideprojects.trivialpursuit.model.Space;

@Controller
public class QuestionController {
	
	@Autowired
	private GameDAO gameDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private QuestionDAO questionDAO;

	@RequestMapping(path="/question/{gameCode}", method=RequestMethod.GET)
	public String displayQuestion(
			ModelMap model,
			@PathVariable String gameCode
			) {
		Game currentGame = gameDAO.getActiveGame(gameCode);
		model.put("currentGame", currentGame);
		
		Player currentPlayerTurn = gameDAO.getActivePlayer(currentGame);
		model.put("currentPlayerTurn", currentPlayerTurn);
		
		Space currentPlayerSpace = currentPlayerTurn.getLocation();
		
		// List<Category> gameCategories = categoryDAO.getCategoriesByGame(currentGame);
		// model.put("gameCategories", gameCategories);
		
		String category =  
				currentPlayerSpace.getCategory().getCategoryName();
		
		model.put("category", category);
		


		return "question";
	}
	
	@RequestMapping(path="/question/{gameCode}", method=RequestMethod.POST)
	public String submitQuestion(
			@PathVariable String gameCode,
			ModelMap model
			) 
	{
		Game currentGame = gameDAO.getActiveGame(gameCode);
		model.put("currentGame", currentGame);
		
		return "redirect:/gameboard/" + currentGame.getGameCode();
	}
		
}
