package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class PlayerShip extends MovableGameObject implements ISteerable {

	private int direction;
	private int missileCount;
	private MissileLauncher missileLauncher;
	
	private static final int NORTH = 0;
	private static final int MISSILE_COUNT = 10;
	
	
	/**
	 * Create an instance of the PlayerShip.
	 * 
	 */
	public PlayerShip() {
		this.setLocation(512, 384); // Position set to center of the map, as per specifications
		this.setColor(ColorUtil.MAGENTA); // Set player ship color.
		this.setSpeed(0);
		this.direction = NORTH; // Override direction being random, set to North.
		this.missileCount = MISSILE_COUNT; // Maximum number.
		this.missileLauncher = new MissileLauncher(); // Create the Player Ship's missile launcher.
		this.missileLauncher.setLocation(512, 384);  // Set the Ship's missile launcher location to match the ship.
		this.missileLauncher.steer(this.getDirection()); // Set the Ship's missile launcher direction to match.
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
		this.direction = ((newDirection % 360 + 360) % 360);
		
	}
	
	
	/**
	 * Move the Player Ship, and it's missile launcher.
	 * 
	 */
	public void move() {
		super.move();
		this.missileLauncher.setLocation(this.getLocation().get(0),this.getLocation().get(1));
	}
	
	
	
	/**
	 * Get reference to Ship's MissileLauncher.
	 * 
	 */
	public MissileLauncher getMissileLauncher() {
		return this.missileLauncher;
	}
	
	

	
	/**
	 * Fire a missile from the player's ship.
	 * 
	 */
	public Missile fireMissile() {
		
		// If there are missiles to fire
		if(this.missileCount > 0) {
		
			Missile newMissile = new Missile(); // Create a new missile.
			newMissile.setOwner(this);
			newMissile.setLocation(this.getLocation().get(0), this.getLocation().get(1));
			newMissile.setSpeed(this.getSpeed() + 2); // Set speed 2 clicks faster than ship's.
			newMissile.setDirection(this.missileLauncher.getDirection()); // Missile's direction set to launcher's.
			
			this.missileCount --; // Reduce missile count.
			
			System.out.println("Player Ship fired missile.");
			
			return newMissile;

		}
	
		System.out.println("Cannot execute ‘fire missile’ – no missiles left!");
		
		return null;
		
	}
	
	
	
	
	/**
	 * Returns the number of missiles a ship has.
	 * 
	 * @return missileCount
	 */
	public int getMissileCount() {
		return this.missileCount;
	}
	
	
	
	
	/**
	 * Reset the ship's missile count.
	 * 
	 */
	public void reload() {
		this.missileCount = 10;
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
						+" "+ this.missileLauncher.toString();
		return s;
	}
}
