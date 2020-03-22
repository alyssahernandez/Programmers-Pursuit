package com.sideprojects.trivialpursuit.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Player implements Comparable<Player> { // Compares Players (for sort order) based on desired criteria. See "compareTo" below.
	private Long id;
	private String name;
	private Space location;
	private int diceRoll;
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	public Space getLocation() { return location;}
	public void setLocation(Space location) {this.location = location; }
	
	public String getName() {return name; }
	public void setName(String name) { this.name = name; }
	
	public int getDiceRoll() { return diceRoll; }
	public void setDiceRoll()
	{
		int minDiceRoll = 1;
		int maxDiceRoll = 6;
		Random r = new Random();
		diceRoll = r.nextInt((maxDiceRoll - minDiceRoll) + 1) + minDiceRoll;
	}

	// Comparing players based on dice roll to determine an initial order (accounting for ties occurs in Game.determinePlayerOrder()). Granted, this isn't the best use of Comparable by any stretch, but I'm lazy and don't want to write a sorting algorithm. 
	@Override
	public int compareTo(Player p) {
		if (this.getDiceRoll() > p.getDiceRoll())
			return -1;
		else if (this.getDiceRoll() < p.getDiceRoll())
			return 1;
		else 
			return 0;
	}
}
