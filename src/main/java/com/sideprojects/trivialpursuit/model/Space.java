package com.sideprojects.trivialpursuit.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Space {

	private Integer spaceId; 
	private Boolean hasPie;
	private Boolean isRollAgain;
	private Boolean isCenter;
	private Category category;
	// THIS IS A MAP OF 6 POSSIBLE DIE ROLLS AND THE INDEXES OF ALL REACHABLE SPACES BASED ON THAT ROLL
	public Map<Integer, List<Integer>> reachableSpaces = new HashMap<Integer, List<Integer>>();	
	
	// Gets & Sets
	public Integer getSpaceId() {return spaceId;}
	public void setSpaceId(Integer spaceId) {this.spaceId = spaceId;}
	
	public Category getCategory() {return category;}
	public void setCategory(Category category) {this.category = category;}
	
	public Boolean hasPie() { return hasPie;}
	public void setNode(Boolean hasPie) {this.hasPie = hasPie;}

	public Boolean isRollAgain() {return isRollAgain;}
	public void setRollAgain(Boolean isRollAgain) {this.isRollAgain = isRollAgain;}
	
	public Boolean isCenter() { return isCenter; } 
	public void setIsCenter(Boolean isCenter) { this.isCenter = isCenter; }

	public List<Integer> getReachableSpaces(int diceRoll) { return getReachableSpaces().get(diceRoll); }
	public Map<Integer, List<Integer>> getReachableSpaces() { return reachableSpaces;}
	public void setReachableSpaces(Map<Integer, List<Integer>> reachableSpaces) {this.reachableSpaces = reachableSpaces;}
	
	//CTORs:
	public Space () {}
	
	public Space(int spaceId) {
		this.spaceId = spaceId;
		this.reachableSpaces = setAllReachableSpaces(spaceId);
	}
	
	// Methods:
	
	// THIS SETS *ALL* REACHABLE SPACES BASED ON AN ID
	private Map<Integer, List<Integer>> setAllReachableSpaces(int spaceId) {
		
		Map<Integer, List<Integer>> output = new HashMap<Integer, List<Integer>>();
		
		for (int i = 1; i <= 6; i++) {
			output.put(i, reachableSpaces(spaceId, i));
		}
		
		return output;
	}
	
	// THIS GETS REACHABLE SPACES AT A GIVEN DISTANCE; RECURSIVE, WORKS FOR >2 SPACES AWAY
	// RECURSION STARTS HERE BECAUSE YOU NEED TO KNOW TWO SPACES PREVIOUS BEFORE THIS IS CONSISTENT
	private List<Integer> reachableSpaces(int spaceId, int distance) {
		
		if (distance == 1) {
			return adjascentSpaces(spaceId);
		} else if (distance ==2) {
			return secondarySpaces(spaceId);
		} else {
			List<Integer> output = new ArrayList<Integer>();
			List<Integer> previousSpaces = reachableSpaces(spaceId, distance - 1);
			List<Integer> previousSpaces2x = reachableSpaces(spaceId, distance - 2);
			
			for (Integer space : previousSpaces) {
				
				List<Integer> candidates = adjascentSpaces(space);
				
				for (Integer candidate : candidates) {
					if (!previousSpaces.contains(candidate) && !previousSpaces2x.contains(candidate)) {
						output.add(candidate);
					}
				}
			}	
			return output;
		}		
	}
	
	// THIS GETS ADJASCENT SPACES
	private List<Integer> adjascentSpaces(int spaceId) {
		
		List<Integer> output = new ArrayList<Integer>();
		
		if (spaceId == 0) {
			// CENTER SPACE
			for (int i = 1; i <= 61; i += 12) {
				output.add(i);
			}
		} else if ((spaceId - 6) % 12 == 0) {
			// NODE SPACES
			output.add(spaceId - 1);
			output.add(spaceId + 1);
			if (spaceId == 6) {
				output.add(72);
			} else {					
				output.add(spaceId - 6);
			}
		} else if (spaceId % 12 == 0) {
			// 'L' ENDS
			output.add(spaceId - 1);
			if (spaceId == 72) {
				output.add(6);
			} else {
				output.add(spaceId + 6);
			}
		} else if ((spaceId - 1) % 12 == 0) {
			// 'L' STARTS
			output.add(spaceId + 1);
			output.add(0);
		} else {
			// SPOKE SPACES (ALL OTHERS)
			output.add(spaceId - 1);
			output.add(spaceId + 1);
		}
		
		return output;
	}
	
	// THIS GETS SPACES AT A DISTANCE OF 2
	private List<Integer> secondarySpaces(int spaceId) {
		
		List<Integer> adjascentSpaces = adjascentSpaces(spaceId);
		List<Integer> secondarySpaces = new ArrayList<Integer>();			
		
		for (Integer space : adjascentSpaces) {
			
			List<Integer> candidates = adjascentSpaces(space);
			
			for (Integer candidate : candidates) {
				if (candidate != spaceId) {
					secondarySpaces.add(candidate);
				}
			}
		}
		return secondarySpaces;
	}
}
