package com.mycompany.a3;


public abstract class Ship extends MovableGameObject {

	private int worldWidth;
	private int worldHeight;
	private int missileCount;
	
	/**
	 * Create new instance of a Missile, passing in
	 * x as game world width, and y as game world height.
	 * 
	 * @param x
	 * @param y
	 */
	public Ship(int x, int y) {
		super(x, y);
		this.worldWidth = x;
		this.worldHeight = y;
	}
	
	/**
	 * Move the Player Ship, and it's missile launcher.
	 * 
	 */
	public void move(int elapsedTime) {
		super.move(elapsedTime);
		this.getMissileLauncher().setLocation(this.getLocation().get(0),this.getLocation().get(1));
	}
	
	
	
	/**
	 * Get reference to Ship's MissileLauncher.
	 * 
	 * @return MissileLauncher
	 */
	public abstract MissileLauncher getMissileLauncher();
	
	

	
	/**
	 * Fire a missile from the player's ship.
	 * 
	 * @return Missile
	 */
	public Missile fireMissile() {
		
		// If there are missiles to fire
		if(this.missileCount > 0) {
		
			Missile newMissile = new Missile(this.worldWidth, this.worldHeight); // Create a new missile.
			newMissile.setLocation(this.getLocation().get(0)-5, this.getLocation().get(1)-100);
			newMissile.setOwner(this);
			newMissile.setSpeed(this.getSpeed() + 10); // Set speed 10 clicks faster than ship's.
			newMissile.setDirection(this.getMissileLauncher().getDirection()); // Missile's direction set to launcher's.
			
			this.missileCount --; // Reduce missile count.
						
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
	 * Set the number of missiles a ship has.
	 * 
	 * @param newMissileCount
	 */
	public void setMissileCount(int newMissileCount) {
		this.missileCount = newMissileCount;
	}
	
	
}
