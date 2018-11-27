package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Asteroid extends MovableGameObject implements ISelectable {

	private boolean selected;
	private Random r;	
	
	/**
	 * Constructor for an Asteroid object, sets the size and color.
	 * 
	 */
	public Asteroid(int x, int y) {
		super(x, y);
		this.r = new Random();
		this.setSize((this.r.nextInt(31) + 6)*10);
		this.setColor(ColorUtil.GRAY);
		this.setLocation(this.r.nextInt(x), this.r.nextInt(y));
		this.selected = false;
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
	
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		
		int newX = this.getLocation().get(0) + pCmpRelPrnt.getX();
		int newY = this.getLocation().get(1) + pCmpRelPrnt.getY();
		
		g.setColor(this.getColor());
		
		if(selected) {
			g.fillRect(newX, newY, this.getSize(), this.getSize());
		}
		else {
			g.drawRect(newX, newY, this.getSize(), this.getSize());
		}
		
	}

	@Override
	public Boolean contains(Point p) {
		
		// This object's sides.
		int l = this.getLocation().get(0);
		int r = this.getLocation().get(0) + this.getSize();
		int t = this.getLocation().get(1);
		int b = this.getLocation().get(1) - this.getSize();
	    
	    int px = p.getX(); 
		int py = p.getY(); 
		
		return (l <= px && r >= px && t >= py && b <= py);
		
	}

	@Override
	public void setSelected(Boolean newSelected) {
		this.selected = newSelected;
	}

	@Override
	public Boolean isSelected() {
		return this.selected;
	}
	

	
}
