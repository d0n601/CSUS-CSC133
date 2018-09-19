package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class Missile extends MovableGameObject {

	private GameObject owner;
	private int fuelLevel; 
	
	public static final int MAX_FUEL = 10;
	
	
	/**
	 * Create an instance of Missile.
	 * 
	 */
	public Missile() {
		this.fuelLevel = MAX_FUEL;
		super.setColor(ColorUtil.MAGENTA);		
	}

	
	/**
	 * Returns the owner of the missile.
	 * 
	 * 
	 */
	public GameObject getOwner() {
		return this.owner;
	}
	
	
	/**
	 * Set the owner of the missile.
	 * 
	 */
	public void setOwner(GameObject theOwner) {
		this.owner = theOwner;
	}
	
	
	/**
	 * Returns the current fuel level of the missile.
	 * 
	 */
	public int getFuelLevel() {
		return this.fuelLevel;
	}
	
	
	/**
	 * Sets the current fuel level of the missile.
	 * 
	 */
	public void setFuelLevel(int newFuelLevel) {
		this.fuelLevel = newFuelLevel;
	}
	
	
	
	/**
	 * Returns a string representation of the Missile
	 * 
	 *  @return s
	 */
	public String toString() {
		
		String owner; // String representation of what fired the missile.
		
		if (this.getOwner() instanceof PlayerShip) {
			owner = "PS";
		}
		else {
			owner = "NPS";
		}
		 
		String s = owner+"'s Missile: loc="+this.getLocation().get(0)+","+this.getLocation().get(1)+
				" color=["+ColorUtil.red(this.getColor())+", "+ColorUtil.green(this.getColor())+", "+ColorUtil.blue(this.getColor())+"]"
						+ " speed="+this.getSpeed()+" dir="+this.getDirection()+" fuel="+this.getFuelLevel();
		return s;
	}
	
}
