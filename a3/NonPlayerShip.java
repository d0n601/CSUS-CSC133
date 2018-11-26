package com.mycompany.a3;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class NonPlayerShip extends Ship {

	private Random r;
	private int size;
	private MissileLauncher missileLauncher;	
	
	private static final int MAX_MISSILES = 2;
	
	
	/**
	 * Constructs a Non-Player Ship, creating a
	 * missile launcher, initializing the size at either 
	 * 10 or 20, and setting the color to black.
	 * 
	 */
	public NonPlayerShip(int x, int y) {
		super(x, y);
		this.r = new Random();
		this.missileLauncher = new MissileLauncher(x, y);
		this.setMissileCount(MAX_MISSILES); // Set number of missiles NPS starts with.
		this.setLocation(this.r.nextInt(x), this.r.nextInt(y));
		this.size = (r.nextInt(2) + 1) * 10; // Random integer, either 10 or 20
		this.setColor(ColorUtil.BLACK); // Set the Color of NPS to Black.		
		this.getMissileLauncher().setDirection(this.getDirection()); // Set the direction of the missile launcher.
	}
	
	
	
	/**
	 * Return the size of this Non-Player Ship.
	 * 
	 * @return size
	 */
	public int getSize() {
		return this.size;
	}
	
	
	
	/**
	 * Return the ship's missile launcher
	 * 
	 * @return MissileLauncher
	 */
	public MissileLauncher getMissileLauncher() {
		return this.missileLauncher;
	}
		
	
	/**
	 * Draw the non-player's ship as an solid triangle.
	 * 
	 */
	public void draw(Graphics g, Point pCmpRelPrnt) {
		
		int newX = pCmpRelPrnt.getX() + this.getLocation().get(0);
		int newY = pCmpRelPrnt.getY() + this.getLocation().get(1);
	
        int[] Xcoord = { newX - 25, newX + 25, newX};
        int[] Ycoord = { newY - 25, newY - 25, (newY-75)};
		
        g.setColor(this.getColor());
        g.fillPolygon(Xcoord,Ycoord,3);

	}
	
	
	/**
	 * Returns a string representation of the Non-Player Ship
	 * 
	 *  @return s
	 */
	public String toString() {
		 
		String s = "Non-Player Ship: loc="+Math.round(this.getLocation().get(0)*10.0)/10.0+","+Math.round(this.getLocation().get(1)*10.0)/10.0+
				" color=["+ColorUtil.red(this.getColor())+", "+ColorUtil.green(this.getColor())+", "+ColorUtil.blue(this.getColor())+"]"
						+ " speed="+this.getSpeed()+" dir="+this.getDirection()+" size="+this.getSize();
		return s;
	}
	
}
