
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class NpsFireMissileCommand extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public NpsFireMissileCommand(GameWorld gw) {
		super("NPS Ship Fired Missile!");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.npsFireMissile();
		System.out.println("NPS Fired Missile!");
	}
}
