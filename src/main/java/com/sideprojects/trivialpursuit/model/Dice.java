package com.sideprojects.trivialpursuit.model;

import java.util.Random;

public class Dice
{
	private static int diceRoll;
	
	public static int getDiceRoll()
	{
        int minDiceRoll = 1;
        int maxDiceRoll = 6;
        Random r = new Random();
        diceRoll = r.nextInt((maxDiceRoll - minDiceRoll) + 1) + minDiceRoll;
        return diceRoll;
	}
}