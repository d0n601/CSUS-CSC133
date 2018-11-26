package com.mycompany.a3;

public interface ICollection {
	public void add(GameObject newGameObject);
	public void remove(GameObject gameObject);
	public IIterator getIterator();
}

