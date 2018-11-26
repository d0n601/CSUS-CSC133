
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class KillNpsAsteroidCommand extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public KillNpsAsteroidCommand(GameWorld gw) {
		super("NPS has hit an asteroid!");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.killNpsAsteroid();
		System.out.println("NPS has hit an asteroid!");
	}
}
