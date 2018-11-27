package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Point;
import com.mycompany.a3.GameObject;
import com.mycompany.a3.Asteroid;
import com.mycompany.a3.Missile;
import com.mycompany.a3.GameObjectCollection;
import com.mycompany.a3.GameWorld;
import com.mycompany.a3.IIterator;
import com.mycompany.a3.ISelectable;
import com.mycompany.a3.MapView;

public class SelectObjectCommand extends Command {
	
	private GameWorld gw; // Reference to a Game World.
	private GameObjectCollection gc; 
	private IIterator gi;
	
	public SelectObjectCommand(GameWorld gw) {
		super("Select Object");
		this.gw = gw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(this.gw.isPaused() && e.getSource() instanceof MapView) {
						
			int x = ((MapView)e.getSource()).getParent().getAbsoluteX() + e.getX(); //MAYBE WRONG
		    int y = ((MapView)e.getSource()).getParent().getAbsoluteY() + e.getY(); //MAYBE WRONG
		    
		    Point pPtrRelPrnt = new Point(x, y);
						
			this.gc = this.gw.getCollection();
			this.gi = this.gc.getIterator();
				
			while(this.gi.hasNext()) {
				
				GameObject go = this.gi.getNext();
				
				if(go instanceof Asteroid) {
					if(((Asteroid)go).contains(pPtrRelPrnt)) {
						System.out.println("You clicked an Asteroid?");
						this.gw.selectObject((ISelectable)go, true);
					}
					else {
						this.gw.selectObject((ISelectable)go, false);
					}
				}
				
			}
		
			
		}
		
		else {
			System.out.println("Error: Game must be paused to select objects.");
		}
			
	}
	
	
	
}
