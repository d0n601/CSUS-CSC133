package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class SaveCommand  extends Command {
	
	public SaveCommand(GameWorld gw) {
		super("Save");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Save Game Command Pressed!");

	}
}
