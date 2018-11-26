
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class TickClockCommand extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public TickClockCommand(GameWorld gw) {
		super("Game clock advanced.");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.tickClock();
		System.out.println("Clock advanced, new map below");
		System.out.println(gw);
	}
}
