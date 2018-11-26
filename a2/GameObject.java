package com.mycompany.a2;

import java.util.Vector;


public abstract class GameObject {

	private int color;
	private Vector<Double> position;

	
	/**
	 * Constructs a game object, setting its position in the world.
	 * 
	 */
	public GameObject(double x, double y) {
		this.position = new Vector<>();
		this.position.setSize(2);
		this.position.set(0,  x); // Random x value between
		this.position.set(1,  y); // Random y value between 

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
