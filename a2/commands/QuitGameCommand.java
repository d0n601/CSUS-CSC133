
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class QuitGameCommand extends Command {

	private GameWorld gw; // Reference to a Game World.
	
	public QuitGameCommand(GameWorld gw) {
		super("Quit");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Quit Command Pressed!");
		Boolean bOk = Dialog.show("Confirm quit", "Are you sure you want to quit?", "Ok", "Cancel");
		if(bOk) {
			gw.quitGame();
			System.out.println("Quit Game.");
		}	
	}
}
