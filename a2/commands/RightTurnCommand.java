
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class RightTurnCommand extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public RightTurnCommand(GameWorld gw) {
		super("Player Ship turned right.");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.playerShipRight(); 
		System.out.println("Player Ship turned right.");
	}
}
