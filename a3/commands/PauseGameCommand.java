package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class PauseGameCommand  extends Command {
	
	public PauseGameCommand(GameWorld gw) {
		super("Pause");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Game Paused.");

	}
}
