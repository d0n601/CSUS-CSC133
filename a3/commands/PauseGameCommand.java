package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class PauseGameCommand  extends Command {
	
	private GameWorld gw; // Reference to a Game World.

	
	public PauseGameCommand(GameWorld gw) {
		super("Pause");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.gw.togglePaused();
		
		if(this.gw.isPaused()) {
			System.out.println("Game Paused.");
		}
		else {
			System.out.println("Game Resumed.");
		}
		
		

	}
}
