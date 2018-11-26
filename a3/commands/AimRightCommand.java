
package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class AimRightCommand extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public  AimRightCommand(GameWorld gw) {
		super("Missile Launcher Aimed Right.");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.playerLauncherRight();
		System.out.println("Missile Launcher Aimed Right.");
	}
}
