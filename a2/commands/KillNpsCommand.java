
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class KillNpsCommand extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public KillNpsCommand(GameWorld gw) {
		super("Player Ship killed an NPS!");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.killNps();
		System.out.println("Player Ship killed an NPS!");
	}
}
