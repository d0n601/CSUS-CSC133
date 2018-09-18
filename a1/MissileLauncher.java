package com.mycompany.a1;


public class MissileLauncher extends MovableGameObject implements ISteerable {
	
	private int direction;
		
	public MissileLauncher() {
		
	}
	
	
	/**
	 * Steer the Missile Launcher.
	 * 
	 */
	public void steer(int newDirection) {		
		this.direction = ((newDirection % 360 + 360) % 360);
		
	}
	
	/**
	 * Override method for move
	 * 
	 */
	public void move() {
		// Override move so we don't move, then get location set by owner.
	}
	
	/**
	 * Return a string with the direction.
	 * 
	 */
	public String toString() {
		return "Missile Launcher dir = " + this.getDirection();
	}
	

}
