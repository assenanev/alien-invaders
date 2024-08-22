package com.xquadro.android.alieninvaders.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
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
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.List.ListStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.xquadro.android.alieninvaders.settings.Player;
import com.xquadro.android.alieninvaders.world.RadarRenderer;
import com.xquadro.android.alieninvaders.world.TutorialWorld;
import com.xquadro.android.alieninvaders.world.TutorialWorldRenderer;
import com.xquadro.android.alieninvaders.world.World.WorldListener;

public class TutorialScreen1 implements Screen {
	
	enum TutorialState {INTRO1, INTRO2, INTRO3, INTRO4, INTRO5, INTRO6,
		ENGINE, WEAPON, RADAR1, RADAR2, DOCK1, DOCK2, JUMP;
		
		public TutorialState getNext() {
	     return this.ordinal() < TutorialState.values().length - 1
	         ? TutorialState.values()[this.ordinal() + 1]
	         : null;
	   }
	}
	
	String[] listEntries1 = {
			"",
			""};
	
	String textIntro1a = "By year 2232 the human race inhabited more than 50 planets";
	String textIntro1b = "in the Milky Way galaxy.";
	
	String textIntro2a = "However, in 2245 we encountered a hostile alien race.";
	String textIntro2b = "";
	
	String textIntro3a = "The aliens destroyed several earth trade vessels ";
	String textIntro3b = "and stole our hyper-drive technology.";
	
	String textIntro4a = "Despite human resistance in the next decade the aliens conquered";
	String textIntro4b = "all human worlds with the exception of the planet Earth.";
	
	String textIntro5a = "You are Earth's last hope to stop the aliens and free ";
	String textIntro5b = "again all human worlds.";
	
	String textIntro6a = "Now it's time to learn how to navigate your ship.";
	String textIntro6b = "";	 
	
	String textIntro7a = "Engine controls";
	String textIntro7b = "(in green color)";
	
	String textIntro8a = "Weapon systems";
	String textIntro8b = "(in green color)";
	
	String textIntro9a = "Radar and navigation systems";
	String textIntro9b = "(in green color)";
	
	String textIntro10a = "On the radar your ship is a light-blue dot. ";
	String textIntro10b = "Enemies are red dots.";
	
	String textIntro11a = "The Space station is a violet dot on the radar. You can dock if you";
	String textIntro11b = "are near the station using the Dock button (in green color).";
	
	String textIntro12a = "There is only one Space station and it is";
	String textIntro12b = "located in the Sun system.";
	
	String textIntro13a = "The yellow dot on the radar is a wormhole. You can perform hyper-jump";
	String textIntro13b = "if you are close to the wormhole using the Hyperjump button.";
	
	private final StringBuilder strBuilder = new StringBuilder(10); 
	
	AlienInvadersGame game;
	
	WorldListener worldListener;

	TutorialState tutorialState;
	float tutorialStateTime = 0;
	
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
	
	Image arrowtpMove;
	Image arrowtpShoot;
	Image arrowbtnDock;
	Image arrowbtnJump;
	Image arrowRadar;
	Image arrowVortex;
	Image arrowStation;
	
	
	Window helpDialog;
	
	Slider sliderLife;
	
	Image imgRadarLeft;
	Image imgRadarCenter;
	Image imgRadarRight;
	Image gems;
	Label unobtanium;
	
	private float accumulator = 0;
	private final static float TICK = 1 / 60f;
	
	TutorialWorld world;
	TutorialWorldRenderer worldRenderer;
	RadarRenderer radarRenderer;
	SpriteBatch batcher;
	FPSLogger fpsLogger = new FPSLogger();

	private List<String> list1;
	
	public TutorialScreen1 (AlienInvadersGame alienInvadersGame) {
		this.game = alienInvadersGame;
		tutorialState = TutorialState.INTRO1;		
		tutorialStateTime = 0;
		
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
		world = new TutorialWorld(worldListener, game.assetManager);
		worldRenderer = new TutorialWorldRenderer(world, batcher, game.assetManager);
		radarRenderer = new RadarRenderer(world, batcher, game.assetManager);
		
		
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
		stage.addActor(tpShoot);
		
		ImageButtonStyle btnDockStyle = new ImageButtonStyle();
		btnDockStyle.up = new TextureRegionDrawable(atlas.findRegion("btnDockUp"));
		btnDockStyle.down = new TextureRegionDrawable(atlas.findRegion("btnDockDown"));
		btnDockStyle.disabled = new TextureRegionDrawable(atlas.findRegion("btnDockDisabled"));
		
		btnDock = new ImageButton(btnDockStyle);
		btnDock.setColor(1, 1f, 1f,actorsAlpha);
		btnDock.setPosition(tpSize + tpPadding, tpPadding);
		btnDock.setSize(tpSize/2, tpSize/2);
		btnDock.setDisabled(true);
		btnDock.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
			}

		});
		stage.addActor(btnDock);
		
		ImageButtonStyle btnJumpStyle = new ImageButtonStyle();
		btnJumpStyle.up = new TextureRegionDrawable(atlas.findRegion("btnJumpUp"));
		btnJumpStyle.down = new TextureRegionDrawable(atlas.findRegion("btnJumpDown"));
		btnJumpStyle.disabled = new TextureRegionDrawable(atlas.findRegion("btnJumpDisabled"));
		
		
		btnJump = new ImageButton(btnJumpStyle);
		btnJump.setPosition(tpSize + tpPadding, tpPadding + tpSize/2);
		btnJump.setSize(tpSize/2, tpSize/2);
		btnJump.setColor(1, 1, 1, actorsAlpha);
		btnJump.setDisabled(true);
		btnJump.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
			}

		});
		stage.addActor(btnJump);
		
		btnPause = new ImageButton(new TextureRegionDrawable(atlas.findRegion("btnPauseUp")),
				new TextureRegionDrawable(atlas.findRegion("btnPauseDown")));
		btnPause.setPosition( game.width - tpPadding - tpSize - tpSize/2, tpPadding + tpSize/2);
		btnPause.setSize(tpSize/2, tpSize/2);
		btnPause.setColor(1, 1, 1, actorsAlpha);
		btnPause.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
			}

		});
		stage.addActor(btnPause);
		
		btnAutoFire  = new ImageButton(new TextureRegionDrawable(atlas.findRegion("btnAutoFireUp")),
				new TextureRegionDrawable(atlas.findRegion("btnAutoFireDown")),
				new TextureRegionDrawable(atlas.findRegion("btnAutoFireDown")));
		btnAutoFire.setPosition( game.width - tpPadding - tpSize - tpSize/2, tpPadding);
		btnAutoFire.setSize(tpSize/2, tpSize/2);
		btnAutoFire.setColor(1, 1, 1, actorsAlpha);
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
		
		Color arrowColor = new Color(1, 0.2f, 0.2f, 0.8f);
		
		arrowtpMove = new Image(new TextureRegionDrawable(atlas.findRegion("arrow")));
		arrowtpMove.setSize(100, 50);
		arrowtpMove.setOrigin(50, 25);
		arrowtpMove.setRotation(235);
		arrowtpMove.setColor(arrowColor);
		arrowtpMove.setVisible(false);
		arrowtpMove.setPosition(tpMove.getX() + arrowtpMove.getWidth()/2-12, 
				tpMove.getY()+ arrowtpMove.getHeight()/2 + 50);
		stage.addActor(arrowtpMove);
		
		arrowtpShoot = new Image(new TextureRegionDrawable(atlas.findRegion("arrow")));
		arrowtpShoot.setSize(100, 50);
		arrowtpShoot.setOrigin(50, 25);
		arrowtpShoot.setRotation(315);
		arrowtpShoot.setColor(arrowColor);
		arrowtpShoot.setVisible(false);
		arrowtpShoot.setPosition(tpShoot.getX() + arrowtpShoot.getWidth()/2-80, 
				tpShoot.getY()+ arrowtpShoot.getHeight()/2 + 50);
		stage.addActor(arrowtpShoot);
		
		arrowRadar = new Image(new TextureRegionDrawable(atlas.findRegion("arrow")));
		arrowRadar.setSize(100, 50);
		arrowRadar.setOrigin(50, 25);
		arrowRadar.setRotation(235);
		arrowRadar.setColor(arrowColor);
		arrowRadar.setVisible(false);
		arrowRadar.setPosition(imgRadarCenter.getX() + imgRadarCenter.getWidth()/2 -17, 
				imgRadarCenter.getY() + imgRadarCenter.getHeight()/2+17);
		stage.addActor(arrowRadar);
		
		arrowbtnDock = new Image(new TextureRegionDrawable(atlas.findRegion("arrow")));
		arrowbtnDock.setSize(100, 50);
		arrowbtnDock.setOrigin(50, 25);
		arrowbtnDock.setRotation(235);
		arrowbtnDock.setColor(arrowColor);
		arrowbtnDock.setVisible(false);
		arrowbtnDock.setPosition(btnDock.getX() + btnDock.getWidth()/2 -19, 
				btnDock.getY() + btnDock.getHeight()/2+15);
		stage.addActor(arrowbtnDock);
		
		arrowStation = new Image(new TextureRegionDrawable(atlas.findRegion("arrow")));
		arrowStation.setSize(100, 50);
		arrowStation.setColor(arrowColor);
		arrowStation.setVisible(false);
		arrowStation.setPosition(game.width/2 -300, 
				game.height/2 - arrowStation.getHeight()/2);
		stage.addActor(arrowStation);
		
		arrowbtnJump = new Image(new TextureRegionDrawable(atlas.findRegion("arrow")));
		arrowbtnJump.setSize(100, 50);
		arrowbtnJump.setOrigin(50, 25);
		arrowbtnJump.setRotation(235);
		arrowbtnJump.setColor(arrowColor);
		arrowbtnJump.setVisible(false);
		arrowbtnJump.setPosition(btnJump.getX() + btnJump.getWidth()/2 -19, 
				btnJump.getY() + btnJump.getHeight()/2+18);
		stage.addActor(arrowbtnJump);
		
		arrowVortex = new Image(new TextureRegionDrawable(atlas.findRegion("arrow")));
		arrowVortex.setSize(100, 50);
		arrowVortex.setColor(arrowColor);
		arrowVortex.setVisible(false);
		arrowVortex.setPosition(game.width/2 + 250, 
				game.height/2 - arrowVortex.getHeight()/2);
		stage.addActor(arrowVortex);

		ListStyle listStyle = new ListStyle();
		listStyle.font = game.font19;
		//listStyle.fontColorSelected = new Color(0.8f, 1f, 1f, 1f);
		//listStyle.fontColorUnselected = new Color(0.8f, 1f, 1f, 1f);
		listStyle.selection = new TextureRegionDrawable(atlas.findRegion("select"));;
	
		list1 = new List<String>(listStyle);
		list1.setItems(listEntries1);

		NinePatch patch1 = new NinePatch(atlas.createPatch("window20xt10"));
		Color color = new Color(1, 1, 1, 0.75f);
		patch1.setColor(color);
		WindowStyle wStyle = new WindowStyle();
		wStyle.titleFont = new BitmapFont();
		wStyle.titleFontColor = new Color();
		wStyle.background = new NinePatchDrawable(patch1);
		
		ImageButtonStyle btnHelpNextStyle = new ImageButtonStyle();
		btnHelpNextStyle.up = new TextureRegionDrawable(atlas.findRegion("btnNextUp"));
		btnHelpNextStyle.down = new TextureRegionDrawable(atlas.findRegion("btnNextDown"));
		
		ImageButton btnHelpNext = new ImageButton(btnHelpNextStyle);
		btnHelpNext.setColor(1,1f,0f,1);
		btnHelpNext.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				tutorialState = tutorialState.getNext();
				SoundUtils.playSound(game.assetManager, "beep2.ogg");
				if (tutorialState == null){
					Player.getInstance().setTutorialShown();
					game.setScreen(new GameScreen(game, game.levels.getLevels().get(0)));
				
				} else {
					setTutorialState(tutorialState);
				}
				
			}

		});

		helpDialog = new Window("Help", wStyle);
		helpDialog.setSize(game.width - 2*tpPadding, tpSize);
		helpDialog.setPosition(tpPadding, game.height/2 + 40);
		helpDialog.row();
		helpDialog.add(list1).expand().left();
		helpDialog.add(btnHelpNext).width(tpSize/2).height(tpSize/2);
		setTutorialState(tutorialState);
		stage.addActor(helpDialog);
	}

	void setTutorialState(TutorialState tutorialState){
		switch (tutorialState) {
		
		case INTRO1:
			resetColors();
			listEntries1[0] = textIntro1a;
			listEntries1[1] = textIntro1b;
			list1.setItems(listEntries1);
			break;
		case INTRO2:
			resetColors();
			listEntries1[0] = textIntro2a;
			listEntries1[1] = textIntro2b;
			list1.setItems(listEntries1);
			break;
		case INTRO3:
			resetColors();
			listEntries1[0] = textIntro3a;
			listEntries1[1] = textIntro3b;
			list1.setItems(listEntries1);
			break;
		case INTRO4:
			resetColors();
			listEntries1[0] = textIntro4a;
			listEntries1[1] = textIntro4b;
			list1.setItems(listEntries1);
			break;
		case INTRO5:
			resetColors();
			listEntries1[0] = textIntro5a;
			listEntries1[1] = textIntro5b;
			list1.setItems(listEntries1);
			break;
		case INTRO6:
			resetColors();
			listEntries1[0] = textIntro6a;
			listEntries1[1] = textIntro6b;
			list1.setItems(listEntries1);
			break;
		case ENGINE:
			resetColors();
			listEntries1[0] = textIntro7a;
			listEntries1[1] = textIntro7b;
			list1.setItems(listEntries1);
			arrowtpMove.setVisible(true);
			tpMove.setColor(1,1f,0f,1);
			break;
		case WEAPON:
			resetColors();
			listEntries1[0] = textIntro8a;
			listEntries1[1] = textIntro8b;
			list1.setItems(listEntries1);
			arrowtpShoot.setVisible(true);
			tpShoot.setColor(1,1f,0f,1);
			break;
		case RADAR1:
			resetColors();
			listEntries1[0] = textIntro9a;
			listEntries1[1] = textIntro9b;
			list1.setItems(listEntries1);
			arrowRadar.setVisible(true);
			imgRadarLeft.setColor(1,1f,0f,1);
			imgRadarRight.setColor(1,1f,0f,1);
			imgRadarCenter.setColor(1,1f,0f,1);
			break;
		case RADAR2:
			resetColors();
			listEntries1[0] = textIntro10a;
			listEntries1[1] = textIntro10b;
			list1.setItems(listEntries1);
			arrowRadar.setVisible(true);
			imgRadarLeft.setColor(1,1f,0f,1);
			imgRadarRight.setColor(1,1f,0f,1);
			imgRadarCenter.setColor(1,1f,0f,1);
			break;
		case DOCK1:
			resetColors();
			listEntries1[0] = textIntro11a;
			listEntries1[1] = textIntro11b;
			list1.setItems(listEntries1);
			arrowbtnDock.setVisible(true);
			arrowStation.setVisible(true);
			btnDock.setColor(1,1f,0f,1);
			worldRenderer.changeStationColor = true;
			break;
		case DOCK2:
			resetColors();
			listEntries1[0] = textIntro12a;
			listEntries1[1] = textIntro12b;
			list1.setItems(listEntries1);
			arrowbtnDock.setVisible(true);
			arrowStation.setVisible(true);
			btnDock.setColor(1,1f,0f,1);
			worldRenderer.changeStationColor = true;
			break;
		case JUMP:
			resetColors();
			listEntries1[0] = textIntro13a;
			listEntries1[1] = textIntro13b;
			list1.setItems(listEntries1);
			arrowbtnJump.setVisible(true);
			arrowVortex.setVisible(true);
			btnJump.setColor(1,1f,0f,1);
			worldRenderer.changeVortexColor = true;
			break;
		default:
			break;
		}
	}
	
	void resetColors(){
		tpMove.setColor(1, 1, 1, actorsAlpha);
		tpShoot.setColor(1, 1, 1, actorsAlpha);
		imgRadarLeft.setColor(1,1f,1f,1);
		imgRadarRight.setColor(1,1f,1f,1);
		imgRadarCenter.setColor(1,1f,1f,1);
		btnDock.setColor(1,1f,1f,1);
		btnJump.setColor(1,1f,1f,1);
		arrowtpMove.setVisible(false);
		arrowtpShoot.setVisible(false);
		arrowRadar.setVisible(false);
		arrowbtnDock.setVisible(false);
		arrowStation.setVisible(false);
		arrowbtnJump.setVisible(false);
		arrowVortex.setVisible(false);
		if(worldRenderer != null){
			worldRenderer.changeStationColor = false;
			worldRenderer.changeVortexColor = false;
		}
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
		tutorialStateTime += deltaTime;
		updateRunning(deltaTime);
		draw(deltaTime);
	}
	
	private void updateRunning(float deltaTime) {
		stage.act(Gdx.graphics.getDeltaTime());
		updateWorld(deltaTime, tpMove.getKnobPercentX(), tpMove.getKnobPercentY(), tpShoot.getKnobPercentX(), tpShoot.getKnobPercentY(), tpShoot.isTouched());
		updateUI();
	}
	
	private void updateUI(){
		sliderLife.setValue(((float) world.ship.hitPoints*100)/world.ship.hitPointsMax);
		btnDock.setDisabled(!world.stationProximity);
		btnJump.setDisabled(!world.vortexProximity);
		undateUnobtaniumLabel();
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
		world.clear();
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
		
		stage.dispose();
		batcher.dispose();
	}
	
}
