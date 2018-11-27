package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class PlayerShip extends Ship implements ISteerable {

	private MissileLauncherSteerable missileLauncher;	
	
	private int size;
	
	public static final int NORTH = 0;
	public static final int MAX_MISSILES = 10;
		

	/**
	 * Create an instance of the PlayerShip.
	 * 
	 */
	public PlayerShip(int x, int y) {
		super(x, y);
		this.setSpeed(0);
		this.size = 25;
		this.setLocation(x/2, y/2);
		this.setColor(ColorUtil.MAGENTA);
		this.setDirection(NORTH);
		this.missileLauncher = new MissileLauncherSteerable(x, y);
		this.setMissileCount(MAX_MISSILES);
		this.getMissileLauncher().setDirection(this.getDirection());
		this.getMissileLauncher().setLocation(this.getLocation().get(0),this.getLocation().get(1));
	}
	
	
	/**
	 * Set the speed of the player's ship.
	 * 
	 * @param newSpeed
	 */
	public void setSpeed(int newSpeed) {
		if(newSpeed > 10) {
			System.out.println("Player Ship is at maximum speed.");
		}
		else if(newSpeed < 0) {
			System.out.println("Ship is already stopped.");
		}
		else {
			super.setSpeed(newSpeed);
		}
	}
	
	
	/**
	 * Steer the player's ship.
	 * 
	 * @param newDirection
	 */
	public void steer(int newDirection) {		
		this.setDirection((newDirection % 360 + 360) % 360);
		
	}
	
	
	/**
	 * Return the ship's missile launcher
	 * 
	 * @return MissileLauncher
	 */
	public MissileLauncher getMissileLauncher() {
		return missileLauncher;
	}
	
	
	
	/**
	 * Draw the player's ship as an unfilled triangle.
	 * 
	 */
	public void draw(Graphics g, Point pCmpRelPrnt) {
		
		int newX = pCmpRelPrnt.getX() + this.getLocation().get(0);
		int newY = pCmpRelPrnt.getY() + this.getLocation().get(1);
	
        int[] Xcoord = { newX - this.size, newX + this.size, newX};
        int[] Ycoord = { newY - this.size, newY - this.size, (newY-this.size*3)};
		
        g.setColor(this.getColor());
        g.drawPolygon(Xcoord,Ycoord,3);

	}
	
		
	
	/**
	 * Returns a string representation of the Player Ship
	 * 
	 *  @return s
	 */
	public String toString() {
		 
		String s = "Player Ship: loc="+Math.round(this.getLocation().get(0)*10.0)/10.0+","+Math.round(this.getLocation().get(1)*10.0)/10.0+
				" color=["+ColorUtil.red(this.getColor())+", "+ColorUtil.green(this.getColor())+", "+ColorUtil.blue(this.getColor())+"]"
						+ " speed="+this.getSpeed()+" dir="+this.getDirection()+" missiles="+this.getMissileCount()
						+" "+ this.getMissileLauncher().toString();
		return s;
	}

}
