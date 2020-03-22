package com.sideprojects.trivialpursuit.model;

import java.util.List;
import java.util.Random;

//AC: all categorys will have these getters to get the ID and the name wherever we want to use them
public class Category {
	private int categoryID;
	private String categoryName;
	private List<Question> questions;
	
	public Category() { }
	
	public int getCategoryID() { return categoryID; }
	public void setCategoryID(int categoryID) { this.categoryID = categoryID;}
	
	public String getCategoryName() { return categoryName;}
	public void setCategoryName(String categoryName)  { this.categoryName = categoryName;}
	
	public List<Question> getQuestionList() { return questions;}
	public void setQuestionList(List<Question> questions) { this.questions = questions; }
	
	public Question getNewQuestion()
	{ 	
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
	
	// TODO: Should probably create a "generateRandomNum" method in the couple of other classes that utilize a random integer, but actually makes sense here whereas it's arguable for the others.
	public int generateRandomNumber() 
	{
		int minQuestionIndex = 0;
		int maxQuestionIndex = questions.size() - 1;
		Random r = new Random();
		int index = r.nextInt((maxQuestionIndex - minQuestionIndex) + 1) + minQuestionIndex;
		return index;
	}
}
