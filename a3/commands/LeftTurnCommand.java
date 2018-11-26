
package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class LeftTurnCommand extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public LeftTurnCommand(GameWorld gw) {
		super("Player Ship turned left.");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.playerShipLeft(); 
		System.out.println("Player Ship turned left.");
	}
}
