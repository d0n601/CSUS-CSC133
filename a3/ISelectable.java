package com.mycompany.a3;

import com.codename1.ui.geom.Point;

public interface ISelectable {
	public Boolean contains(Point p);
	public void setSelected(Boolean select);
	public Boolean isSelected();
}