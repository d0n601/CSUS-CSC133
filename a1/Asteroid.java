package com.mycompany.a1;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;

public class Asteroid extends MovableGameObject {

	private int size;
	
	
	/**
	 * Constructor for an Asteroid object, sets the size and color.
	 * 
	 */
	public Asteroid() {
		Random randy = new Random();
		this.size = randy.nextInt(31) + 6; // Random size between 6 and 30.
		this.setColor(ColorUtil.GRAY);
	}
	
	
	/**
	 * Return the size of this asteroid.
	 * 
	 * @return size
	 */
	public int getSize() {
		return this.size;
	}
	
	
	
	/**
	 * Returns a string representation of the Asteroid
	 * 
	 *  @return s
	 */
	public String toString() {
		 
		String s = "Asteroid: loc="+Math.round(this.getLocation().get(0)*10.0)/10.0+","+Math.round(this.getLocation().get(1)*10.0)/10.0+
				" color=["+ColorUtil.red(this.getColor())+", "+ColorUtil.green(this.getColor())+", "+ColorUtil.blue(this.getColor())+"]"
						+ " speed="+this.getSpeed()+" dir="+this.getDirection()+" size="+this.getSize();
		return s;
	}
	
	
	
}
