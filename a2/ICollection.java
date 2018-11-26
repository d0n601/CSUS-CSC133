package com.mycompany.a2;

public interface ICollection {
	public void add(GameObject newGameObject);
	public void remove(GameObject gameObject);
	public IIterator getIterator();
}

