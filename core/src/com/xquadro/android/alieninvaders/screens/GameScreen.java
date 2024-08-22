package com.xquadro.android.alieninvaders.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.xquadro.android.alieninvaders.levels.Level;
import com.xquadro.android.alieninvaders.settings.Player;
import com.xquadro.android.alieninvaders.world.RadarRenderer;
import com.xquadro.android.alieninvaders.world.World;
import com.xquadro.android.alieninvaders.world.World.WorldListener;
import com.xquadro.android.alieninvaders.world.WorldRenderer;

public class GameScreen implements Screen {
	
	enum State { RUNNING, PAUSED, ENDED }
	
	private final StringBuilder strBuilder = new StringBuilder(10); 
	
	AlienInvadersGame game;
	Level level;
	
	WorldListener worldListener;
	
	State state;
	float stateTime = 0;
	
	TextureAtlas atlas;
	
	int tpSize = 120;
	int tpPadding = 30;
	
	Stage stage;
	float actorsAlpha = 0.75f;
	Touchpad tpMove;
	Touchpad tpShoot; 
	ImageButton btnPause;
	ImageButton btnDock;
	ImageButton btnJump;
	ImageButton btnAutoFire;
	
	Slider sliderLife;
	
	Image imgRadarLeft;
	Image imgRadarCenter;
	Image imgRadarRight;
	Image gems;
	Label unobtanium;
	
	private float accumulator = 0;
	private final static float TICK = 1 / 60f;
	
	World world;
	WorldRenderer worldRenderer;
	RadarRenderer radarRenderer;
	SpriteBatch batcher;
	FPSLogger fpsLogger = new FPSLogger();
	
	public GameScreen (AlienInvadersGame alienInvadersGame, Level level) {
		this.game = alienInvadersGame;
		this.level = level;
		
		atlas = game.assetManager.get("data/atlases/ai.atlas", TextureAtlas.class);
		
		worldListener = new WorldListener() {

			@Override
			public void earthShot() {
				SoundUtils.playSound(game.assetManager, "weapon3.ogg", 0.2f);
			}

			@Override
			public void alienShot() {
//				SoundUtils.playSound(game.assetManager, "weapon3.ogg", 0.05f);
			}

			@Override
			public void earthHit() {
				SoundUtils.vibrate();
			}

			@Override
			public void alienHit() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void earthExplode() {
				// TODO Auto-generated method stub
				SoundUtils.playSound(game.assetManager, "boom1.ogg", 1f);
				SoundUtils.vibrateLong();
			}

			@Override
			public void alienExplode() {
				// TODO Auto-generated method stub
				SoundUtils.playSound(game.assetManager, "boom4.ogg", 1f);
			}

			@Override
			public void sweep() {
				SoundUtils.playSound(game.assetManager, "sweep.ogg", 1f);
			}

		};
		
		stage = new Stage(new StretchViewport(game.width, game.height));
		
		Gdx.input.setInputProcessor(new InputMultiplexer(stage,
				new InputAdapter() {
					@Override
					public boolean keyUp(int keycode) {
						if (keycode == Keys.BACK){
							SoundUtils.playSound(game.assetManager, "beep2.ogg");
							game.setScreen(new MainScreen(game));
						}
						return true;
					}
				}));

		setupUI();		
		
		batcher = new SpriteBatch();
		//world = World.getInstance();
		world = new World(worldListener, level, game.assetManager);
		worldRenderer = new WorldRenderer(world, batcher, game.assetManager);
		radarRenderer = new RadarRenderer(world, batcher, game.assetManager);
		
		state = State.RUNNING;
		stateTime = 0;
		
		game.getAdsController().prepareInterstitialAd();
	}
	
	private void setupUI(){
		imgRadarLeft = new Image(atlas.findRegion("bgRadarLeft"));
		imgRadarLeft.setSize(tpSize/2, tpSize);
		imgRadarLeft.setPosition(tpSize + tpPadding + tpSize/2, tpPadding);
		imgRadarLeft.setColor(1, 1, 1, actorsAlpha);
		stage.addActor(imgRadarLeft);
		
		imgRadarCenter = new Image(atlas.findRegion("bgRadarMiddle"));
		imgRadarCenter.setSize(game.width - tpPadding - tpSize - tpSize - tpSize - tpPadding - tpSize, tpSize);
		imgRadarCenter.setPosition(tpSize + tpPadding + tpSize, tpPadding);
		imgRadarCenter.setColor(1, 1, 1, actorsAlpha);
		stage.addActor(imgRadarCenter);
		
		imgRadarRight = new Image(atlas.findRegion("bgRadarRight"));
		imgRadarRight.setSize(tpSize/2, tpSize);
		imgRadarRight.setPosition(game.width - tpPadding - tpSize - tpSize/2 - tpSize/2, tpPadding);
		imgRadarRight.setColor(1, 1, 1, actorsAlpha);
		stage.addActor(imgRadarRight);
		
		SliderStyle sliderStyle = new SliderStyle();
		sliderStyle.background = new TextureRegionDrawable(atlas.findRegion("sliderbg"));
		sliderStyle.knobBefore = new TextureRegionDrawable(atlas.findRegion("sliderbf"));
		sliderStyle.knobAfter = new TextureRegionDrawable(atlas.findRegion("slideraf"));
		
		sliderLife = new Slider(0, 100, 1, false, sliderStyle);
		sliderLife.setSize(game.width - 2*tpPadding - 3*tpSize - tpSize/2, 4);
		sliderLife.setPosition(tpSize + tpPadding + tpSize/2 + tpSize/4, tpPadding + 5);
		sliderLife.setValue(80);
		sliderLife.setTouchable(Touchable.disabled);
		sliderLife.setColor(1, 1, 1, actorsAlpha);
		stage.addActor(sliderLife);

		//touchpad = new Touchpad(20, skin);
		tpMove = new Touchpad(1, new Touchpad.TouchpadStyle(new TextureRegionDrawable(atlas.findRegion("tpMove")),
				new TextureRegionDrawable(atlas.findRegion("knobMove"))));
		tpMove.setBounds(tpPadding, tpPadding, tpSize, tpSize);	
		tpMove.setColor(1, 1, 1, actorsAlpha);
		stage.addActor(tpMove);
		
		tpShoot = new Touchpad(1, new Touchpad.TouchpadStyle(new TextureRegionDrawable(atlas.findRegion("tpShoot")),
				new TextureRegionDrawable(atlas.findRegion("knobShoot"))));
		tpShoot.setBounds( game.width - tpPadding - tpSize, tpPadding, tpSize, tpSize);
		tpShoot.setColor(1, 1, 1, actorsAlpha);	
		tpShoot.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				world.earthShipAutoFire = false;
				btnAutoFire.setChecked(false);
			}

		});
		stage.addActor(tpShoot);
		
		ImageButtonStyle btnDockStyle = new ImageButtonStyle();
		btnDockStyle.imageUp = new TextureRegionDrawable(atlas.findRegion("btnDockUp"));
		btnDockStyle.imageDown = new TextureRegionDrawable(atlas.findRegion("btnDockDown"));
		btnDockStyle.imageDisabled = new TextureRegionDrawable(atlas.findRegion("btnDockDisabled"));
		
		btnDock = new ImageButton(btnDockStyle);
		btnDock.setPosition(tpSize + tpPadding, tpPadding);
		btnDock.setSize(tpSize/2, tpSize/2);
		btnDock.setColor(1, 1, 1, actorsAlpha);
		btnDock.setDisabled(true);
		btnDock.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				SoundUtils.playSound(game.assetManager, "beep1.ogg");
				game.setScreen(new ShopScreen(game));
			}

		});
		stage.addActor(btnDock);
		
		ImageButtonStyle btnJumpStyle = new ImageButtonStyle();
		btnJumpStyle.imageUp = new TextureRegionDrawable(atlas.findRegion("btnJumpUp"));
		btnJumpStyle.imageDown = new TextureRegionDrawable(atlas.findRegion("btnJumpDown"));
		btnJumpStyle.imageDisabled = new TextureRegionDrawable(atlas.findRegion("btnJumpDisabled"));
		
		
		btnJump = new ImageButton(btnJumpStyle);
		btnJump.setPosition(tpSize + tpPadding, tpPadding + tpSize/2);
		btnJump.setSize(tpSize/2, tpSize/2);
		btnJump.setColor(1, 1, 1, actorsAlpha);
		btnJump.setDisabled(true);
		btnJump.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				SoundUtils.playSound(game.assetManager, "beep1.ogg");
				game.setScreen(new NavigationScreen(game));
				//game.setScreen(new HyperjumpScreen(game, false, level));
			}

		});
		stage.addActor(btnJump);
		
		btnPause = new ImageButton(new TextureRegionDrawable(atlas.findRegion("btnPauseUp")),
				new TextureRegionDrawable(atlas.findRegion("btnPauseDown")),
				new TextureRegionDrawable(atlas.findRegion("btnPauseDown")));
		btnPause.setPosition( game.width - tpPadding - tpSize - tpSize/2, tpPadding + tpSize/2);
		btnPause.setSize(tpSize/2, tpSize/2);
		btnPause.setColor(1, 1, 1, actorsAlpha);
		btnPause.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				SoundUtils.playSound(game.assetManager, "beep2.ogg");
				if(state == State.RUNNING){
					state = State.PAUSED;
					stateTime = 0;		
					btnDock.setDisabled(true);
					btnJump.setDisabled(true);
				} else if (state == State.PAUSED) {
					state = State.RUNNING;
					stateTime = 0;
					updateUI();
				}
			}

		});
		stage.addActor(btnPause);
		
		btnAutoFire  = new ImageButton(new TextureRegionDrawable(atlas.findRegion("btnAutoFireUp")),
				new TextureRegionDrawable(atlas.findRegion("btnAutoFireDown")),
				new TextureRegionDrawable(atlas.findRegion("btnAutoFireDown")));
		btnAutoFire.setPosition( game.width - tpPadding - tpSize - tpSize/2, tpPadding);
		btnAutoFire.setSize(tpSize/2, tpSize/2);
		btnAutoFire.setColor(1, 1, 1, actorsAlpha);
		btnAutoFire.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				SoundUtils.playSound(game.assetManager, "beep2.ogg");
				world.earthShipAutoFire = !world.earthShipAutoFire;
				updateUI();

			}

		});
		stage.addActor(btnAutoFire);
		
		gems = new Image(atlas.findRegion("gems"));
		gems.setSize(tpSize/5, tpSize/5);
		gems.setPosition(game.width - gems.getWidth() - tpPadding , game.height - gems.getHeight() - tpPadding);
		gems.setColor(1, 1, 1, actorsAlpha);
		stage.addActor(gems);
		
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = game.font19;
		labelStyle.fontColor = new Color(0,1,1,actorsAlpha);
		
		unobtanium = new Label("", labelStyle);
		unobtanium.setAlignment(Align.right, Align.right);
		undateUnobtaniumLabel();
		stage.addActor(unobtanium);
	}
	
	public void updateWorld(float deltaTime, float knobPercentX, float knobPercentY,
			float weaponKnobPercentX, float weaponKnobPercentY,
			boolean weaponKnobIsTouched) {
		
		float dt = MathUtils.clamp(deltaTime, 0, 0.030f);
		accumulator += dt;
		while (accumulator > TICK) {
			accumulator -= TICK;
			world.update(TICK, knobPercentX, knobPercentY, weaponKnobPercentX,
					weaponKnobPercentY, weaponKnobIsTouched);
		}
	}
	
	public void draw (float deltaTime) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		worldRenderer.render(deltaTime);
		radarRenderer.render(deltaTime);	
		stage.draw();
	}

	@Override
	public void render(float deltaTime) {
		stateTime += deltaTime;
		switch (state) {
		case RUNNING:
			updateRunning(deltaTime);
			draw(deltaTime);
			break;
		case PAUSED:
			updatePaused(deltaTime);
			draw(deltaTime);
			break;
		case ENDED:
//			world.clear();
//			world = new World(worldListener, game.levels.getLevels().get(0), game.assetManager);
//			state = State.RUNNING;
//			stateTime = 0;
			game.setScreen(new GameScreen(game, game.levels.getLevels().get(0)));
			break;
		default:
			break;
		}
//		fpsLogger.log();
	}
	
	private void updateRunning(float deltaTime) {
		stage.act(Gdx.graphics.getDeltaTime());
		updateWorld(deltaTime, tpMove.getKnobPercentX(), tpMove.getKnobPercentY(), tpShoot.getKnobPercentX(), tpShoot.getKnobPercentY(), tpShoot.isTouched());
		updateUI();
		
		if(world.state == World.State.ENDED){
			game.levels.loseLevel();
			state = State.ENDED;
			stateTime = 0;
		}
	}
	
	private void updateUI(){
		sliderLife.setValue(((float) world.ship.hitPoints*100)/world.ship.hitPointsMax);
		btnDock.setDisabled(!world.stationProximity);
		btnJump.setDisabled(!world.vortexProximity);
		undateUnobtaniumLabel();
	}

	private void updatePaused(float deltaTime) {
		stage.act(Gdx.graphics.getDeltaTime());
	}

	void undateUnobtaniumLabel(){
		strBuilder.setLength(0);
	    strBuilder.append(Player.getInstance().getUnobtanium());
	    unobtanium.setText(strBuilder);
		unobtanium.setPosition(gems.getX() - unobtanium.getWidth() - tpPadding/3,
				gems.getY() + (gems.getHeight() - unobtanium.getHeight())/2);
	}

	@Override
	public void resize(int width, int height) {
	
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		Player.getInstance().saveUnobtanium();
		Player.getInstance().setShipHealth(world.ship.shipClass, world.ship.hitPoints);
		
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
		// TODO Auto-generated method stub
		world.clear();
		stage.dispose();
		batcher.dispose();
	}
	
}
