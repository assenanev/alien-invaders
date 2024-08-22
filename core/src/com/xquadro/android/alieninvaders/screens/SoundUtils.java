package com.xquadro.android.alieninvaders.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.xquadro.android.alieninvaders.settings.Settings2;

public class SoundUtils {

	public static void playSound(AssetManager manager, String soundName, float volume){
		if(Settings2.soundEnabled) {
			Sound sound = manager.get("data/sounds/"+soundName, Sound.class);
			sound.play(volume);
		}
	}
	
	public static void playSound(AssetManager manager, String soundName){
		if(Settings2.soundEnabled) {
			Sound sound = manager.get("data/sounds/"+soundName, Sound.class);
			sound.play(0.5f);
		}
	}
	
	public static void vibrate(){
		if(Settings2.vibrateEnabled) {
			Gdx.input.vibrate(20);		
		}
	}
	
	public static void vibrateLong(){
		if(Settings2.vibrateEnabled) {
			Gdx.input.vibrate(new long[] { 0, 20, 20, 20}, -1); 	
		}
	}
	
	public static void playMusic(AssetManager manager){
		if(Settings2.musicEnabled) {			
			Music music = manager.get("data/sounds/ambience1.ogg", Music.class);
			music.setVolume(1f);
			music.setLooping(true); 
			music.play();
		}
		
	}

	public static void toggleMusic(AssetManager manager){
		Music music = manager.get("data/sounds/ambience1.ogg", Music.class);
		
		if(Settings2.musicEnabled && !music.isPlaying() ){
			playMusic(manager);
		}
		
		if(!Settings2.musicEnabled && music.isPlaying() ){
			music.stop();
		}	
	}
}
