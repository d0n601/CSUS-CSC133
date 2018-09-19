package com.mycompany.a1;

import java.util.Vector;
import java.util.Random;


public abstract class GameObject {

	private int color;
	private Vector<Double> position;
	
	public static final int WORLD_WIDTH  = 1024;
	public static final int WORLD_HEIGHT = 768;
	
	
	/**
	 * Constructs a game object, setting its position in the world.
	 * 
	 */
	public GameObject() {
	    Random randy = new Random();
		this.position = new Vector<>();
		this.position.setSize(2);
		this.position.set(0,  randy.nextDouble() * WORLD_WIDTH); // Random x value between
		this.position.set(1,  randy.nextDouble() * WORLD_HEIGHT); // Random y value between 

	}
	
	
	
	/**
	 * Returns the color of the GameObject.
	 * 
	 * @return color
	 */
	public int getColor( ) {
		return this.color;
	}
	
	
	
	/**
	 * Sets the color of the GameObject
	 * 
	 * @param newColor
	 */
	public void setColor(int newColor) {
		this.color = newColor;
	}
	
	
	
	/**
	 * Sets the location of the GameObject
	 * 
	 * @param newX
	 * @param newY
	 */
	public void setLocation(double newX, double newY) {
		this.position.set(0, newX);
		this.position.set(1, newY);
	}
	
	
	
	/**
	 * Returns the location of the GameObject
	 * 
	 * @return Vector<Double>
	 */
	public Vector<Double> getLocation() {
		return this.position;
	}
	
	
}
