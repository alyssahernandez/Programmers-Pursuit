package com.sideprojects.trivialpursuit.model;

import java.util.List;

public class Question {
	private Integer questionID;
	private Integer categoryID;
	private String question;
	private String answer;
	private List<String> possibleAnswers;
	
	public Integer getQuestionID() {return questionID;}
	public void setQuestionID(Integer questionID) { this.questionID = questionID;}
	
	public Integer getCategoryID() {return categoryID;}
	public void setCategoryID(Integer categoryID) { this.categoryID = categoryID;}
	
	public String getQuestion() { return question; }
	public void setQuestion(String question) { this.question = question;}
	
	public String getAnswer() { return answer;}
	public void setAnswer(String answer) { this.answer = answer;}
	
	public List<String> getPossibleAnswers() { return possibleAnswers; }
	public void setPossibleAnswers(List<String> possibleAnswers) { this.possibleAnswers = possibleAnswers; }
	
}
