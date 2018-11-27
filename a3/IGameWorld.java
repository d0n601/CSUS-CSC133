package com.mycompany.a3;

public interface IGameWorld {
		
	public int getScore();
	
	public int getLives();
	
	public int getClock();
	
	public int getWidth();
		
	public int getHeight();
	
	public boolean isPaused();
	
	public void togglePaused();
	
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
	
	public void killAsteroid(Asteroid a, Missile m);
	
	public void killNps(NonPlayerShip nps, Missile m);
	
	public void killPlayerNpsMissile(Missile m);
	
	public void killPlayerAsteroid(Asteroid a);
	
	public void killPlayerNps(NonPlayerShip nps);
	
	public void killAsteroids(Asteroid a1, Asteroid a2);
	
	public void killNpsAsteroid(Asteroid a, NonPlayerShip nps);
	
	public void npsFireMissile();
	
	public void jumpHyperSpace();
	
	public void tickClock();
	
	public GameObjectCollection getCollection();
	
	public void playBgMusic();
	
	public void pauseBgMusic();
		
	public void selectObject(ISelectable go, boolean selection);
	
	public void quitGame();	
	
}
