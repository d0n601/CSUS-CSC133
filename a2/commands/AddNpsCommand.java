
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AddNpsCommand extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public AddNpsCommand(GameWorld gw) {
		super("Add Non-Player Ship.");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.addNps();
		System.out.println("Add Non-Player Ship.");
	}
}
