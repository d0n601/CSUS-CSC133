package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class PlayerShip extends Ship implements ISteerable {

	private MissileLauncherSteerable missileLauncher;	
	
	public static final int NORTH = 0;
	public static final int MAX_MISSILES = 10;
	
	private static PlayerShip playerShip; // maintain a single global reference to the spooler
	
	
	
	/**
	 * Create an instance of the PlayerShip.
	 * 
	 */
	private PlayerShip(int x, int y)   {
		super(x, y);
		this.missileLauncher = new MissileLauncherSteerable(x, y);
		this.setLocation(x, y);
		this.setColor(ColorUtil.MAGENTA);
		this.setSpeed(0);
		this.setDirection(NORTH);
		this.setMissileCount(MAX_MISSILES);
		this.getMissileLauncher().setDirection(this.getDirection());
	}
	
	
	/**
	 * Provide access to the player ship, creating it if necessary
	 *  
	 * 
	 */
	public static PlayerShip getShip(int x, int y) {  
		if (playerShip == null) {
			playerShip =  new PlayerShip(x, y);
		}
		return playerShip;
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
