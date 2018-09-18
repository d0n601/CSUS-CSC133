package com.mycompany.a1;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;

public class SpaceStation extends FixedGameObject {

	private boolean on;
	private int blinkRate;
	
	public SpaceStation() {
	    Random randy = new Random();
	    blinkRate = randy.nextInt(4); // Blink rate between 0 and 4
		this.setColor(ColorUtil.WHITE);
		this.on = true;
	}
	
	
	/**
	 * Returns the blink rate of the space station.
	 * 
	 * @return blinkRate
	 */
	public int getBlinkRate() {
		return this.blinkRate;
	}
	
	
	
	/**
	 * Toggle on and off.
	 * 
	 */
	public void toggleOn() {
		this.on = !this.on;
	}
	
	
	/**
	 * Returns true if the space station is blinking on.
	 * 
	 * @return
	 */
	public boolean isOn() {
		return this.on;
	}
	
	
	/**
	 * Returns a string representation of the Space Station
	 * 
	 *  @return s
	 */
	public String toString() {
		 
		String s = "Station: loc="+this.getLocation().get(0)+","+this.getLocation().get(1)+
				" color=["+ColorUtil.red(this.getColor())+", "+ColorUtil.green(this.getColor())+", "+ColorUtil.blue(this.getColor())+"]"
						+ " rate="+this.blinkRate;
		return s;
	}
}
