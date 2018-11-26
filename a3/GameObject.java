package com.mycompany.a3;

import java.util.Vector;

public abstract class GameObject implements IDrawable, ICollider {

	private int size;
	private int color;
	private Vector<Integer> position;

	
	/**
	 * Constructs a game object, setting its position in the world.
	 * 
	 */
	public GameObject(int x, int y) {
		this.position = new Vector<>();
		this.position.setSize(2);
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
	 * Returns the size of the game object (radius if circle or side length of square/triangle).
	 * 
	 * @return size
	 */
	public int getSize() {
		return this.size;
	}
	
	
	/**
	 * Set new size of the object.
	 * @param newSize
	 */
	public void setSize(int newSize) {
		this.size = newSize;
	}
	
	/**
	 * Sets the location of the GameObject
	 * 
	 * @param newX
	 * @param newY
	 */
	public void setLocation(int newX, int newY) {
		this.position.set(0, newX);
		this.position.set(1, newY);
	}
	
	
	/**
	 * Returns the location of the GameObject
	 * 
	 * @return Vector<Integer>
	 */
	public Vector<Integer> getLocation() {
		return this.position;
	}
	
	
	// Use bounding squares to determine whether this object has collided with another
	public boolean collidesWith(ICollider obj) {
		
		// Some sides.
		int t1, t2, l1, l2, b1, b2, r1, r2;
		
		// This object's sides.
		l1 = this.getLocation().get(0);
		r1 = this.getLocation().get(0) + this.getSize();
		t1 = this.getLocation().get(1);
		b1 = this.getLocation().get(1) - this.getSize();
		
		// Other game object's sites.
		l2 = ((GameObject) obj).getLocation().get(0);
		r2 = ((GameObject) obj).getLocation().get(0) + ((GameObject) obj).getSize();
		t2 = ((GameObject) obj).getLocation().get(1);
		b2 = ((GameObject) obj).getLocation().get(1) - ((GameObject) obj).getSize();
		
		return (r1 >= l2 && l1 <= r2) && (t2 >= b1 && t1 >= b2); // Overlap = true	
		
	}


	public void handleCollision(ICollider otherObject) {
		
	}
	
	
}
