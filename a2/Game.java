package com.mycompany.a2;

import com.mycompany.a2.commands.*;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.Toolbar;

public class Game extends Form{

	private GameWorld gw;
	private GameWorldProxy gwp;
	private MapView mv;
	private PointsView pv;
	
	
	/**
	 * Constructs an instance of a Game, creates the
	 * Game World and initializes it, calls play.
	 * 
	 */
	public Game() {
		
		this.gw = new GameWorld(); // Create the Game World
		this.gwp = new GameWorldProxy(this.gw); // Create Game World Proxy, pass it Game World.
		
		this.mv = new MapView(gwp); // Create the Map View
		this.pv = new PointsView(gwp); // Create the Points View
				
		gw.addObserver(gwp); // Our Game World Proxy observes the game world.
		gwp.addObserver(mv); // Add the Map View as an observer of the Game World Proxy.
		gwp.addObserver(pv); // Add the Points as an observer of the Game World Proxy.
		
		this.setLayout(new BorderLayout()); // Set Border Layout for Game From
		
		/* Code for Tool Bar */
		Toolbar spaceToolbar = new Toolbar();
		this.setToolbar(spaceToolbar);
		spaceToolbar.setTitle("Asteroid Game (ver.a2)");

		
		/* Create Control Panel Container */
		Container controlPanel = new Container(new BoxLayout(BoxLayout.Y_AXIS)); 
		
		/* Toolbar's overflow menu commands*/
		NewGameCommand newGameCommand = new NewGameCommand(gw); //New
		SaveCommand saveCommand = new SaveCommand(gw); //Save
		UndoCommand undoCommand = new UndoCommand(gw); //Undo
		SoundCommand soundCommand = new SoundCommand(gw); //Sound
		AboutCommand aboutCommand = new AboutCommand(gw); //About
		QuitGameCommand quitGameCommand = new QuitGameCommand(gw);//Quit
		

		/* Create all required commands for game play */
		AddAsteroidCommand addAsteroidCommand = new AddAsteroidCommand(gw);
		AddNpsCommand addNpsCommand = new AddNpsCommand(gw); 
		AddSpaceStationCommand addSpaceStationCommand = new AddSpaceStationCommand(gw);
		AddPlayerShipCommand addPlayerShipCommand = new AddPlayerShipCommand(gw);
		AcceleratePlayerShipCommand acceleratePlayerShipCommand = new AcceleratePlayerShipCommand(gw); 
		DeceleratePlayerShipCommand deceleratePlayerShipCommand = new DeceleratePlayerShipCommand(gw);
		LeftTurnCommand leftTurnCommand = new LeftTurnCommand(gw); 
		RightTurnCommand rightTurnCommand = new RightTurnCommand(gw);
		AimLeftCommand aimLeftCommand = new AimLeftCommand(gw);
		AimRightCommand aimRightCommand = new AimRightCommand(gw);
		PlayerFireMissileCommand fireMissileCommand = new PlayerFireMissileCommand(gw);
		NpsFireMissileCommand npsFireMissileCommand = new NpsFireMissileCommand(gw);
		JumpHyperSpaceCommand jumpHyperSpaceCommand = new JumpHyperSpaceCommand(gw);
		ReloadCommand reloadCommand = new ReloadCommand(gw);
		KillAsteroidCommand killAsteroidCommand = new KillAsteroidCommand(gw);
		KillNpsCommand killNpsCommand = new KillNpsCommand(gw);
		KillPlayerNpsMissileCommand killPlayerNpsMissileCommand = new KillPlayerNpsMissileCommand(gw);
		KillPlayerAsteroidCommand killPlayerAsteroidCommand = new KillPlayerAsteroidCommand(gw);
		KillPlayerNpsCommand killPlayerNpsCommand = new KillPlayerNpsCommand(gw);
		AsteroidCollisionCommand asteroidCollisionCommand = new AsteroidCollisionCommand(gw);
		KillNpsAsteroidCommand killNpsAsteroidCommand = new KillNpsAsteroidCommand(gw);
		TickClockCommand tickClockCommand = new TickClockCommand(gw);
					
		/* Add commands to overflow menu */
		spaceToolbar.addCommandToOverflowMenu(newGameCommand);
		spaceToolbar.addCommandToOverflowMenu(saveCommand);
		spaceToolbar.addCommandToOverflowMenu(undoCommand);
		spaceToolbar.addCommandToOverflowMenu(aboutCommand);
		spaceToolbar.addCommandToOverflowMenu(quitGameCommand);
		
		/* Create buttons for commands */
		CheckBox soundCheck = new CheckBox("Sound");
		soundCheck.setSelected(true);
		
		SpaceButton addAsteroidButton = new SpaceButton("Add Asteroid"); 
		SpaceButton addNpsButton = new SpaceButton("Add Non-Player Ship"); 
		SpaceButton addSpaceStationButton = new SpaceButton("Add Space Station");
		SpaceButton addPlayerShipButton = new SpaceButton("Add Player Ship"); 
		SpaceButton accelerateButton = new SpaceButton("Accelerate ");
		SpaceButton decelerateButton = new SpaceButton("Decelerate"); 
		SpaceButton leftTurnButton = new SpaceButton("Left Turn");
		SpaceButton rightTurnButton = new SpaceButton("Right Turn");
		SpaceButton aimLeftButton = new SpaceButton("Aim Left"); 
		SpaceButton aimRightButton = new SpaceButton("Aim Right"); 
		SpaceButton psFireButton = new SpaceButton("PS Fire Missile"); 
		SpaceButton npsFireButton = new SpaceButton("NPS Fire Missile"); 
		SpaceButton hyperSpaceButton = new SpaceButton("Hyperspace Jump");
		SpaceButton reloadButton = new SpaceButton("Reload Missiles");
		SpaceButton missileToAsteroidButton = new SpaceButton("Missile kills Asteroid");
		SpaceButton killNpsButton = new SpaceButton("Missile kill NPS");
		SpaceButton killPlayerNpsMissileButton = new SpaceButton("NPS Missile kills Player");
		SpaceButton killPlayerAsteroidButton = new SpaceButton("Asteroid kills Player");
		SpaceButton collisionPlayerNpsButton = new SpaceButton("NPS to Player Collision");
		SpaceButton collisionAsteroidsButton = new SpaceButton("Asteroid Collision");
		SpaceButton collisionNpsAsteroidButton = new SpaceButton("Asteroid kills NPS");
		SpaceButton tickClockButton = new SpaceButton("Tick Clock");
		SpaceButton quitButton = new SpaceButton("Quit Game");

		/* Bind buttons to their associated commands */	
		soundCheck.setCommand(soundCommand);
		addAsteroidButton.setCommand(addAsteroidCommand);
		addNpsButton.setCommand(addNpsCommand);
		addSpaceStationButton.setCommand(addSpaceStationCommand);
		addPlayerShipButton.setCommand(addPlayerShipCommand);
		accelerateButton.setCommand(acceleratePlayerShipCommand);
		decelerateButton.setCommand(deceleratePlayerShipCommand);
		leftTurnButton.setCommand(leftTurnCommand);
		rightTurnButton.setCommand(rightTurnCommand);
		aimRightButton.setCommand(aimRightCommand);
		aimLeftButton.setCommand(aimLeftCommand);
		psFireButton.setCommand(fireMissileCommand);
		npsFireButton.setCommand(npsFireMissileCommand);
		hyperSpaceButton.setCommand(jumpHyperSpaceCommand);
		reloadButton.setCommand(reloadCommand);
		missileToAsteroidButton.setCommand(killAsteroidCommand);
		killNpsButton.setCommand(killNpsCommand);
		killPlayerNpsMissileButton.setCommand(killPlayerNpsMissileCommand);
		killPlayerAsteroidButton.setCommand(killPlayerAsteroidCommand);
		collisionPlayerNpsButton.setCommand(killPlayerNpsCommand);
		collisionAsteroidsButton.setCommand(asteroidCollisionCommand);
		collisionNpsAsteroidButton.setCommand(killNpsAsteroidCommand);
		tickClockButton.setCommand(tickClockCommand);
		quitButton.setCommand(quitGameCommand);
		
		/* Add buttons to control panel */
		controlPanel.add(soundCheck);
		controlPanel.add(addAsteroidButton);
		controlPanel.add(addNpsButton);
		controlPanel.add(addSpaceStationButton);
		controlPanel.add(addPlayerShipButton);
		controlPanel.add(accelerateButton);
		controlPanel.add(decelerateButton);
		controlPanel.add(leftTurnButton);
		controlPanel.add(rightTurnButton);
		controlPanel.add(aimLeftButton);
		controlPanel.add(aimRightButton);
		controlPanel.add(psFireButton);
		controlPanel.add(npsFireButton);
		controlPanel.add(hyperSpaceButton);
		controlPanel.add(reloadButton);
		controlPanel.add(missileToAsteroidButton);
		controlPanel.add(killNpsButton);
		controlPanel.add(killPlayerNpsMissileButton);
		controlPanel.add(killPlayerAsteroidButton);
		controlPanel.add(collisionPlayerNpsButton);
		controlPanel.add(collisionAsteroidsButton);
		controlPanel.add(collisionNpsAsteroidButton);
		controlPanel.add(tickClockButton);
		controlPanel.add(quitButton);

		/* Add commands to hamburger menu */
		spaceToolbar.addCommandToSideMenu(addAsteroidCommand);
		spaceToolbar.addCommandToSideMenu(addNpsCommand); 
		spaceToolbar.addCommandToSideMenu(addSpaceStationCommand);	
		spaceToolbar.addCommandToSideMenu(addPlayerShipCommand);
		spaceToolbar.addCommandToSideMenu(acceleratePlayerShipCommand);
		spaceToolbar.addCommandToSideMenu(deceleratePlayerShipCommand);
		spaceToolbar.addCommandToSideMenu(leftTurnCommand);	
		spaceToolbar.addCommandToSideMenu(rightTurnCommand);	
		spaceToolbar.addCommandToSideMenu(aimLeftCommand);
		spaceToolbar.addCommandToSideMenu(aimRightCommand);
		spaceToolbar.addCommandToSideMenu(fireMissileCommand);
		spaceToolbar.addCommandToSideMenu(npsFireMissileCommand);
		spaceToolbar.addCommandToSideMenu(jumpHyperSpaceCommand);
		spaceToolbar.addCommandToSideMenu(reloadCommand);
		spaceToolbar.addCommandToSideMenu(killAsteroidCommand);
		spaceToolbar.addCommandToSideMenu(killNpsCommand);
		spaceToolbar.addCommandToSideMenu(killPlayerNpsMissileCommand);
		spaceToolbar.addCommandToSideMenu(killPlayerAsteroidCommand);
		spaceToolbar.addCommandToSideMenu(killPlayerNpsCommand);
		spaceToolbar.addCommandToSideMenu(asteroidCollisionCommand);
		spaceToolbar.addCommandToSideMenu(killNpsAsteroidCommand);
		spaceToolbar.addCommandToSideMenu(tickClockCommand);
		spaceToolbar.addCommandToSideMenu(quitGameCommand);
		
		/* Key Listeners */
		addKeyListener(-91, acceleratePlayerShipCommand); // Increase ship speed.
		addKeyListener(-92, deceleratePlayerShipCommand); // Decrease ship speed.
		addKeyListener(-93, leftTurnCommand); // Turn ship left.
		addKeyListener(-94, rightTurnCommand); // Turn ship right.
		addKeyListener(-90, fireMissileCommand); // Player Ship fires missile.
		addKeyListener(44, aimLeftCommand); // Missile Launcher aim left.		
		addKeyListener(46, aimRightCommand); // Missile Launcher aim right.
		addKeyListener('j', jumpHyperSpaceCommand); // Jump through hyperspace.
		
		/* Add PointsView, control panel, and MapView to the form */
		this.add(BorderLayout.NORTH, pv);
		this.add(BorderLayout.WEST, controlPanel);
		this.add(BorderLayout.CENTER, mv);

		this.show(); // Show the form
				
		this.gw.setDimensions(mv.getWidth(), mv.getHeight()); // Set the dimension of the game world.
	
	}

		
	
}
