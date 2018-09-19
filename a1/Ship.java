package com.mycompany.a1;


public abstract class Ship extends MovableGameObject {

	private int missileCount;
		
	/**
	 * Move the Player Ship, and it's missile launcher.
	 * 
	 */
	public void move() {
		super.move();
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
		
			Missile newMissile = new Missile(); // Create a new missile.
			
			newMissile.setOwner(this);
			newMissile.setLocation(this.getLocation().get(0), this.getLocation().get(1));
			newMissile.setSpeed(this.getSpeed() + 2); // Set speed 2 clicks faster than ship's.
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
