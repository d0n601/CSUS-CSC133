package com.mycompany.a3;

import java.util.Observer;
import java.util.Observable;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer {
	
	private IIterator gi;
	private GameWorldProxy gwp;
	private GameObjectCollection gameObjectCollection;

	
	public MapView(GameWorldProxy gwp) {
		this.gwp = gwp;
		this.gameObjectCollection = this.gwp.getCollection();
		this.gi = this.gameObjectCollection.getIterator();
		this.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
	}
	
	
	@Override 
	public void paint(Graphics g) {
		
		super.paint(g);
		while ( this.gi.hasNext() ) {
			GameObject go = this.gi.getNext();
			Point pCmpRelPrnt = new Point(this.getX(), this.getY());
			go.draw(g, pCmpRelPrnt);
		}
		
	}
	
	
	@Override
	public void update (Observable o, Object arg) {
		IGameWorld gw =  (IGameWorld) arg;
		this.gameObjectCollection = gw.getCollection();
		this.gi = this.gameObjectCollection.getIterator();
		this.repaint();		
	}
	
	
	
	
}
