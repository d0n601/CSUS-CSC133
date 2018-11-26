package com.mycompany.a2;

import java.util.Observer;
import java.util.Observable;

public class GameWorldProxy extends Observable implements IGameWorld, Observer {
	
	private GameWorld gw;
	
	public GameWorldProxy(GameWorld gw) {
		this.gw = gw;
	}
	
	@Override
	public int getScore() {
		return gw.getScore();
	}

	@Override
	public int getLives() {
		return gw.getLives();
	}

	@Override
	public int getClock() {
		return gw.getClock();
	}

	@Override
	public int getWidth() {
		return gw.getWidth();
	}
	
	@Override
	public int getHeight() {
		return gw.getHeight();
	}
	
	@Override
	public void setDimensions(int x, int y) {
		System.out.println("Illegally accessed method.");
	}
	
	@Override
	public int getMissileCount() {
		return gw.getMissileCount();
	}
	
	@Override
	public boolean getSound() {
		return gw.getSound();
	}
	
	@Override
	public void toggleSound() {
		System.out.println("Illegally accessed method.");
	}

	@Override
	public void addAsteroid() {
		System.out.println("Illegally accessed method.");
	}

	@Override
	public void addNps() {
		System.out.println("Illegally accessed method.");
	}

	@Override
	public void addSpaceStation() {
		System.out.println("Illegally accessed method.");
	}

	@Override
	public void addPlayerShip() {
		System.out.println("Illegally accessed method.");
	}

	@Override
	public void iPlayerShipSpeed() {
		System.out.println("Illegally accessed method.");
	}

	@Override
	public void dPlayerShipSpeed() {
		System.out.println("Illegally accessed method.");
	}

	@Override
	public void playerShipLeft() {
		System.out.println("Illegally accessed method.");
	}

	@Override
	public void playerShipRight() {
		System.out.println("Illegally accessed method.");
	}

	@Override
	public void playerLauncherLeft() {
		System.out.println("Illegally accessed method.");
	}

	@Override
	public void playerLauncherRight() {
		System.out.println("Illegally accessed method.");
	}

	@Override
	public void playerFireMissile() {
		System.out.println("Illegally accessed method.");
	}

	@Override
	public void playerShipReload() {
		System.out.println("Illegally accessed method.");	
	}

	@Override
	public void killAsteroid() {
		System.out.println("Illegally accessed method.");
	}

	@Override
	public void killNps() {
		System.out.println("Illegally accessed method.");	
	}

	@Override
	public void killPlayerNpsMissile() {
		System.out.println("Illegally accessed method.");
	}

	@Override
	public void killPlayerAsteroid() {
		System.out.println("Illegally accessed method.");	
	}

	@Override
	public void killPlayerNps() {
		System.out.println("Illegally accessed method.");
	}

	@Override
	public void killAsteroids() {
		System.out.println("Illegally accessed method.");
	}

	@Override
	public void killNpsAsteroid() {
		System.out.println("Illegally accessed method.");
	}

	@Override
	public void npsFireMissile() {
		System.out.println("Illegally accessed method.");
	}

	@Override
	public void jumpHyperSpace() {
		System.out.println("Illegally accessed method.");
	}

	@Override
	public void tickClock() {
		System.out.println("Illegally accessed method.");	
	}

	@Override
	public void quitGame() {
		System.out.println("Illegally accessed method.");
	}

	@Override
	public void update(Observable observable, Object data) {
		this.gw = (GameWorld)data;
	    this.setChanged();
	    this.notifyObservers(this.gw);
	}
	
	@Override
	public String toString() {
		return gw.toString();
	}
	
}
