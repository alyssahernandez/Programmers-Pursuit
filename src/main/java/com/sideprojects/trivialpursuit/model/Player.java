package com.sideprojects.trivialpursuit.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player 
{ 
	private Integer playerId;
	private String name;
	private Long color;
	private Space location;
	private boolean pie1;
	private boolean pie2;
	private boolean pie3;
	private boolean pie4;
	private boolean pie5;
	private boolean pie6;
	private boolean allPies;
	private Integer diceRoll;

	// Getters & Setters:
	public Integer getPlayerId() { return playerId; }
	public void setPlayerId(Integer playerId) { this.playerId = playerId; }
		
	public String getName() {return name; }
	public void setName(String name) { this.name = name; }
	
	public Long getColor() { return color; }
	public void setColor(Long color) { this.color = color; }
	
	public Space getLocation() { return location;}
	public void setLocation(Space location) {this.location = location; }
	
	public int getDiceRoll() { return diceRoll; } 
	public void setDiceRoll(Integer diceRoll) { this.diceRoll = diceRoll; } 
	
	public boolean isPie1() { return pie1;}
	public void setPie1(boolean pie1) { this.pie1 = pie1;}
	
	public boolean isPie2() { return pie2;}
	public void setPie2(boolean pie2) { this.pie2 = pie2;}
	
	public boolean isPie3() { return pie3;}
	public void setPie3(boolean pie3) { this.pie3 = pie3;}
	
	public boolean isPie4() { return pie4;}
	public void setPie4(boolean pie4) { this.pie4 = pie4;}
	
	public boolean isPie5() { return pie5;}
	public void setPie5(boolean pie5) { this.pie5 = pie5;}
	
	public boolean isPie6() { return pie6;}
	public void setPie6(boolean pie6) { this.pie6 = pie6;}
	
	public boolean getAllPies() { return isPie1() && isPie2() && isPie3() && isPie4() && isPie5() && isPie6(); }
	
	// Non-getter/setter methods:
	
	public List<Space> getReachableSpaces(Gameboard gameboard) // could also pass in a Game object and call game.getGameboard() within. 
	{
		List<Space> availableSpaces = new ArrayList<>();
		List<Integer> spaceIds = getLocation().getReachableSpaces(getDiceRoll()); 
		
		for (Integer id : spaceIds)
			availableSpaces.add(gameboard.getSpaces().get(id));
		
		return availableSpaces;
	}
	
	// equals used in a JDBC method  & will likely be used elsewhere as we get into Beta - Brooks
	@Override
	public boolean equals(Object obj) {
		if ((obj == null) || (!(obj instanceof Player)))
			return false;
		if (super.equals(obj))
			return true;
		Player p = (Player) obj;
		return this.getPlayerId() == p.getPlayerId();
	}
	@Override
	public int hashCode() {
		return this.getPlayerId().hashCode();
	}

}
