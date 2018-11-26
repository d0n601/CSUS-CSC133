package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class SpaceStation extends FixedGameObject {

	private Random r;
	private int size;
	private boolean on;
	private int blinkRate;
	
	
	
	/*
	 * Construct new space station, set random blink rate and
	 * set color, all space stations initially appear active (blink on).
	 * 
	 */
	public SpaceStation(int x, int y) {
		super(x, y);
	    this.r = new Random();
	    this.size = 75;
	    this.blinkRate = 20 + this.r.nextInt(80);
		this.setColor(ColorUtil.LTGRAY);
		this.setLocation(this.r.nextInt(x), this.r.nextInt(y));
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
	 * Returns the size of the space station
	 * 
	 * @return size
	 */
	public int getSize() {
		return this.size;
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
	 * Draw the space station.
	 * 
	 */
	public void draw(Graphics g, Point pCmpRelPrnt) {
		
		int newX = pCmpRelPrnt.getX() + this.getLocation().get(0);
		int newY = pCmpRelPrnt.getY() + this.getLocation().get(1);
		
        g.setColor(this.getColor());
        
        if(this.on) {
            g.fillArc(newX, newY, this.size, this.size, 0, 360);
        }
        else {
            g.drawArc(newX, newY, this.size, this.size, 0, 360);
        }

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
