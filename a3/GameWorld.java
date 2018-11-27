package com.mycompany.a3;

import java.util.ArrayList;
import java.util.Observable;
import com.codename1.ui.Display;

public class GameWorld extends Observable implements IGameWorld {
	
	private IIterator gi;
	
	private BGSound bgMusic;
	private Sound reloadSound;
	private Sound fireMissileSound;
	private Sound explosionSound;
	private Sound hyperspaceSound;


	private int clock;
	private int score;
	private int lives;
	private boolean sound;
	private boolean paused;
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
		this.paused = false;
		this.lives = MAX_LIVES;
		this.worldWidth = 0;
		this.worldHeight = 0;
		this.gameObjectCollection = new GameObjectCollection();
		this.bgMusic = new BGSound("bg_music.wav");
		this.reloadSound = new Sound("reload.wav");
		this.fireMissileSound = new Sound("fire_missile.wav");
		this.explosionSound = new Sound("explosion.wav");
		this.hyperspaceSound = new Sound("hyperspace.wav");
		this.playBgMusic();
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
	 * Determines of the game is paused or not.
	 * 
	 * @return paused
	 */
	public boolean isPaused() {
		return this.paused;
	}
	
	
	/**
	 * Toggles the pause state of the game
	 * 
	 */
	public void togglePaused() {
		
		this.paused = !this.paused;
		
		if(!this.paused && this.sound) {
			this.playBgMusic();
		}
		else if(this.paused && this.sound) {
			this.pauseBgMusic();
		}
		
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
		if(sound && !this.paused) {
			this.playBgMusic();
		}
		else {
			this.pauseBgMusic();
		}
	    this.setChanged();
	    this.notifyObservers(this);
	}
	
	
	/**
	 * Add a new asteroid to the GameWorld
	 * 
	 */
	public void addAsteroid() {
		this.gameObjectCollection.add(new Asteroid(this.worldWidth, this.worldHeight));
	    this.setChanged();
	    this.notifyObservers(this);
	}
	
	
	/**
	 * Add a new NPS to the GameWorld
	 * 
	 */
	public void addNps() {
		this.gameObjectCollection.add(new NonPlayerShip(this.worldWidth, this.worldHeight));
	    this.setChanged();
	    this.notifyObservers(this);
	}
	
	
	
	/**
	 * Add a Space Station to the GameWorld
	 * 
	 */
	public void addSpaceStation() {
		this.gameObjectCollection.add(new SpaceStation(this.worldWidth, this.worldHeight));
	    this.setChanged();
	    this.notifyObservers(this);
	}
	
	
	
	/**
	 * Add a Player Ship to the GameWorld
	 * 
	 */
	public void addPlayerShip() {
		
		if(this.myShip == null) {
			
			this.myShip = new PlayerShip(this.worldWidth, this.worldHeight);
			
			this.gameObjectCollection.add(this.myShip);
			
			this.gameObjectCollection.add(this.myShip.getMissileLauncher());
			
			System.out.println("Player Ship added to the game world.");
			
		    this.setChanged();
		    this.notifyObservers(this);
		    
		}
		
		else {
			System.out.println("Cannot execute ‘add Player Ship’ – Player Ship has already been added to the Game World.");
			System.out.println(this.myShip);
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
				this.playSound(fireMissileSound);
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
			this.playSound(this.reloadSound);
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
	public void killAsteroid(Asteroid deadAsteroid, Missile playerMissile) {
		this.gameObjectCollection.remove(deadAsteroid); // Remove asteroid from game world.
		this.gameObjectCollection.remove(playerMissile); // Remove player's missile from game world.
		this.score = this.getScore() + 5; // Increase player's score 5 points for the hit.
		System.out.println("Hit! Player has destroyed an asteroid."); // Console output.
		this.playSound(explosionSound);
	    this.setChanged(); //
	    this.notifyObservers(this);
	}
	
	
	
	/**
	 *  A Player Ship’s missile has struck and killed a Non-Player Ship.
	 *
	 */
	public void killNps(NonPlayerShip nps, Missile m) {
		this.gameObjectCollection.remove(nps);
		this.gameObjectCollection.remove(m);
		this.score = this.getScore() + 15;
		System.out.println("Hit! Player Ship has destroyed an NPS.");
	    this.setChanged();
	    this.notifyObservers(this);

	}
	
	
	
	/**
	 * A Non-Player Ship's missile has killed the Player's Ship.
	 * 
	 */
	public void killPlayerNpsMissile(Missile m) {			
		this.gameObjectCollection.remove(m);
		System.out.println("Player Ship Killed by NPS Missile.");
		this.playerShipDeath();
	    this.setChanged();
	    this.notifyObservers(this);

	}
	
	
	
	/**
	 *  A Player Ship has struck and killed an asteroid.
	 *
	 */
	public void killPlayerAsteroid(Asteroid a) {
		this.gameObjectCollection.remove(a);
		this.playerShipDeath();
		System.out.println("Player Ship Killed by Asteroid.");	
	    this.setChanged();
	    this.notifyObservers(this);
	}
	
	
	
	/**
	 * A Non-Player Ship collided with and destroyed the Player's Ship.
	 * 
	 */
	public void killPlayerNps(NonPlayerShip nps) {
		this.gameObjectCollection.remove(nps);
		this.playerShipDeath();
		System.out.println("Player Ship Killed by NPS collision.");
		this.setChanged();
		this.notifyObservers(this);
	}
	
	
	
	/**
	 * Two Asteroids have collided.
	 * 
	 */
	public void killAsteroids(Asteroid a1, Asteroid a2) {
		
		this.gameObjectCollection.remove(a1);
		this.gameObjectCollection.remove(a2);
		
		System.out.println("Asteroid Collision!");
		
	    this.setChanged();
	    this.notifyObservers(this);
		
	}
	
	
	
	/**
	 *  A Non-Player Ship has struck an Asteroid.
	 *
	 */
	public void killNpsAsteroid(Asteroid a, NonPlayerShip nps) {
		this.gameObjectCollection.remove(a);
		this.gameObjectCollection.remove(nps);
		System.out.println("Non-Player Ship has impacted an Asteroid..");
	    this.setChanged();
	    this.notifyObservers(this);
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
				this.fireMissileSound.play();
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
			this.myShip.setLocation(worldWidth/2, worldHeight/2);
			this.myShip.setSpeed(0); // If you're moving when you jump to hypersace, it sucks.
			this.playSound(this.hyperspaceSound);
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
			mo.move(Game.CLOCK_MILISECONDS);
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
	 * Play the background music.
	 * 
	 */
	public void playBgMusic() {
		this.bgMusic.run();
	}
	

	
	/**
	 * Pause the background music.
	 * 
	 */
	public void pauseBgMusic() {
		this.bgMusic.pause();
	}
	
	
	/**
	 * Changes selection state of object
	 * @param go
	 */
	public void selectObject(ISelectable go, boolean selection) {
		if(this.paused) {
			go.setSelected(selection);
			this.setChanged();
			this.notifyObservers(this);
		}
		else {
			System.out.println("Cannot select objects while game is running.");
		}
	} 
	
	/**
	 * Quit the current game and exit.
	 * 
	 */
	public void quitGame() {
		Display.getInstance().exitApplication();
	}
	
	
	
	/**
	 * Returns a collection of game world objects
	 * 
	 * @return GameObjectCollection
	 */
	public GameObjectCollection getCollection() {
		return this.gameObjectCollection;
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
		
		this.gi = this.gameObjectCollection.getIterator();
		
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
	 * Handle collisions for all game objects.
	 * 
	 */
	public void handleCollisions() {
		
		// Check for collisions
		ArrayList<GameObject> allObjects = this.getAllObjects();
		ArrayList<GameObject> collisionD1 = new ArrayList<>();
		ArrayList<GameObject> collisionD2 = new ArrayList<>();
		
		// Loop all game objects for collisions
		for(int c = 0; c < allObjects.size(); c++) {
			
			GameObject go1 = allObjects.get(c);
			
			for(int d = c+1; d < allObjects.size(); d++) {
				GameObject go2 = allObjects.get(d);
				if(!collisionD1.contains(go1) && !collisionD1.contains(go2) && go1.collidesWith(go2)) {
					collisionD1.add(go1);
					collisionD2.add(go2);
				}
			}
		}
		
		// Loop collisions and remove them from game
		for(int c = 0; c < collisionD1.size(); c++) {
			
			boolean remove = false;
			
			GameObject go1 = collisionD1.get(c);
			GameObject go2 = collisionD2.get(c);
			
			if(allObjects.contains(go1) && allObjects.contains(go2)) {
				
				if( go1 instanceof Asteroid) {
					if(go2 instanceof Asteroid) {
						this.killAsteroids((Asteroid)go1, (Asteroid)go2);
						remove = true;
					}
					else if(go2 instanceof NonPlayerShip) {
						this.killNpsAsteroid((Asteroid)go1, (NonPlayerShip) go2);
						remove = true;
					}
					else if(go2 instanceof Missile) {
						// NonPlayer Missiles do not destroy Asteroids!
						if(((Missile) go2).getOwner() instanceof PlayerShip) {
							this.killAsteroid((Asteroid)go1, (Missile)go2);
							remove = true;
						}						
					}
					else if(go2 instanceof PlayerShip) {
						this.killPlayerAsteroid((Asteroid)go1);
						remove = true;
					}
				}
				
				else if( go1 instanceof NonPlayerShip) {
					if(go2 instanceof Asteroid) {
						this.killNpsAsteroid((Asteroid)go2, (NonPlayerShip) go1);
						remove = true;
					}
					else if(go2 instanceof Missile) {
						// NonPlayer Missiles do not destroy other NonPlayerShips
						if(((Missile) go2).getOwner() instanceof PlayerShip) {
							this.killNps((NonPlayerShip)go1, (Missile)go2);
							remove = true;
						}	
						
					}
					else if(go2 instanceof PlayerShip) {
						this.killPlayerNps((NonPlayerShip)go1);
						remove = true;
					}
				}
				else if( go1 instanceof Missile) {
					if(go2 instanceof Asteroid) {
						// NonPlayer Missiles do not destroy Asteroids
						if(((Missile) go1).getOwner() instanceof PlayerShip) {
							this.killAsteroid((Asteroid)go2, (Missile)go1);
							remove = true;
						}	
					}
					else if(go2 instanceof NonPlayerShip) {
						if(((Missile) go1).getOwner() instanceof PlayerShip) {
							this.killNps((NonPlayerShip) go2, (Missile)go1);
							remove = true;
						}	
					}
					else if(go2 instanceof PlayerShip) {
						if(((Missile) go2).getOwner() instanceof NonPlayerShip) {
							this.killPlayerNpsMissile((Missile)go2);
							remove = true;
						}
					}
				}
				else if( go1 instanceof PlayerShip) {
					if(go2 instanceof Asteroid) {
						this.killPlayerAsteroid((Asteroid)go2);
						remove = true;
					}
					else if(go2 instanceof NonPlayerShip) {
						this.killPlayerNps((NonPlayerShip)go2);
						remove = true;
					}
					else if(go2 instanceof Missile) {
						if(((Missile) go2).getOwner() instanceof NonPlayerShip ){
							this.killPlayerNpsMissile((Missile)go2);
							remove = true;
						}
					}
					else if(go2 instanceof SpaceStation) {
						this.playerShipReload();
					}
				}
				
				if(remove) {
					allObjects.remove(go1);
					allObjects.remove(go2);
				}
				
			}
			
		}
		

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
			this.gameObjectCollection.remove(this.myShip.getMissileLauncher()); // Removes ship's missile launcher from the game.
			this.gameObjectCollection.remove(this.myShip); // Removes ship from game object collection, (the game world).
			this.myShip = null; // Set local reference to player ship to null.
			this.setChanged();
			this.notifyObservers(this);
			//this.addPlayerShip(); // Add new player ship to the game collection, and reference it.
		}
	}
	
	
	
	/**
	 * Plays game sounds when sound is turned on.
	 * 
	 * @param s
	 */
	private void playSound(Sound s) {
		if(sound) {
			s.play();
		}
	}
	
	
	/**
	 * Uses our built in iterator, to return an 
	 * ArrayList of GameObjects....yeah I know.
	 * 
	 * @return allObjects
	 */
	private ArrayList<GameObject> getAllObjects() {
		
		IIterator gii = this.gameObjectCollection.getIterator();
		
		ArrayList<GameObject> allObjects = new ArrayList<>();
			
		while(gii.hasNext()) {
			allObjects.add(gii.getNext());
		}
		
		return allObjects;
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
	
	

