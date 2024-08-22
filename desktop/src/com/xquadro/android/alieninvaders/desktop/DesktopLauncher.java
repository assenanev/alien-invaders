package com.xquadro.android.alieninvaders.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.xquadro.android.alieninvaders.controllers.IAdsController;
import com.xquadro.android.alieninvaders.screens.AlienInvadersGame;

public class DesktopLauncher implements IAdsController {
	private static DesktopLauncher application;


	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "alien-invaders";
		cfg.width = 800;
		cfg.height = 480;
//		cfg.height = 1080;
//		cfg.width = 1920;

		
		TexturePacker.Settings settings = new TexturePacker.Settings();
		settings.maxWidth = 1024;
		settings.maxHeight = 1024;
		settings.filterMin = TextureFilter.Linear;
		settings.filterMag = TextureFilter.Linear;
		settings.paddingX = 2;
		settings.paddingY = 2;
		settings.duplicatePadding = true;
		settings.flattenPaths = true;
		TexturePacker.process(settings, "images", "../android/assets/data/atlases", "ai");
		
		settings.maxWidth = 1024;
		settings.maxHeight = 1024;
		settings.filterMin = TextureFilter.Linear;
		settings.filterMag = TextureFilter.Linear;
		settings.paddingX = 0;
		settings.paddingY = 0;
		settings.flattenPaths = true;
		TexturePacker.process(settings, "images2", "../android/assets/data/atlases", "hyper");
		
		
		new LwjglApplication(new AlienInvadersGame(application), cfg);
	}

	@Override
	public void showBannerAd(boolean show) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prepareInterstitialAd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showInterstitialAd(Runnable then) {
		// TODO Auto-generated method stub
		
	}
}