package com.mycompany.a3;

import java.util.Observer;
import java.util.Observable;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;

public class PointsView extends Container implements Observer {
	
	private GameWorldProxy gwp;

	private Label scoreLabel;
	private Label missileCountLabel;
	private Label clockLabel;
	private Label soundLabel;
	private Label lifeLabel;
	
	private String soundVal;
	
	
	
	public PointsView(IGameWorld gwp) {
		
		this.gwp = (GameWorldProxy)gwp;
		
		if(gwp.getSound()) {
			this.soundVal = "ON";
		}
		else {
			this.soundVal = "OFF";
		}
		
		this.setLayout(new FlowLayout()); // Set a box layout. 
		
		/* Initially create the labels and set them */
		this.scoreLabel = new Label("Score: " + this.gwp.getScore());
		this.missileCountLabel = new Label("Missile Count: " + this.gwp.getMissileCount());
		this.clockLabel = new Label("Elapsed Time: " + this.gwp.getClock());
		this.soundLabel = new Label("Sound: " + this.soundVal);
		this.lifeLabel = new Label("Lives: " + this.gwp.getLives());
		
		
		/* Add all components to the container */
		this.add(this.scoreLabel);
		this.add(this.missileCountLabel);
		this.add(this.clockLabel);
		this.add(this.soundLabel);
		this.add(this.lifeLabel);
				
	}
	
	public void update (Observable o, Object arg) {
	
		IGameWorld gw =  (IGameWorld) arg;
		
		if(gw.getSound()) {
			this.soundVal = "ON";
		}
		else {
			this.soundVal = "OFF";
		}					
		this.scoreLabel.setText("Score: " + gw.getScore());
		this.missileCountLabel.setText("Missile Count: " + gw.getMissileCount());
		this.clockLabel.setText("Elapsed Time: " + gw.getClock());
		this.soundLabel.setText("Sound: " + this.soundVal);
		this.lifeLabel.setText("Lives: " + gw.getLives());
		
		this.repaint();
	}
		
}
