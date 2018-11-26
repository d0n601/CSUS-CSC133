
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class ReloadCommand extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public ReloadCommand(GameWorld gw) {
		super("Player Ship Reloaded.");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.playerShipReload();
		System.out.println("Player Ship Reloaded.");
	}
}
