package com.sideprojects.trivialpursuit.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
			@PathVariable String gameCode) {
		
		Game currentGame = gameDAO.getActiveGame(gameCode);
		model.put("currentGame", currentGame);
		
		Player currentPlayerTurn = gameDAO.getActivePlayer(currentGame);
		model.put("currentPlayerTurn", currentPlayerTurn);
		
		Space currentPlayerSpace = currentPlayerTurn.getLocation();
		model.put("currentPlayerSpace", currentPlayerSpace);
				
		List<Category> gameCategories = categoryDAO.getCategoriesByGame(currentGame);
		Set<Category> hashedCategories = new HashSet<>(gameCategories);
		model.put("hashedCategories", hashedCategories);
		
		if (!currentPlayerSpace.isCenter() && !currentPlayerSpace.isRollAgain()) {
			Question question = questionDAO.getUnaskedQuestionByCategory(currentGame,
					currentPlayerSpace.getCategory().getCategoryId());
			model.put("question", question);
		}
		

		return "question";
	}
	
	@RequestMapping(path="/question/{gameCode}", method=RequestMethod.POST)
	public String submitQuestion(
			@PathVariable String gameCode,
			@RequestParam(name = "categoryChoice", required = false) Integer categoryChoiceId,
			@RequestParam(name = "questionChosen", required = false, defaultValue = "false") String chosenCenterSpaceCategory,
			ModelMap model) {
		
		model.put("hasChosenCenterSpaceCategory", chosenCenterSpaceCategory);
		
		Game currentGame = gameDAO.getActiveGame(gameCode);
		model.put("currentGame", currentGame);
		
		Player currentPlayerTurn = gameDAO.getActivePlayer(currentGame);
		model.put("currentPlayerTurn", currentPlayerTurn);
		
		Space currentPlayerSpace = currentPlayerTurn.getLocation();
		model.put("currentPlayerSpace", currentPlayerSpace);
		
		if (currentPlayerSpace.isCenter() && categoryChoiceId != null && chosenCenterSpaceCategory.equals("true")) {
			Question question = questionDAO.getUnaskedQuestionByCategory(currentGame,
					categoryChoiceId);
			model.put("question", question);
			return "redirect:/question";
		}
		
		return "redirect:/gameboard/" + currentGame.getGameCode();
	}
		
}
