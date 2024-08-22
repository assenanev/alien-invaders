package com.xquadro.android.alieninvaders.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.xquadro.android.alieninvaders.controllers.IAdsController;
import com.xquadro.android.alieninvaders.levels.Levels;
import com.xquadro.android.alieninvaders.settings.Settings2;


public class AlienInvadersGame extends Game {
	public static final int VIRTUAL_WIDTH = 800;
	public static final int VIRTUAL_HEIGHT = 480;
	
	public static final float VIRTUAL_ASPECT = (float) VIRTUAL_WIDTH/VIRTUAL_HEIGHT;
	
	public int width, height, bgWigth, bgHeight;
	public float aspect;
	
	IAdsController adsController;
	
	public AssetManager assetManager;
	public Levels levels;
	
	public BitmapFont font28;
	public BitmapFont font22;
	public BitmapFont font19;
	float font28Height = 28;
	float font22Height = 22;
	float font19Height = 20;
	float fontScale = 1;
	
	public AlienInvadersGame(IAdsController adsController) {
    	super();
    	this.adsController = adsController;
    }
	
	@Override
	public void create() {
		calculateAspect();
		
		assetManager = new AssetManager();
		Settings2.load();
		levels = new Levels();
		Gdx.input.setCatchBackKey(true);

		setScreen(new LoadScreen(this));
	}
	
	@Override
	public void resume() {
		super.resume();
		calculateAspect();
	}

	public void calculateAspect(){
		aspect = (float) Gdx.graphics.getWidth()/Gdx.graphics.getHeight();
		if(aspect < VIRTUAL_ASPECT){
			width = VIRTUAL_WIDTH;
	        height = (int) (VIRTUAL_WIDTH / aspect);
	        fontScale = (float)Gdx.graphics.getWidth()/width;
		} else {
			width = (int) (VIRTUAL_HEIGHT * aspect);
	        height = VIRTUAL_HEIGHT;
	        fontScale = (float)Gdx.graphics.getHeight()/height;
		}
	}

	public IAdsController getAdsController() {
		return adsController;
	}

	@Override
	public void dispose() {
		super.dispose();
		getScreen().dispose();
		assetManager.clear();
		assetManager.dispose();
	}

	public void loadFonts() {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("data/fonts/arial.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = (int)Math.round(font28Height*fontScale);
		font28 = generator.generateFont(parameter); // font size 28 pixels
		font28.setScale(1/fontScale);
		font28.setUseIntegerPositions(false);
		font28.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		parameter.size = (int)Math.round(font22Height*fontScale);
		font22 = generator.generateFont(parameter);
		font22.setScale(1/fontScale);
		font22.setUseIntegerPositions(false);
		font22.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		parameter.size = (int)Math.round(font19Height*fontScale);
		font19 = generator.generateFont(parameter); 
		font19.setScale(1/fontScale);
		font19.setUseIntegerPositions(false);
		font19.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		generator.dispose(); // don't forget to dispose to avoid memory leaks!
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		super.resize(width, height);
		calculateAspect();
	}
}
