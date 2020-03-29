package com.sideprojects.trivialpursuit.model;

import java.util.List;
import java.util.Random;

//AC: all categorys will have these getters to get the ID and the name wherever we want to use them
public class Category {
	private Integer categoryID;
	private String categoryName;
	private List<Question> questions;
	
	public Category() { }
	
	public Integer getCategoryID() { return categoryID; }
	public void setCategoryID(Integer categoryID) { this.categoryID = categoryID;}
	
	public String getCategoryName() { return categoryName;}
	public void setCategoryName(String categoryName)  { this.categoryName = categoryName;}
	
	public List<Question> getQuestionList() { return questions;}
	public void setQuestionList(List<Question> questions) { this.questions = questions; }
	
	public Question getNewQuestion()
	{ 	
		if (questions.equals(null)) { return null; }
		
		while (true)
		{
			int index = generateRandomNumber(); 
			Question question = null;
			
			if (!(questions.get(index).equals(null)))
			{
				question = questions.get(index);
				questions.set(index, null);
				return question;
			}
			else
				continue;
		}
	}
	
	public int generateRandomNumber() 
	{
		//TODO: null check on question list ("questions")
		int minQuestionIndex = 0;
		int maxQuestionIndex = questions.size() - 1;
		Random r = new Random();
		int index = r.nextInt((maxQuestionIndex - minQuestionIndex) + 1) + minQuestionIndex;
		return index;
	}
}
