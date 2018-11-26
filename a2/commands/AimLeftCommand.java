
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AimLeftCommand extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public  AimLeftCommand(GameWorld gw) {
		super("Missile Launcher Aimed Left.");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.playerLauncherLeft();
		System.out.println("Missile Launcher Aimed Left.");
	}
}
