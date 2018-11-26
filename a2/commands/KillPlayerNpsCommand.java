
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class KillPlayerNpsCommand extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public KillPlayerNpsCommand(GameWorld gw) {
		super("Player Ship has hit an NPS!");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.killPlayerNps();
		System.out.println("Player Ship has hit an NPS!");
	}
}
