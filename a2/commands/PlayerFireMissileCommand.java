
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class PlayerFireMissileCommand extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public PlayerFireMissileCommand(GameWorld gw) {
		super("Player Ship Fired Missile!");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.playerFireMissile();
		System.out.println("Player Ship Fired Missile!");
	}
}
