package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class SaveCommand  extends Command {
	
	public SaveCommand(GameWorld gw) {
		super("Save");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Save Game Command Pressed!");

	}
}
