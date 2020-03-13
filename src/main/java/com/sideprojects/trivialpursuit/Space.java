package com.sideprojects.trivialpursuit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Space {

		private int id;
		private Map<Integer, List<Integer>> reachableSpaces = new HashMap<Integer, List<Integer>>();		
	
		public int getId() {
			return id;
		}

		public void setId(int spaceId) {
			this.id = spaceId;
		}

		public Map<Integer, List<Integer>> getReachableSpaces() {
			return reachableSpaces;
		}

		public void setReachableSpaces(Map<Integer, List<Integer>> reachableSpaces) {
			this.reachableSpaces = reachableSpaces;
		}

		public Space(int spaceId) {
			this.id = spaceId;
			this.reachableSpaces = setAllReachableSpaces(spaceId);
		}
		
		private Map<Integer, List<Integer>> setAllReachableSpaces(int spaceId) {
			
			Map<Integer, List<Integer>> output = new HashMap<Integer, List<Integer>>();
			
			for (int i = 1; i <= 6; i++) {
				output.put(i, reachableSpaces(spaceId, i));
			}
			
			return output;
		}
		
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
