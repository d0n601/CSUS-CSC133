
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class KillPlayerAsteroidCommand extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public KillPlayerAsteroidCommand(GameWorld gw) {
		super("Player Ship has hit an asteroid!");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.killPlayerAsteroid();
		System.out.println("Player Ship has hit an asteroid!");
	}
}
