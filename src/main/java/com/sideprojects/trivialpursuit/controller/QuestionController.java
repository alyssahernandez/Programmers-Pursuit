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
import com.sideprojects.trivialpursuit.model.PlayerDAO;
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
	
	@Autowired
	private PlayerDAO playerDAO;

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
				
		// TODO: I made a "game.getUniqueCategories()" method that you could call instead of using a DAO & HashSetting the categories here. - Brooks
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
			@RequestParam(name = "answer", required = false) String answer,
			ModelMap model) {
		
		model.put("hasChosenCenterSpaceCategory", chosenCenterSpaceCategory);
		
		Game currentGame = gameDAO.getActiveGame(gameCode);
		model.put("currentGame", currentGame);
		
		Player currentPlayerTurn = gameDAO.getActivePlayer(currentGame);
		model.put("currentPlayerTurn", currentPlayerTurn);
		
		Space currentPlayerSpace = currentPlayerTurn.getLocation();
		model.put("currentPlayerSpace", currentPlayerSpace);
		
		Integer categoryId = null;
		
		if (categoryChoiceId != null) {
			categoryId = categoryChoiceId;
		} else {
			categoryId = currentPlayerSpace.getCategory().getCategoryId();
		}
		
		if (currentPlayerSpace.isCenter() && categoryChoiceId != null && chosenCenterSpaceCategory.equals("true")) {
			Question question = questionDAO.getUnaskedQuestionByCategory(currentGame,
					categoryChoiceId);
			model.put("question", question);
			
			return "redirect:/question";
		}
		
		// Changed to equalsIgnoreCase - Brooks
		boolean isAnswerCorrect = answer.equalsIgnoreCase(questionDAO.getUnaskedQuestionByCategory(currentGame,
				categoryId).getAnswer());
		
		// I could call givePlayerPiePiece() in setActivePlayer(), including this conditional with it. You'd just have to call setActivePlayer() as you did below. Would shorten a couple of files. Lmk. - Brooks
		if (currentPlayerSpace.hasPie() && isAnswerCorrect) {
			
			playerDAO.givePlayerPiePiece(currentPlayerSpace.getSpaceId(), currentGame);
							
		}
		
		chosenCenterSpaceCategory = "false";
		categoryChoiceId = null;
		
		gameDAO.setActivePlayer(currentGame, isAnswerCorrect);
		
		return "redirect:/gameboard/" + currentGame.getGameCode();
	}
		
}
