package com.mycompany.a2;

import java.util.Observer;
import java.util.Observable;

import com.codename1.charts.util.ColorUtil;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer {
	
	private GameWorldProxy gwp;
	
	private SpanLabel textMap;
	
	
	public MapView(GameWorldProxy gwp) {
		this.setLayout(new BoxLayout(BoxLayout.Y_AXIS)); // Set a box layout. 
		this.gwp = gwp;
		this.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
		
		this.textMap = new SpanLabel();
		
		/* Add text based map component to the container */
		this.add(this.textMap);
	}
	
	public void update (Observable o, Object arg) {
		this.gwp = (GameWorldProxy)o;
		this.textMap.setText(""+this.gwp);
		this.repaint();

		
	}
	
}
