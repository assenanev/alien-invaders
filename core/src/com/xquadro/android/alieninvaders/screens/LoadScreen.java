package com.xquadro.android.alieninvaders.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class LoadScreen implements Screen {
	
	private AlienInvadersGame alienInvadersGame;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private static Texture splashTexture;
	public static Texture bg;
	public static TextureRegion bgRegion;
	
	private int  bgWigth, bgHeight;
	private float splashAspect;
	private int splashWidth, splashHeight;
	private float activeTime;
	private float minActiveTime = 1.5f;
	AssetManager manager;

	public LoadScreen(AlienInvadersGame game) {
		super();
		this.alienInvadersGame = game;
		
		if(alienInvadersGame.width >  alienInvadersGame.height) {
			bgWigth = 1024;
			bgHeight = (int) (bgWigth / alienInvadersGame.aspect);
		} else {
			bgHeight = 1024;
			bgWigth = (int) (bgHeight * alienInvadersGame.aspect);
		}
		
		manager = game.assetManager;
		
		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override
			public boolean keyUp(int keycode) {
				if (keycode == Keys.BACK){
					Gdx.app.exit();
				}
				return true;
			}
		});
		
		TextureParameter param = new TextureParameter();
		param.minFilter = TextureFilter.Linear;
		param.magFilter = TextureFilter.Linear;

		manager.load("data/blueplanet.png", Texture.class, param);
		manager.load("data/stars.png", Texture.class, param);
		manager.load("data/spiral.png", Texture.class, param);
		manager.load("data/atlases/ai.atlas", TextureAtlas.class);
		manager.load("data/atlases/hyper.atlas", TextureAtlas.class);

		manager.load("data/sounds/sweep.ogg", Sound.class);

		manager.load("data/sounds/laser1.ogg", Sound.class);

		
		manager.load("data/sounds/beep1.ogg", Sound.class);
		manager.load("data/sounds/beep2.ogg", Sound.class);

		manager.load("data/sounds/boom1.ogg", Sound.class);
		manager.load("data/sounds/boom4.ogg", Sound.class);
		manager.load("data/sounds/weapon3.ogg", Sound.class);

		manager.load("data/sounds/ambience1.ogg", Music.class);

		manager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
		manager.load("data/tiles/stars250.tmx", TiledMap.class);
//		Texture.setAssetManager(manager);

		batch = new SpriteBatch();
		camera = new OrthographicCamera(alienInvadersGame.width, alienInvadersGame.height);
		camera.position.set(alienInvadersGame.width / 2, alienInvadersGame.height / 2, 0);
		
		splashTexture = new Texture(Gdx.files.internal("data/splash.png"));
		splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		splashAspect = (float) splashTexture.getWidth()/splashTexture.getHeight();
		splashWidth = (int) (alienInvadersGame.width * 0.9f);
		splashHeight = (int) (splashWidth / splashAspect);
		activeTime = 0;
		
		bg = new Texture(Gdx.files.internal("data/stars.png"));

		bg.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		bgRegion = new TextureRegion(bg, 0, (1024-bgHeight)/2, bgWigth, bgHeight);
		
	}

	@Override
	public void render(float delta) {
		activeTime += delta;
		
		if(manager.update() && activeTime > minActiveTime){
			alienInvadersGame.levels.loadLevels();
			alienInvadersGame.loadFonts();
			SoundUtils.playMusic(manager);
			alienInvadersGame.setScreen(new MainScreen(alienInvadersGame));
		}
		
		GL20 gl = Gdx.gl;

		gl.glClearColor(0f, 0f, 0.15f, 1f);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		batch.draw(bgRegion, 0, 0, alienInvadersGame.width, alienInvadersGame.height);
		batch.setColor(1f, 1f, 1f, 0.7f);
		batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE);
		batch.draw(splashTexture, alienInvadersGame.width/2 - splashWidth/2, alienInvadersGame.height/2 - splashHeight/2 + alienInvadersGame.height/30, splashWidth, splashHeight);
		batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		batch.dispose();		
	}

}
