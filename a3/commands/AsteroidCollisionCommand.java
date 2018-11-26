
package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class AsteroidCollisionCommand extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public AsteroidCollisionCommand(GameWorld gw) {
		super("Two asteroids have collided.");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.killAsteroids();
		System.out.println("Two asteroids have collided.");
	}
}
