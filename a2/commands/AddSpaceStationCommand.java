
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AddSpaceStationCommand extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public AddSpaceStationCommand(GameWorld gw) {
		super("Add Blinking Space Station.");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.gw.addSpaceStation();
		System.out.println("Add Blinking Space Station.");
	}
}
