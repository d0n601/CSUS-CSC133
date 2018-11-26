
package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class KillPlayerNpsMissileCommand extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public KillPlayerNpsMissileCommand(GameWorld gw) {
		super("NPS Missile hit Player Ship with!");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.killPlayerNpsMissile();
		System.out.println("NPS Missile hit Player Ship with!");
	}
}
