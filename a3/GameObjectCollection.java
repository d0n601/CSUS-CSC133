package com.mycompany.a3;

import java.util.Vector;

public class GameObjectCollection implements ICollection {

	private Vector<GameObject> gameObjectCollection ;
	
	public GameObjectCollection() {
		
		gameObjectCollection = new Vector<GameObject>();  
		
	}
	
	public void add(GameObject newGameObject) {
		gameObjectCollection.addElement(newGameObject); 
	}
	
	public void remove(GameObject gameObject) {
		if(gameObjectCollection.contains(gameObject)) {
			gameObjectCollection.removeElement(gameObject);
		}
	}
	
	public IIterator getIterator() {
		return new GameObjectIterator () ;  
	}
	
	
	private class GameObjectIterator implements IIterator {
		
		private int currElementIndex;
		
		public GameObjectIterator() {
			currElementIndex = -1;
		}
		
		public boolean hasNext() {
			if (gameObjectCollection.size ( ) <= 0) {
				return false;
			}
			if (currElementIndex == gameObjectCollection.size() - 1 ) {
				return false;
			}
			return true;
		}
		public GameObject getNext ( ) {
				currElementIndex ++ ;
				return(gameObjectCollection.elementAt(currElementIndex));
		}
	}
	
}
