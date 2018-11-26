
package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class JumpHyperSpaceCommand extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public JumpHyperSpaceCommand(GameWorld gw) {
		super("Jumped through Hyperspace!");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.jumpHyperSpace();
		System.out.println("Jumped through Hyperspace!");
	}
}
