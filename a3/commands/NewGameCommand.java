package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class NewGameCommand  extends Command {
	
	public NewGameCommand(GameWorld gw) {
		super("New");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("New Game Command Pressed!");

	}
}
