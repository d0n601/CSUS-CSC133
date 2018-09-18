package com.mycompany.a1;

import java.util.Random;

public abstract class MovableGameObject extends GameObject implements IMoveable {

	
	private int speed; 
	private int direction;
	
	public static final int MAX_SPEED = 10;
	public static final int POLAR_LIMIT = 359;


	
	/**
	 * Constructs a MovableGameObject, setting random values
	 * for speed and direction attributes.
	 
	 */
	public MovableGameObject() {
		Random randy = new Random();
		this.speed = randy.nextInt(MAX_SPEED); // Speed initialized between 0 and 10 at random.
		this.direction = randy.nextInt(POLAR_LIMIT); // Direction initialized between 0 and 359 at random.
	}
	
	
	/**
	 * Move the game object.
	 */
	public void move() {
		
		// Polar to Cartesian Conversion.
		double r = this.getSpeed(); // Speed is equal to radius assuming it's /1 unit per tick.
		double theta = Math.toRadians(90 - this.getDirection()); // Rotate 90 so North is 0.
		
		double deltaX = r * Math.cos(theta); // Movement in the X direction.
		double deltaY = r * Math.sin(theta); // Movement in the Y direction.
		
		double newX = this.getLocation().get(0) + deltaX; // Total X.
		double newY = this.getLocation().get(1) + deltaY; // Total Y.

		this.setLocation(newX, newY); // Update Game Object's  location.
		
	}
	
	
	/**
	 * Returns current speed.
	 * 
	 * @return speed
	 */
	public int getSpeed() {
		return this.speed;
	}
	
	
	/**
	 * Sets the current speed.
	 * 
	 * @param newSpeed
	 */
	public void setSpeed(int newSpeed) {
		this.speed = newSpeed;
	}
	
	
	/**
	 * Returns the current direction (compass heading).
	 * 
	 * @return direction
	 */
	public int getDirection() {
		return this.direction;
	}
	
	
	/**
	 * Sets the current direction.
	 * 
	 * @param newDirection
	 */
	public void setDirection(int newDirection) {
		this.direction = newDirection;
	}
	
	
}
