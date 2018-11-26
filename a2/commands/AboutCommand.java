package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AboutCommand  extends Command {
	
	public AboutCommand(GameWorld gw) {
		super("About");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("About Command Pressed!");
		Boolean bOk = Dialog.show("Asteroid Game (a2)", "Ryan Kozak (ryankozak@csus.edu)", "Close", null);
		if(bOk) {
			System.out.println("About window closed.");
		}	

	}
}
