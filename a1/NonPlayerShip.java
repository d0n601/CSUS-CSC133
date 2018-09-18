package com.mycompany.a1;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;

public class NonPlayerShip extends MovableGameObject {

	private int size;
	private int missileCount;
	private MissileLauncher missileLauncher;
	
	private static final int MISSILE_COUNT = 2;
	
	
	/**
	 * Constructs a Non-Player Ship, creating a
	 * missile launcher, initializing the size at either 
	 * 10 or 20, and setting the color to black.
	 * 
	 */
	public NonPlayerShip() {
		Random randy = new Random();
		this.missileCount = MISSILE_COUNT; // Set number of missiles NPS starts with.
		this.size = (randy.nextInt(2) + 1) * 10; // Random integer, either 10 or 20
		this.missileLauncher = new MissileLauncher(); // Create a MissileLauncher for this NPS
		this.missileLauncher.setDirection(this.getDirection()); // Set the MissileLauncher to NPS heading.
		this.setColor(ColorUtil.BLACK); // Set the Color of NPS to Black.
		
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
	 * Move the Non-Player Ship, and it's missile launcher.
	 * 
	 */
	public void move() {
		
		super.move(); // Move the NPS
		
		// Set the NPS's MissileLauncher to its new location.
		this.missileLauncher.setLocation(this.getLocation().get(0),this.getLocation().get(1));
	}
	
	
	
	/**
	 * Fires a missile, and return the Missile object.
	 * 
	 * @return Missile
	 */
	public Missile fireMissile() {
		
		// If there are missiles to fire
		if(this.missileCount > 0) {
		
			Missile newMissile = new Missile(); // Create a new missile.
			newMissile.setOwner(this); // Set the owner of the missile to this NPS
			newMissile.setLocation(this.getLocation().get(0), this.getLocation().get(1)); // Set Missile Location to this NPS's.
			newMissile.setSpeed(this.getSpeed() + 2); // Set speed 2 clicks faster than NPS's.
			newMissile.setDirection(this.missileLauncher.getDirection()); // Missile's direction set to launcher's.
			
			this.missileCount --; // Reduce missile count of NPS.
			
			System.out.println("Non-Player Ship fired missile."); // Announce Action.
			
			return newMissile; // Return Missile.
		}
		
		// There are no missiles to fire.
		else {
			System.out.println("Cannot execute ‘fire missile’ – no missiles left!");
			return null;
		}
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
	 * Returns a string representation of the Non-Player Ship
	 * 
	 *  @return s
	 */
	public String toString() {
		 
		String s = "Non-Player Ship: loc="+this.getLocation().get(0)+","+this.getLocation().get(1)+
				" color=["+ColorUtil.red(this.getColor())+", "+ColorUtil.green(this.getColor())+", "+ColorUtil.blue(this.getColor())+"]"
						+ " speed="+this.getSpeed()+" dir="+this.getDirection()+" size="+this.getSize();
		return s;
	}
	
}
