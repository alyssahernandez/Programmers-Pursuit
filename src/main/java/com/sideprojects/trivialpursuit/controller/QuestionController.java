package com.sideprojects.trivialpursuit.controller;

import java.util.List;

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
import com.sideprojects.trivialpursuit.model.Category;
import com.sideprojects.trivialpursuit.model.Dice;
import com.sideprojects.trivialpursuit.model.Game;
import com.sideprojects.trivialpursuit.model.GameDAO;
import com.sideprojects.trivialpursuit.model.Player;
import com.sideprojects.trivialpursuit.model.PlayerDAO;
import com.sideprojects.trivialpursuit.model.Question;
import com.sideprojects.trivialpursuit.model.QuestionDAO;
import com.sideprojects.trivialpursuit.model.Space;
import com.sideprojects.trivialpursuit.model.User;
import com.sideprojects.trivialpursuit.model.UserDAO;

@Controller
public class QuestionController {
    
    @Autowired
    private GameDAO gameDAO;
    
    @Autowired
    private QuestionDAO questionDAO;
    
    @Autowired
    private PlayerDAO playerDAO;
    
    @Autowired
    private UserDAO userDAO;

	@RequestMapping(path="/question/{gameCode}", method=RequestMethod.GET)
	public String displayQuestion(
			ModelMap model,
			@PathVariable String gameCode,
			final HttpServletRequest req,
			RedirectAttributes flash) {

	    String userIdToken = (String) SessionUtils.get(req, "userIdToken");
	    User currentUser = userDAO.getUserByToken(userIdToken);
	    if (currentUser == null) return "redirect:/";
	    model.put("currentUser", currentUser);
		
		Game currentGame = gameDAO.getActiveGame(gameCode);
		model.put("currentGame", currentGame);
		
		Player currentPlayerTurn = gameDAO.getActivePlayer(currentGame);
		model.put("currentPlayerTurn", currentPlayerTurn);
		
		Space currentPlayerSpace = currentPlayerTurn.getLocation();
		model.put("currentPlayerSpace", currentPlayerSpace);
		
		boolean questionHUD = false;
		model.put("questionHUD", questionHUD);
				
		List<Category> gameCategories = currentGame.getUniqueCategories();
		model.put("gameCategories", gameCategories);

		if (currentGame.getActivePlayer().getIsAnsweringQuestion()) {
			
			Question question = questionDAO.getCurrentQuestion(currentGame);
			if (question == null) {
				gameDAO.setIsGameActive(gameCode, false);
				flash.addFlashAttribute("outOfQuestions", true);
				return "redirect:/gameboard/" + gameCode;
			}
			model.put("question", question);
			
			// TODO: this is currently printing the answers with array brackets around
			// the first and last answer. it has something to do with the way
			// the string list is being looped over in the jsp
			List<String> possibleAnswers = question.getPossibleAnswers();
			model.put("possibleAnswers", possibleAnswers);
			
		} else if (!currentPlayerSpace.isCenter() && !(currentGame.getActivePlayer().getIsAnsweringQuestion())) {
			
			//TODO: If question=null, end game (no questions for a category would be bad)
			Question question = questionDAO.getUnaskedQuestionByCategory(currentGame, currentPlayerSpace.getCategory().getCategoryId());
			if (question == null) {
				gameDAO.setIsGameActive(gameCode, false);
				flash.addFlashAttribute("outOfQuestions", true);
				return "redirect:/gameboard/" + gameCode;

			}
			
			model.put("question", question);
			
			List<String> possibleAnswers = question.getPossibleAnswers();
			model.put("possibleAnswers", possibleAnswers);
			
			gameDAO.setIsAnsweringQuestion(currentGame, true);		
			
		} else if (currentGame.getActivePlayer().getHasSelectedCategoryCenter()) {		
			
			Question question = questionDAO.getCurrentQuestion(currentGame);
			if (question == null) {
				gameDAO.setIsGameActive(gameCode, false);
				flash.addFlashAttribute("outOfQuestions", true);
				return "redirect:/gameboard/" + gameCode;
			}
			model.put("question", question);	
			
			List<String> possibleAnswers = question.getPossibleAnswers();
			model.put("possibleAnswers", possibleAnswers);
			
			gameDAO.setIsAnsweringQuestion(currentGame, true);
		}
		
		return "question";
	}
	
	@RequestMapping(path="/question/{gameCode}", method=RequestMethod.POST)
	public String submitQuestion(
			@PathVariable String gameCode,
			@RequestParam(name = "categoryChoiceId", required = false) Integer categoryChoiceId,
			@RequestParam(name = "chosenCenterSpaceCategory", required = false, defaultValue = "false") String chosenCenterSpaceCategory,
			@RequestParam(name = "answer", required = false) String answer,
			ModelMap model,
			final HttpServletRequest req) {
		
	    String userIdToken = (String) SessionUtils.get(req, "userIdToken");
	    User currentUser = userDAO.getUserByToken(userIdToken);
	    if (currentUser == null) return "redirect:/";
		
		Game currentGame = gameDAO.getActiveGame(gameCode);		
		Player currentPlayerTurn = gameDAO.getActivePlayer(currentGame);		
		Space currentPlayerSpace = currentPlayerTurn.getLocation();		
		
		if (currentPlayerSpace.isCenter() && categoryChoiceId != null && chosenCenterSpaceCategory.equals("true")) {
			
			gameDAO.setHasSelectedCategory(currentGame, true);
	
			//TODO: If question=null, end game (no questions for a category would be bad)
			questionDAO.getUnaskedQuestionByCategory(currentGame, categoryChoiceId);
				
			return "redirect:/question/" + currentGame.getGameCode();
		}
		
		if (answer != null) {
			
			Question currentQuestion = questionDAO.getCurrentQuestion(currentGame);
			boolean isAnswerCorrect = answer.equalsIgnoreCase(currentQuestion.getAnswer());
			
			questionDAO.setQuestionAsked(currentGame, currentQuestion);
			
			if (currentPlayerSpace.hasPie() && isAnswerCorrect) {			
				playerDAO.givePlayerPiePiece(currentPlayerSpace.getSpaceId(), currentGame);	
				
				if (currentPlayerSpace.getSpaceId() == 6) {
					currentPlayerTurn.setPie1(true);
				} else if (currentPlayerSpace.getSpaceId() == 18) {
					currentPlayerTurn.setPie2(true);
				} else if (currentPlayerSpace.getSpaceId() == 30) {
					currentPlayerTurn.setPie3(true);
				} else if (currentPlayerSpace.getSpaceId() == 42) {
					currentPlayerTurn.setPie4(true);
				} else if (currentPlayerSpace.getSpaceId() == 54) {
					currentPlayerTurn.setPie5(true);
				} else if (currentPlayerSpace.getSpaceId() == 66) {
					currentPlayerTurn.setPie6(true);
				}	
			}
			
			if (currentPlayerSpace.isCenter() && isAnswerCorrect && currentPlayerTurn.getAllPies()) {				
				gameDAO.setIsGameActive(currentGame.getGameCode(), false);
				currentGame.setActive(false);
				gameDAO.setEndGameStatus(currentGame);
			}  
			
			chosenCenterSpaceCategory = "false";
			categoryChoiceId = null;
			
			gameDAO.setActivePlayer(currentGame, isAnswerCorrect);
	        gameDAO.setHasSelectedCategory(currentGame, false);
	        gameDAO.setIsAnsweringQuestion(currentGame, false);
	        gameDAO.setActivePlayerDiceRoll(currentGame);
	        
			return "redirect:/gameboard/" + currentGame.getGameCode();      
		}		
		return "redirect:/question/" + currentGame.getGameCode();
	}
		
}