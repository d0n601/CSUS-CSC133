package com.mycompany.a1;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

public class Game extends Form {

	private GameWorld gw;
	
	
	/**
	 * Constructs an instance of a Game, creates the
	 * Game World and initializes it, calls play.
	 * 
	 */
	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}

	
	/**
	 * Game Loop for user input and game actions.
	 * 
	 */
	private void play() {
		
		Label myLabel=new Label("Enter a Command:"); this.addComponent(myLabel);
		
		final TextField myTextField=new TextField();
		
		this.addComponent(myTextField);
		
		this.show();
		
		myTextField.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				
				String sCommand=myTextField.getText().toString();
				
				myTextField.clear();
				
				switch (sCommand.charAt(0)){
					case 'a':
						gw.addAsteroid(); //add new asteroid to the game world.
						break;
					case 'y':
						gw.addNPS(); //add new NPS to the game world.
						break;
					case 'b':
						gw.addSpaceStation(); //add new blinking space station to the game world.
						break;		
					case 's':
						gw.addPlayerShip(); //attempt to add player ship to the game world.
						break;
					case 'i':
						gw.iPlayerShipSpeed(); //increase speed of player ship by small amount (not above 10).
						break;
					case 'd':
						gw.dPlayerShipSpeed(); //decrease speed of player ship by small amount (not below 0).
						break;
					case 'l':
						gw.playerShipLeft(); //turn the player ship counter-clockwise by small amount.
						break;	
					case 'r':
						gw.playerShipRight(); //turn the player ship clockwise by small amount.
						break;	
					case '<':
						gw.playerLauncherLeft(); //turn the player ship's missile launcher counter-clockwise by small amount.
						break;	
					case '>':
						gw.playerLauncherRight(); //turn the player ship's missile launcher clockwise by small amount.
						break;	
					case 'f':
						gw.playerFireMissile(); //fire a missile out of the front of the ship.
						break;	
					case 'L':
						gw.npsFireMissile(); //launch a missile out of the front of an NPS.
						break;	
					case 'j':
						gw.jumpHyperSpace();//jump the player ship through hyper-space back to the middle of the screen.
						break;	
					case 'n':
						gw.playerShipReload(); //load a new supply of missiles onto the player's ship.
						break;	
					case 'k':
						gw.killAsteroid(); //kill an asteroid, remove a missile that's hit an asteroid, and the asteroid. Bump the score up.
						break;
					case 'e':
						gw.killNps(); //kill an NPS, remove a missile that's hit an NPS, and the NPS. Bump the score up 2X.
						break;
					case 'E':
						gw.killPlayerNpsMissile(); //NPS, has hit the player's ship with missile, remove the missile and remove a life!
						break;
					case 'c':
						gw.killPlayerAsteroid(); //player's ship, has crashed into an asteroid, remove both of them and a life!
						break;
					case 'h':
						gw.killPlayerNps(); //player's ship, has crashed into an NPS, remove both of them and a life!
						break;
					case 'x':
						gw.killAsteroids(); //two asteroids have collided and destroyed each other, remove them both!
						break;
					case 'I':
						gw.killNpsAsteroid(); //an asteroid has collided with an NPS, remove them both!
						break;
					case 't':
						gw.tickClock(); //tell the game world that the “game clock” has ticked. 
						break;
					case 'p':
						gw.printDisplay(); //print the heads up display, lives, clock, missile count, and score.
						break;
					case 'm':
						gw.printMap(); //print the text based representation of the map.
						break;
					case 'q':
						gw.quitGame(); //confirm the user’s intent to quit before exiting, then exit.
						break;
					default : 
					    System.out.println("Unknown Command");
					    break;
				} 
			} 
			
		});
	} 
	
	
}
