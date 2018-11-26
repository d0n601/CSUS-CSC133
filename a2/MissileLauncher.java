package com.mycompany.a2;


public class MissileLauncher extends MovableGameObject{
	

	MissileLauncher(int x, int y) {
		super(x, y);
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
	 * @return s
	 */
	public String toString() {
		return "Missile Launcher dir = " + this.getDirection();
	}
	

}
