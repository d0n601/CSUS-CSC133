package com.mycompany.a2;

public interface IGameWorld {
		
	public int getScore();
	
	public int getLives();
	
	public int getClock();
	
	public int getWidth();
		
	public int getHeight();
	
	public void setDimensions(int x, int y);

	public int getMissileCount();
	
	public boolean getSound();
	
	public void toggleSound();
	
	public void addAsteroid();
	
	public void addNps();
	
	public void addSpaceStation();
	
	public void addPlayerShip();
	
	public void iPlayerShipSpeed();
	
	public void dPlayerShipSpeed();
	
	public void playerShipLeft();
	
	public void playerShipRight();
	
	public void playerLauncherLeft();
	
	public void playerLauncherRight();
	
	public void playerFireMissile();
	
	public void playerShipReload();
	
	public void killAsteroid();
	
	public void killNps();
	
	public void killPlayerNpsMissile();
	
	public void killPlayerAsteroid();
	
	public void killPlayerNps();
	
	public void killAsteroids();
	
	public void killNpsAsteroid();
	
	public void npsFireMissile();
	
	public void jumpHyperSpace();
	
	public void tickClock();
		
	public void quitGame();	
	
}
