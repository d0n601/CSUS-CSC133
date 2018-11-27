package com.mycompany.a3;

import com.mycompany.a3.commands.*;

import java.util.Random;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.Toolbar;
import com.codename1.ui.util.UITimer;

public class Game extends Form implements Runnable {

	private GameWorld gw;
	private GameWorldProxy gwp;
	private MapView mv;
	private PointsView pv;
	private UITimer timer;
	private Random r;
	
	private Toolbar spaceToolbar;
	private Container controlPanel;
	private NewGameCommand newGameCommand;
	private PauseGameCommand pauseGameCommand;
	private SelectObjectCommand selectObjectCommand;
	private SaveCommand saveCommand;
	private UndoCommand undoCommand;
	private SoundCommand soundCommand;
	private AboutCommand aboutCommand;
	private QuitGameCommand quitGameCommand;
	private AddAsteroidCommand addAsteroidCommand;
	private AddNpsCommand addNpsCommand;
	private AddSpaceStationCommand addSpaceStationCommand;
	private AddPlayerShipCommand addPlayerShipCommand;
	private AcceleratePlayerShipCommand acceleratePlayerShipCommand;
	private DeceleratePlayerShipCommand deceleratePlayerShipCommand;
	private LeftTurnCommand leftTurnCommand;
	private RightTurnCommand rightTurnCommand;
	private AimLeftCommand aimLeftCommand;
	private AimRightCommand aimRightCommand;
	private PlayerFireMissileCommand fireMissileCommand;
	private NpsFireMissileCommand npsFireMissileCommand;
	private JumpHyperSpaceCommand jumpHyperSpaceCommand;
	private ReloadCommand reloadCommand;
	private CheckBox soundCheck;
	
	private SpaceButton addAsteroidButton; 
	private SpaceButton addNpsButton;
	private SpaceButton addSpaceStationButton;
	private SpaceButton addPlayerShipButton; 
	private SpaceButton accelerateButton;
	private SpaceButton decelerateButton; 
	private SpaceButton leftTurnButton;
	private SpaceButton rightTurnButton;
	private SpaceButton aimLeftButton; 
	private SpaceButton aimRightButton; 
	private SpaceButton psFireButton; 
	private SpaceButton npsFireButton; 
	private SpaceButton hyperSpaceButton;
	private SpaceButton reloadButton;
	private SpaceButton pauseButton;
	private SpaceButton quitButton;
	
	public static int CLOCK_MILISECONDS = 24;
	
	
	/**
	 * Constructs an instance of a Game, creates the
	 * Game World and initializes it, calls play.
	 * 
	 */
	public Game() {
		
		this.gw = new GameWorld(); // Create the Game World
		this.gwp = new GameWorldProxy(this.gw); // Create Game World Proxy, pass it Game World.
		
		this.mv = new MapView(this.gwp); // Create the Map View
		this.pv = new PointsView(this.gwp); // Create the Points View
				
		this.gw.addObserver(this.gwp); // Our Game World Proxy observes the game world.
		this.gwp.addObserver(this.mv); // Add the Map View as an observer of the Game World Proxy.
		this.gwp.addObserver(this.pv); // Add the Points as an observer of the Game World Proxy.
		
		this.timer = new UITimer(this);
		this.timer.schedule(CLOCK_MILISECONDS, true, this);
		
		this.setLayout(new BorderLayout()); // Set Border Layout for Game From	
		
		/* Code for Tool Bar */
		this.spaceToolbar = new Toolbar();
		this.setToolbar(this.spaceToolbar);
		this.spaceToolbar.setTitle("Asteroid Game (ver.a3)");

		
		/* Create Control Panel Container */
		this.controlPanel = new Container(new BoxLayout(BoxLayout.Y_AXIS)); 
		
		/* Toolbar's overflow menu commands*/
		this.newGameCommand = new NewGameCommand(this.gw); //New
		this.pauseGameCommand = new PauseGameCommand(this.gw);
		this.selectObjectCommand = new SelectObjectCommand(this.gw); // Select stuff.
		this.saveCommand = new SaveCommand(this.gw); //Save
		this.undoCommand = new UndoCommand(this.gw); //Undo
		this.soundCommand = new SoundCommand(this.gw); //Sound
		this.aboutCommand = new AboutCommand(this.gw); //About
		this.quitGameCommand = new QuitGameCommand(this.gw);//Quit
		

		/* Create all required commands for game play */
		this.addAsteroidCommand = new AddAsteroidCommand(this.gw);
		this.addNpsCommand = new AddNpsCommand(gw); 
		this.addSpaceStationCommand = new AddSpaceStationCommand(this.gw);
		this.addPlayerShipCommand = new AddPlayerShipCommand(this.gw);
		this.acceleratePlayerShipCommand = new AcceleratePlayerShipCommand(this.gw); 
		this.deceleratePlayerShipCommand = new DeceleratePlayerShipCommand(this.gw);
		this.leftTurnCommand = new LeftTurnCommand(this.gw); 
		this.rightTurnCommand = new RightTurnCommand(this.gw);
		this.aimLeftCommand = new AimLeftCommand(this.gw);
		this.aimRightCommand = new AimRightCommand(this.gw);
		this.fireMissileCommand = new PlayerFireMissileCommand(this.gw);
		this.npsFireMissileCommand = new NpsFireMissileCommand(this.gw);
		this.jumpHyperSpaceCommand = new JumpHyperSpaceCommand(this.gw);
		this.reloadCommand = new ReloadCommand(this.gw);
					
		/* Add commands to overflow menu */
		this.spaceToolbar.addCommandToOverflowMenu(this.newGameCommand);
		this.spaceToolbar.addCommandToOverflowMenu(this.saveCommand);
		this.spaceToolbar.addCommandToOverflowMenu(this.undoCommand);
		this.spaceToolbar.addCommandToOverflowMenu(this.aboutCommand);
		this.spaceToolbar.addCommandToOverflowMenu(this.quitGameCommand);
		
		/* Create buttons for commands */
		this.soundCheck = new CheckBox("Sound");
		this.soundCheck.setSelected(true);
		
		this.addAsteroidButton = new SpaceButton("Add Asteroid"); 
		this.addNpsButton = new SpaceButton("Add Non-Player Ship"); 
		this.addSpaceStationButton = new SpaceButton("Add Space Station");
		this.addPlayerShipButton = new SpaceButton("Add Player Ship"); 
		this.accelerateButton = new SpaceButton("Accelerate ");
		this.decelerateButton = new SpaceButton("Decelerate"); 
		this.leftTurnButton = new SpaceButton("Left Turn");
		this.rightTurnButton = new SpaceButton("Right Turn");
		this.aimLeftButton = new SpaceButton("Aim Left"); 
		this.aimRightButton = new SpaceButton("Aim Right"); 
		this.psFireButton = new SpaceButton("PS Fire Missile"); 
		this.npsFireButton = new SpaceButton("NPS Fire Missile"); 
		this.hyperSpaceButton = new SpaceButton("Hyperspace Jump");
		this.reloadButton = new SpaceButton("Reload Missiles");
		this.pauseButton = new SpaceButton("Pause Game");
		this.quitButton = new SpaceButton("Quit Game");

		/* Bind buttons to their associated commands */	
		this.soundCheck.setCommand(this.soundCommand);
		this.addAsteroidButton.setCommand(this.addAsteroidCommand);
		this.addNpsButton.setCommand(this.addNpsCommand);
		this.addSpaceStationButton.setCommand(this.addSpaceStationCommand);
		this.addPlayerShipButton.setCommand(this.addPlayerShipCommand);
		this.accelerateButton.setCommand(this.acceleratePlayerShipCommand);
		this.decelerateButton.setCommand(this.deceleratePlayerShipCommand);
		this.leftTurnButton.setCommand(this.leftTurnCommand);
		this.rightTurnButton.setCommand(this.rightTurnCommand);
		this.aimRightButton.setCommand(this.aimRightCommand);
		this.aimLeftButton.setCommand(this.aimLeftCommand);
		this.psFireButton.setCommand(this.fireMissileCommand);
		this.npsFireButton.setCommand(this.npsFireMissileCommand);
		this.hyperSpaceButton.setCommand(this.jumpHyperSpaceCommand);
		this.pauseButton.setCommand(this.pauseGameCommand);
		
		/* Add buttons to control panel */
		this.controlPanel.add(this.soundCheck);
		this.controlPanel.add(this.addAsteroidButton);
		this.controlPanel.add(this.addNpsButton);
		this.controlPanel.add(this.addSpaceStationButton);
		this.controlPanel.add(this.addPlayerShipButton);
		this.controlPanel.add(this.accelerateButton);
		this.controlPanel.add(this.decelerateButton);
		this.controlPanel.add(this.leftTurnButton);
		this.controlPanel.add(this.rightTurnButton);
		this.controlPanel.add(this.aimLeftButton);
		this.controlPanel.add(this.aimRightButton);
		this.controlPanel.add(this.psFireButton);
		this.controlPanel.add(this.npsFireButton);
		this.controlPanel.add(this.hyperSpaceButton);
		this.controlPanel.add(this.reloadButton);
		this.controlPanel.add(this.pauseButton);
		this.controlPanel.add(this.quitButton);

		/* Add commands to hamburger menu */
		this.spaceToolbar.addCommandToSideMenu(this.addAsteroidCommand);
		this.spaceToolbar.addCommandToSideMenu(this.addNpsCommand); 
		this.spaceToolbar.addCommandToSideMenu(this.addSpaceStationCommand);	
		this.spaceToolbar.addCommandToSideMenu(this.addPlayerShipCommand);
		this.spaceToolbar.addCommandToSideMenu(this.acceleratePlayerShipCommand);
		this.spaceToolbar.addCommandToSideMenu(this.deceleratePlayerShipCommand);
		this.spaceToolbar.addCommandToSideMenu(this.leftTurnCommand);	
		this.spaceToolbar.addCommandToSideMenu(this.rightTurnCommand);	
		this.spaceToolbar.addCommandToSideMenu(this.aimLeftCommand);
		this.spaceToolbar.addCommandToSideMenu(this.aimRightCommand);
		this.spaceToolbar.addCommandToSideMenu(this.fireMissileCommand);
		this.spaceToolbar.addCommandToSideMenu(this.npsFireMissileCommand);
		this.spaceToolbar.addCommandToSideMenu(this.jumpHyperSpaceCommand);
		this.spaceToolbar.addCommandToSideMenu(this.reloadCommand);
		this.spaceToolbar.addCommandToSideMenu(this.quitGameCommand);
		
		/* Key Listeners */
		addKeyListener(-91, this.acceleratePlayerShipCommand); // Increase ship speed.
		addKeyListener(-92, this.deceleratePlayerShipCommand); // Decrease ship speed.
		addKeyListener(-93, this.leftTurnCommand); // Turn ship left.
		addKeyListener(-94, this.rightTurnCommand); // Turn ship right.
		addKeyListener(-90, this.fireMissileCommand); // Player Ship fires missile.
		addKeyListener(44, this.aimLeftCommand); // Missile Launcher aim left.		
		addKeyListener(46, this.aimRightCommand); // Missile Launcher aim right.
		addKeyListener('j', this.jumpHyperSpaceCommand); // Jump through hyperspace.
		
		
		//PointerListener p = new PointerListener(this.gw);
		//this.addPlayerShipCommand.
		this.mv.addPointerPressedListener(this.selectObjectCommand);
		
		/* Add PointsView, control panel, and MapView to the form */
		this.add(BorderLayout.NORTH, this.pv);
		this.add(BorderLayout.WEST, this.controlPanel);
		this.add(BorderLayout.CENTER, this.mv);
		
		this.show(); // Show the form
		
		this.gw.setDimensions(this.mv.getWidth(), this.mv.getHeight()); // Set the dimension of the game world.
	}


	@Override
	public void run() {
		
		if(!this.gw.isPaused()) {
			
			this.gw.tickClock(); // Advance the game clock.
			
			this.gw.handleCollisions(); // Handle collisions.

			this.r = new Random();
			// .25% chance we'll add an NPS this cycle.
			if(this.r.nextInt(400) < 1 ) {
				this.gw.addNps();
			}
			// 2% chance we'll add an Asteroid.
			if(this.r.nextInt(100) < 2 ) {
				this.gw.addAsteroid();
			}			
		}
		
		
		
	}
	
	
}


