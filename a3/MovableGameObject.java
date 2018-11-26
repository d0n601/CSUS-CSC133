package com.mycompany.a3;

import java.util.Random;

public abstract class MovableGameObject extends GameObject implements IMoveable {

	private Random r;
	
	private int speed; 
	private int direction;
	
	private int worldWidth;
	private int worldHeight;
	
	public static final int MAX_SPEED = 10;
	public static final int POLAR_LIMIT = 359;

	
	/**
	 * Constructs a MovableGameObject, setting random values
	 * for speed and direction attributes.
	 
	 */
	public MovableGameObject(int x , int y) {
		super(x, y);
		this.worldWidth = x;
		this.worldHeight = y;
		this.r = new Random();
		this.speed = r.nextInt(MAX_SPEED); // Speed initialized between 0 and 10 at random.
		this.direction = r.nextInt(POLAR_LIMIT); // Direction initialized between 0 and 359 at random.
	}
	
	
	/**
	 * Move the game object.
	 */
	public void move(int elapsedTime) {
		
		// Polar to Cartesian Conversion.
		double r = this.getSpeed(); // Speed is equal to radius assuming it's /1 unit per tick.
		double theta = Math.toRadians(90 - this.getDirection()); // Rotate 90 so North is 0.
		
		int deltaX = (int)Math.round(r * Math.cos(theta)); // Movement in the X direction.
		int deltaY = (int)Math.round(r * Math.sin(theta)); // Movement in the Y direction.
		
		int newX = this.getLocation().get(0) + deltaX; // Total X.
		int newY = this.getLocation().get(1) - deltaY; // Total Y.
		
		if(newX > this.worldWidth) {
			newX = 0;
		}
		else if(newX < 0) {
			newX = this.worldWidth;
		}
		if(newY > this.worldHeight) {
			newY = 0;
		}
		else if(newY < 0 ) {
			newY = this.worldHeight;
		}
		
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
