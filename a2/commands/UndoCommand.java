package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class UndoCommand  extends Command {
	
	public UndoCommand(GameWorld gw) {
		super("Undo");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Undo Command Pressed!");

	}
}
