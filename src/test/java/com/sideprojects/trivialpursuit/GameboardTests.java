package com.sideprojects.trivialpursuit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.sideprojects.trivialpursuit.model.Gameboard;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GameboardTests {

	@Test
	public void generate_spaces() {
		
		List<Integer> expected4row6 = new ArrayList<Integer>();
		expected4row6.add(14);
		expected4row6.add(26);
		expected4row6.add(38);
		expected4row6.add(50);
		expected4row6.add(62);
		expected4row6.add(10);
		expected4row6.add(69);
		
		Gameboard gameboard = new Gameboard();		
		int gameboardSize = gameboard.getSpaces().size();
				
		assertEquals(73, gameboardSize);
		assertEquals(0, gameboard.getSpaces().get(0).getId());
		assertEquals(35, gameboard.getSpaces().get(35).getId());
		assertEquals(expected4row6, gameboard.getSpaces().get(4).getReachableSpaces().get(6));
	}

}
