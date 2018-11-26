
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class KillAsteroidCommand extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public KillAsteroidCommand(GameWorld gw) {
		super("Player Ship killed an asteroid!");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.killAsteroid();
		System.out.println("Player Ship killed an asteroid!");
	}
}
