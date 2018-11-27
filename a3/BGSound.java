package com.mycompany.a3;

import java.io.InputStream;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class BGSound implements Runnable {

	private Media m;
	
	public BGSound(String fileName) {
		try {
			InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/"+fileName);
			this.m = MediaManager.createMedia(is, "audio/wav", this);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Pause background music.
	 * 
	 */
	public void pause() {
		this.m.pause();
	}
	
	
	/**
	 * Play background music.
	 * 
	 */
	public void play() {
		this.m.play();
	}
	

	@Override
	public void run() {
		this.m.setTime(0);
		this.m.play();
		
	}
	
}
