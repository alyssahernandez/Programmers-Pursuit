package com.sideprojects.trivialpursuit.model;

//AC: all questions will have these getters to get the ID, the String question, and the String answer wherever you want them
public class Question {
	private int questionID;
	private int categoryID;
	private String question;
	private String answer;
	
	public Question() {}
	
	public int getQuestionID() {return questionID;}
	public void setQuestionID(int questionID) {this.questionID = questionID;}
	
	public int getCategoryID() {return categoryID;}
	public void setCategoryID(int categoryID) {this.categoryID = categoryID;}
	
	public String getQuestion() { return question; }
	public void setQuestion(String question) {this.question = question;}
	
	public String getAnswer() {return answer;}
	public void setAnswer(String answer) {this.answer = answer;}

}
