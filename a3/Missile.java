package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Missile extends MovableGameObject {

	private Ship owner;
	private int fuelLevel; 
	
	public static final int MAX_FUEL = 100; // Increased from 10
	
	
	/**
	 * Create an instance of Missile.
	 * 
	 */
	public Missile(int x, int y) {
		super(x,  y);
		super.setColor(ColorUtil.BLACK);		
		this.fuelLevel = MAX_FUEL;
	}

	
	/**
	 * Returns the owner of the missile.
	 * 
	 * @return GameObject
	 */
	public Ship getOwner() {
		return this.owner;
	}
	
	
	/**
	 * Set the owner of the missile.
	 * 
	 * @param Ship
	 */
	public void setOwner(Ship theOwner) {
		this.owner = theOwner;
	}
	
	
	/**
	 * Returns the current fuel level of the missile.
	 * 
	 * @return fuelLevel
	 */
	public int getFuelLevel() {
		return this.fuelLevel;
	}
	
	
	/**
	 * Sets the current fuel level of the missile.
	 * 
	 * @param fuelLevel
	 */
	public void setFuelLevel(int newFuelLevel) {
		this.fuelLevel = newFuelLevel;
	}
	
	
	
	/**
	 * 
	 * 
	 */
	public void draw(Graphics g, Point pCmpRelPrnt) {
		
		int newX = pCmpRelPrnt.getX() + this.getLocation().get(0);
		int newY = pCmpRelPrnt.getY() + this.getLocation().get(1);
		
		g.setColor(this.getColor());
		
		g.fillRect(newX, newY, 10, 30);
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
		 
		String s = owner+"'s Missile: loc="+Math.round(this.getLocation().get(0)*10.0)/10.0+","+Math.round(this.getLocation().get(1)*10.0)/10.0+
				" color=["+ColorUtil.red(this.getColor())+", "+ColorUtil.green(this.getColor())+", "+ColorUtil.blue(this.getColor())+"]"
						+ " speed="+this.getSpeed()+" dir="+this.getDirection()+" fuel="+this.getFuelLevel();
		return s;
	}

}
