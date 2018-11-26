package com.mycompany.a2;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class SpaceStation extends FixedGameObject {

	private Random r;
	private boolean on;
	private int blinkRate;
	
	
	/*
	 * Construct new space station, set random blink rate 0-4 and
	 * set color, all space stations initially appear active (blink on).
	 * 
	 */
	public SpaceStation(double x, double y) {
		super(x, y);
	    this.r = new Random();
	    this.blinkRate = this.r.nextInt(4); // Blink rate between 0 and 4
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
	 * @return boolean
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
		 
		String s = "Station: loc="+Math.round(this.getLocation().get(0)*10.0)/10.0+","+Math.round(this.getLocation().get(0)*10.0)/10.0+
				" color=["+ColorUtil.red(this.getColor())+", "+ColorUtil.green(this.getColor())+", "+ColorUtil.blue(this.getColor())+"]"
						+ " rate="+this.blinkRate;
		return s;
	}
}
