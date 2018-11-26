package com.mycompany.a2;

public class MissileLauncherSteerable extends MissileLauncher implements ISteerable {
	
	
	MissileLauncherSteerable(int x, int y) {
		super(x, y);
	}
	
	
	/**
	 * Steer the Missile Launcher.
	 * 
	 * @param newDirection
	 */
	public void steer(int newDirection) {		
		this.setDirection((newDirection % 360 + 360) % 360);
		
	}
}
