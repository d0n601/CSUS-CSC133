package com.mycompany.a1;

public class MissileLauncherSteerable extends MissileLauncher implements ISteerable {
	
	/**
	 * Steer the Missile Launcher.
	 * 
	 */
	public void steer(int newDirection) {		
		this.setDirection((newDirection % 360 + 360) % 360);
		
	}
}
