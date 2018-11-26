package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class AcceleratePlayerShipCommand  extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public AcceleratePlayerShipCommand(GameWorld gw) {
		super("Player Ship Accelerated.");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.gw.iPlayerShipSpeed();
		System.out.println("Player Ship Accecelerated.");

	}
}
