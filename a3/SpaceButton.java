package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;


/**
 * Extends CN1's Buttons to add some style.
 * 
 *
 */
public class SpaceButton extends Button {	
	SpaceButton(String label) {
		super(label);
		this.getAllStyles().setPadding(3,2);
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBgColor(ColorUtil.BLUE);
		this.getAllStyles().setFgColor(ColorUtil.CYAN);
	}
}
