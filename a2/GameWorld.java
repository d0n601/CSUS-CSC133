package com.mycompany.a2;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;
import com.codename1.ui.Display;

public class GameWorld extends Observable implements IGameWorld {

	private Random r;
	
	private IIterator gi;

	private int clock;
	private int score;
	private int lives;
	private boolean sound;
	private int worldWidth;
	private int worldHeight;
	
	private PlayerShip myShip; 
	private GameObjectCollection gameObjectCollection;
	
	public static final int MAX_LIVES = 3;

	
	/**
	 * Initiate game world, storing lives, clock, and all game objects..
	 */
	public GameWorld() {
		this.clock = 0; 
		this.score = 0;
		this.sound = true;
		this.lives = MAX_LIVES;
		this.worldWidth = 0;
		this.worldHeight = 0;
		this.r = new Random();
		this.gameObjectCollection = new GameObjectCollection();
	}
	
	
	/**
	 * Returns the current game score.
	 * 
	 * @return score
	 */
	public int getScore() {
		return this.score;
	}
	

	/**
	 * Returns the current number of lives left.
	 * 
	 * @return lives
	 */
	public int getLives() {
		return this.lives;
	}
	
		
	/**
	 * Returns the current game time.
	 * 
	 * @return clock
	 */
	public int getClock() {
		return this.clock;
	}
	
	

	/**
	 * Returns the width of the game world.
	 * 
	 * @return width
	 */
	public int getWidth() {
		return this.worldWidth;
	}
	

	/**
	 * Returns the height of the game world.
	 * 
	 * @return width
	 */
	public int getHeight() {
		return this.worldHeight;
	}
	

	/**
	 * Sets the dimensions of the game world.
	 * 
	 */
	public void setDimensions(int x, int y) {
		this.worldWidth = x;
		this.worldHeight = y;
	    this.setChanged();
	    this.notifyObservers(this);
	}
	
	
	/**
	 * Return the player's missile count.
	 * 
	 * @return missleCount
	 */
	public int getMissileCount() {
		if(this.myShip != null) {
			return this.myShip.getMissileCount();
		}
		return 0;
	}
	
	
	/**
	 * 
	 * Determines if the sound is on.
	 * 
	 * @return sound
	 */
	public boolean getSound() {
		return this.sound;
	}
	
	
	/**
	 * Toggles game sound.
	 * 
	 */
	public void toggleSound() {
		this.sound = !this.sound;
	    this.setChanged();
	    this.notifyObservers(this);
	}
	
	
	/**
	 * Add a new asteroid to the GameWorld
	 * 
	 */
	public void addAsteroid() {
		this.gameObjectCollection.add(new Asteroid(this.r.nextInt(worldWidth), this.r.nextInt(worldHeight)));
	    this.setChanged();
	    this.notifyObservers(this);
	}
	
	
	/**
	 * Add a new NPS to the GameWorld
	 * 
	 */
	public void addNps() {
		this.gameObjectCollection.add(new NonPlayerShip(this.r.nextInt(worldWidth), this.r.nextInt(worldHeight)));
	    this.setChanged();
	    this.notifyObservers(this);
	}
	
	
	
	/**
	 * Add a Space Station to the GameWorld
	 * 
	 */
	public void addSpaceStation() {
		this.gameObjectCollection.add(new SpaceStation(this.r.nextInt(worldWidth), this.r.nextInt(worldHeight)));
	    this.setChanged();
	    this.notifyObservers(this);
	}
	
	
	
	/**
	 * Add a Player Ship to the GameWorld
	 * 
	 */
	public void addPlayerShip() {
		
		if(this.myShip == null) {
			this.myShip = PlayerShip.getShip(worldWidth/2, worldWidth/2);
			this.gameObjectCollection.add(this.myShip);
			this.gameObjectCollection.add(this.myShip.getMissileLauncher());
			System.out.println("Player Ship added to the game world.");
		    this.setChanged();
		    this.notifyObservers(this);
		}
		else {
			System.out.println("Cannot execute ‘add Player Ship’ – Player Ship has already been added to the Game World.");
		}
	}
	
	
	
	/**
	 * Attempt to increase speed of player ship by one.
	 * 
	 */
	public void iPlayerShipSpeed() {
		if(this.myShip != null) {
			this.myShip.setSpeed(this.myShip.getSpeed() + 1);
		    this.setChanged();
		    this.notifyObservers(this);
		}
		else {
			System.out.println("Cannot execute ‘increase’ – no Player Ship yet added to the Game World.");
		}
	}
	
	
	
	/**
	 * Attempt to decrease speed of player ship by one.
	 * 
	 */
	public void dPlayerShipSpeed() {
		if(this.myShip != null) {
			this.myShip.setSpeed(this.myShip.getSpeed() - 1);
		    this.setChanged();
		    this.notifyObservers(this);
		}
		else {
			System.out.println("Cannot execute ‘decrease’ – no Player Ship yet added to the Game World.");
		}
	}

	
	
	/**
	 * Turn the Player's Ship to the left (counter-clockwise).
	 * 
	 */
	public void playerShipLeft() {
		if(this.myShip != null) {
			this.myShip.steer( this.myShip.getDirection() - 20 );
		    this.setChanged();
		    this.notifyObservers(this);
		}
		else {
			System.out.println("Cannot execute ‘left’ – no Player Ship yet added to the Game World.");
		}
	}
	
	
	
	/**
	 * Turn the Player's Ship to the right (clockwise).
	 * 
	 */
	public void playerShipRight() {
		if(this.myShip != null) {
			this.myShip.steer( this.myShip.getDirection() + 20 );
		    this.setChanged();
		    this.notifyObservers(this);
		}
		else {
			System.out.println("Cannot execute ‘right’ – no Player Ship yet added to the Game World.");
		}
	}
	
	
	
	/**
	 * Turn the Player's Ship Missile Launcher to the left (counter-clockwise).
	 * 
	 */
	public void playerLauncherLeft() {
		if(this.myShip != null) {
			MissileLauncherSteerable ml = (MissileLauncherSteerable) this.myShip.getMissileLauncher();
			ml.steer( ml.getDirection() - 20 );
		    this.setChanged();
		    this.notifyObservers(this);
		}
		else {
			System.out.println("Cannot execute ‘missile launcher left’ – no Player Ship yet added to the Game World.");
		}
	}
	
	
	
	/**
	 * Turn the Player's Ship Missile Launcher to the right (clockwise).
	 * 
	 */
	public void playerLauncherRight() {
		if(this.myShip != null) {
			MissileLauncherSteerable ml = (MissileLauncherSteerable) this.myShip.getMissileLauncher();
			ml.steer( ml.getDirection() + 20 );
		    this.setChanged();
		    this.notifyObservers(this);
		}
		else {
			System.out.println("Cannot execute ‘missile launcher right’ – no Player Ship yet added to the Game World.");
		}
	}
	
	
	
	/**
	 * Player Ship fires a missile.
	 * 
	 */
	public void playerFireMissile() {
		if(this.myShip != null) {
			Missile newMissile = this.myShip.fireMissile();
			if(newMissile != null) {
				this.gameObjectCollection.add(newMissile);
				this.setChanged();
			    this.notifyObservers(this);
			}
		}
		else {
			System.out.println("Cannot execute ‘fire missile’ – no Player Ship yet added to the Game World.");
		}
	}
	
	
	
	/**
	 * Reload the missile count for the Players Ship.
	 * 
	 */
	public void playerShipReload() {
		if(this.myShip != null) { 
			this.myShip.setMissileCount(PlayerShip.MAX_MISSILES);
			System.out.println("Player Ship reloaded!");
		    this.setChanged();
		    this.notifyObservers(this);
		}
		else {
			System.out.println("Cannot execute ‘reload’ – no Player Ship yet added to the Game World.");
		}
	}
	
	
	
	/**
	 *  A Player Ship’s missile has struck and killed an asteroid.
	 *
	 */
	public void killAsteroid() {
		
		if(this.myShip == null) { 
			System.out.println("Cannot execute ‘kill asteroid’ – no Player Ship yet added to the Game World.");
		}
		
		else {
			
			ArrayList<Missile> playerMissiles = this.getMissiles(0);
			ArrayList<Asteroid> allAsteroids = this.getAsteroids();
			
			if(playerMissiles.isEmpty()) {
				System.out.println("Cannot execute ‘kill asteroid’ – no Player Ship Missiles yet added to the Game World.");
			}
			else if(allAsteroids.isEmpty()) {
				System.out.println("Cannot execute ‘kill asteroid’ – no asteroids yet added to the Game World.");
			}
			else {
				this.gameObjectCollection.remove(playerMissiles.get(0));
				this.gameObjectCollection.remove(allAsteroids.get(0));
				this.score = this.getScore() + 5;
				System.out.println("Hit! Player Ship has destroyed an asteroid.");
			    this.setChanged();
			    this.notifyObservers(this);
			}	
			
		}
		
	}
	
	
	
	/**
	 *  A Player Ship’s missile has struck and killed a Non-Player Ship.
	 *
	 */
	public void killNps() {
		
		if(this.myShip == null) { 
			System.out.println("Cannot execute ‘eliminate NPS’ – no Player Ship yet added to the Game World.");
		}
		else {
			
			ArrayList<Missile> playerMissiles = this.getMissiles(0);
			ArrayList<NonPlayerShip> allNPS = this.getAllNps();
			
			if(playerMissiles.isEmpty()) {
				System.out.println("Cannot execute ‘eliminate NPS’ – no Player Ship Missiles yet added to the Game World.");
			}
			else if(allNPS.isEmpty()) {
				System.out.println("Cannot execute ‘eliminate NPS’ – no Non-Player Ships yet added to the Game World.");
			}
			else {
				this.gameObjectCollection.remove(playerMissiles.get(0));
				this.gameObjectCollection.remove(allNPS.get(0));
				this.score = this.getScore() + 15;
				System.out.println("Hit! Player Ship has destroyed an NPS.");
			    this.setChanged();
			    this.notifyObservers(this);
			}	
			
		}

	}
	
	
	
	/**
	 * A Non-Player Ship's missile has killed the Player's Ship.
	 * 
	 */
	public void killPlayerNpsMissile() {
		
		if(this.myShip == null) { 
			System.out.println("Cannot execute ‘Exploded’ – no Player Ship yet added to the Game World.");
		}
		else {
			
			ArrayList<Missile> npsMissiles = this.getMissiles(1);
			
			if(npsMissiles.isEmpty()) {
				System.out.println("Cannot execute ‘Exploded’ – no Non-Player Ship Missiles yet added to the Game World.");
			}
	
			else {
				this.playerShipDeath();
				this.gameObjectCollection.remove(npsMissiles.get(0));
				System.out.println("Player Ship Killed by NPS Missile.");
			    this.setChanged();
			    this.notifyObservers(this);
			}	
			
		}
		
	}
	
	
	
	/**
	 *  A Player Ship has struck and killed an asteroid.
	 *
	 */
	public void killPlayerAsteroid() {
		
		if(this.myShip == null) { 
			System.out.println("Cannot execute ‘crashed’ – no Player Ship yet added to the Game World.");
		}
		
		else {
			
			ArrayList<Asteroid> allAsteroids = this.getAsteroids();
			
			if(allAsteroids.isEmpty()) {
				System.out.println("Cannot execute ‘crashed’ – no asteroids yet added to the Game World.");
			}
			else {
				this.playerShipDeath();
				this.gameObjectCollection.remove(allAsteroids.get(0));
				System.out.println("Player Ship Killed by Asteroid.");	
			    this.setChanged();
			    this.notifyObservers(this);
			}	
			
		}
		
	}
	
	
	
	/**
	 * A Non-Player Ship's missile has killed the Player's Ship.
	 * 
	 */
	public void killPlayerNps() {
		
		if(this.myShip == null) { 
			System.out.println("Cannot execute ‘hit’ – no Player Ship yet added to the Game World.");
		}
		else {
			
			ArrayList<NonPlayerShip> allNPS = this.getAllNps();
			
			if(allNPS.isEmpty()) {
				System.out.println("Cannot execute ‘hit’ – no Non-Player Ship Missiles yet added to the Game World.");
			}
	
			else {
				this.playerShipDeath();
				this.gameObjectCollection.remove(allNPS.get(0));
				System.out.println("Player Ship Killed by NPS collision.");
			    this.setChanged();
			    this.notifyObservers(this);
			}	
			
		}
		
	}
	
	
	
	/**
	 * Two Asteroids have collided.
	 * 
	 */
	public void killAsteroids() {
		
		ArrayList<Asteroid> allAsteroids = this.getAsteroids();
		
		if(allAsteroids.size() < 2) {
			System.out.println("Cannot execute ‘exterminate asteroids’ – there are not yet two Asteroids or more added to the Game World.");
		}
		else {
			this.gameObjectCollection.remove(allAsteroids.get(0));
			this.gameObjectCollection.remove(allAsteroids.get(1));
			System.out.println("Asteroid Collision!");
		    this.setChanged();
		    this.notifyObservers(this);
		}
	}
	
	
	
	/**
	 *  A Non-Player Ship has struck an Asteroid.
	 *
	 */
	public void killNpsAsteroid() {
		
		ArrayList<Asteroid> allAsteroids = this.getAsteroids();
		ArrayList<NonPlayerShip> allNPS = this.getAllNps();
		
		if(allAsteroids.isEmpty()) {
			System.out.println("Cannot execute ‘NPS Impact Asteroid’ – no Asteroids yet added to the Game World.");
		}
		else if(allNPS.isEmpty()) {
			System.out.println("Cannot execute ‘NPS Impact Asteroid’ – no Non-Player Ships yet added to the Game World.");
		}
		else {
			this.gameObjectCollection.remove(allAsteroids.get(0));
			this.gameObjectCollection.remove(allNPS.get(0));
			System.out.println("Non-Player Ship has impacted an Asteroid..");
		    this.setChanged();
		    this.notifyObservers(this);
		}	

	}
	
	
	
	/**
	 * Non-Player Ship fires a missile.
	 * 
	 */
	public void npsFireMissile() {
		
		ArrayList<NonPlayerShip> allNPS = this.getAllNps();
		
		if(!allNPS.isEmpty()) {
			
			Missile newMissile = ((NonPlayerShip) allNPS.get(0)).fireMissile();
			
			if(newMissile != null) {
				this.gameObjectCollection.add(newMissile);
			    this.setChanged();
			    this.notifyObservers(this);
			}
			
		}
		else {
			System.out.println("Cannot execute ‘fire missile’ – there are no Non-Player Ships yet added to the Game World.");
		}
	}
	
	
	
	/**
	 * Jump the Player's Ship to the middle of the screen.
	 * 
	 */
	public void jumpHyperSpace() {
		if(this.myShip != null) {
			this.myShip.setLocation(512, 384);
		    this.setChanged();
		    this.notifyObservers(this);
		}
		else {
			System.out.println("Cannot execute ‘jump’ – no Player Ship yet added to the Game World.");
		}
	}
	
	
	
	/**
	 * Advance game clock forward, take action on all objects accordingly.	 
	 * 
	 */
	public void tickClock() {
		
		// Move movable objects
		ArrayList<MovableGameObject>  movableObjects = this.getMoveable();
		
		for(MovableGameObject mo: movableObjects) {
			mo.move();
		}

		// Reduce fuel for missiles, remove empty missiles.
		ArrayList<Missile>  allMissiles = this.getMissiles(2);
		
		for(Missile m : allMissiles) {
			int currFuel = m.getFuelLevel();
			if(currFuel > 0) {
				currFuel--;
				m.setFuelLevel(currFuel);
			}
			else {
				gameObjectCollection.remove(m);
			}
		}
			
		// Each space station toggles its blinking light if the tick count modulo the station’s blink rate is 0.
		ArrayList<SpaceStation> allSpaceStations = this.getStations();
		
		for(SpaceStation sp: allSpaceStations) {
			
			if( sp.getBlinkRate() > 0 && (this.clock % sp.getBlinkRate()) == 0) {
				sp.toggleOn();
			}
			
		}
		
		// Advance the game clock forward one tick.
		this.clock++;
	    this.setChanged();
	    this.notifyObservers(this);
	}
	
	
	
	
	/**
	 * Quit the current game and exit.
	 * 
	 */
	public void quitGame() {
		Display.getInstance().exitApplication();
	}
	
	
	
	/**
	 * Print out all GameObjects within the GameWorld.
	 * 
	 */
	public void printMap() {
			
		this.gi = this.gameObjectCollection.getIterator() ;
		
		while ( gi.hasNext() ) {
			
			GameObject go = gi.getNext();
			
			// Ignore Missile Launchers when printing objects.
			if( !(go instanceof MissileLauncher)) {
				
				// If it's a Space Station make sure it's blinking 'on'.
				if( (go instanceof SpaceStation) ) {
					if(((SpaceStation)go).isOn()) {
						System.out.println(go.toString());
					}
				}
				// Print everything else out.
				else {
					System.out.println(go.toString());
				}
			}
		}
	}
	
	
	
	
	
	
	/**
	 * String representation of the GameWorld. 
	 * This is really a text map, as it doesn't include
	 * all objects in the game world such as Missile Launchers
	 * and Space Stations blinking off.
	 * 
	 */
	public String toString() {
		
		String ret = ""; // Initialize empty string.
	    String newLine = System.getProperty("line.separator"); //This will retrieve line separator dependent on OS.
		
		this.gi = this.gameObjectCollection.getIterator() ;
		
		while ( gi.hasNext() ) {	
			GameObject go = gi.getNext();	
			// Ignore Missile Launchers when printing objects.
			if( !(go instanceof MissileLauncher)) {
				
				// If it's a Space Station make sure it's blinking 'on'.
				if( (go instanceof SpaceStation) ) {
					if(((SpaceStation)go).isOn()) {
						ret = ret + go.toString() + newLine;
					}
				}
				// Print everything else out.
				else {
					ret = ret + go.toString() + newLine;
				}
			}				
		}
		
		return ret;
	}
	
	
	
	
	/**
	 * Kill the Player Ship, possibly end game.
	 * 
	 */
	private void playerShipDeath() {
		
		this.lives --;
		
		if(this.lives <= 0) {
			System.out.println("Game Over!");
			System.exit(0);
		}
		else {
			this.gameObjectCollection.remove(this.myShip.getMissileLauncher());
			this.gameObjectCollection.remove(this.myShip);
			this.myShip = null;
			this.addPlayerShip();
		}
	}
	
	
	
	/**
	 * Helper method to find all Non-Player Ships in Game World
	 *  
	 * @return ArrayList of Non-PlayerShips
	 * 
	 */
	private ArrayList<NonPlayerShip> getAllNps() {
		
		ArrayList<NonPlayerShip> nonPlayerShips = new ArrayList<>(); 
		
		this.gi = this.gameObjectCollection.getIterator() ;
		
		while ( gi.hasNext() ) {
			GameObject go = gi.getNext();
			if(go instanceof NonPlayerShip) {
				nonPlayerShips.add((NonPlayerShip)go);
			}
		}
		
		return nonPlayerShips;
	
	}
	

	
	/**
	 * Helper method to find all Missiles Ships in Game World.
	 * An input of 0 returns Player Ship Missiles, 1 returns  Non-Player Ship 
	 * Missiles, an greater than 1 returns all Missiles.
	 * 
	 * @param int
	 * @return ArrayList of Asteroids.
	 * 
	 */
	private ArrayList<Missile> getMissiles(int missileType) {
		
		ArrayList<Missile> missiles = new ArrayList<>(); 
		
		this.gi = this.gameObjectCollection.getIterator() ;

		while ( gi.hasNext() ) {
			GameObject go = gi.getNext();
			if(go instanceof Missile) {
				if(missileType == 0) {
					if(((Missile) go).getOwner() instanceof PlayerShip)  {
						missiles.add((Missile)go);
					}
				}		
				else if(missileType == 1) {
					if(((Missile) go).getOwner() instanceof NonPlayerShip)  {
						missiles.add((Missile)go);
					}
				}		
				else {
					missiles.add((Missile)go);
				}			}
		}
		return missiles;
	}
	
	
	
	/**
	 * Return all Asteroids.
	 * 
	 * @return ArrayList of Asteroids.
	 * 
	 */
	private ArrayList<Asteroid> getAsteroids() {
		
		ArrayList<Asteroid> asteroids = new ArrayList<>(); 
		
		this.gi = this.gameObjectCollection.getIterator() ;
		
		while ( gi.hasNext() ) {
			GameObject go = gi.getNext();
			if(go instanceof Asteroid) {
				asteroids.add((Asteroid)go);
			}
		}
		
		return asteroids;
	}
	
	
	/**
	 * Return all MovableObjects.
	 * 
	 * @return ArrayList of MoveableObjects.
	 * 
	 */
	private ArrayList<MovableGameObject> getMoveable() {
	
		ArrayList<MovableGameObject> mo = new ArrayList<>(); 
		
		this.gi = this.gameObjectCollection.getIterator() ;
		
		while ( gi.hasNext() ) {
			GameObject go = gi.getNext();
			if(go instanceof MovableGameObject) {
				mo.add((MovableGameObject)go);
			}
		}
		return mo;
	}
	
	
	/**
	 * Return all SpaceStations.
	 * 
	 * @return ArrayList of Space Stations.
	 * 
	 */
	private ArrayList<SpaceStation> getStations() {
		
		ArrayList<SpaceStation> spaceStations = new ArrayList<>(); 
		
		this.gi = this.gameObjectCollection.getIterator() ;
		
		while ( gi.hasNext() ) {
			GameObject go = gi.getNext();
			if(go instanceof SpaceStation) {
				spaceStations.add((SpaceStation)go);
			}
		}
		
		return spaceStations;
	}
	
	
}
	
	

