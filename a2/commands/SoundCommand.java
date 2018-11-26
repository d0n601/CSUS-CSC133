package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class SoundCommand  extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public SoundCommand(GameWorld gw) {
		super("Sound");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.gw.toggleSound();
		System.out.println("Toggle Sound");

	}
}
