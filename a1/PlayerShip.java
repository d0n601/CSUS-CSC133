package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class PlayerShip extends Ship implements ISteerable {

	private MissileLauncherSteerable missileLauncher;	
	
	public static final int NORTH = 0;
	public static final int MAX_MISSILES = 10;
	
	
	/**
	 * Create an instance of the PlayerShip.
	 * 
	 */
	public PlayerShip() {
		this.missileLauncher = new MissileLauncherSteerable();
		this.setLocation(512, 384); // Position set to center of the map, as per specifications
		this.setColor(ColorUtil.MAGENTA); // Set player ship color.
		this.setSpeed(0);
		this.setDirection(NORTH); // Override direction being random, set to North.
		this.setMissileCount(MAX_MISSILES); // Maximum number.
		this.getMissileLauncher().setDirection(this.getDirection()); // Set the direction of the missile launcher.
	}
	
	
	/**
	 * Set the speed of the player's ship.
	 * 
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
	 */
	public void steer(int newDirection) {		
		this.setDirection((newDirection % 360 + 360) % 360);
		
	}
	

	
	/**
	 * Return the ship's missile launcher
	 * 
	 */
	public MissileLauncher getMissileLauncher() {
		return missileLauncher;
	}
	
	
	
	/**
	 * Returns a string representation of the Player Ship
	 * 
	 *  @return s
	 */
	public String toString() {
		 
		String s = "Player Ship: loc="+this.getLocation().get(0)+","+this.getLocation().get(1)+
				" color=["+ColorUtil.red(this.getColor())+", "+ColorUtil.green(this.getColor())+", "+ColorUtil.blue(this.getColor())+"]"
						+ " speed="+this.getSpeed()+" dir="+this.getDirection()+" missiles="+this.getMissileCount()
						+" "+ this.getMissileLauncher().toString();
		return s;
	}
}
