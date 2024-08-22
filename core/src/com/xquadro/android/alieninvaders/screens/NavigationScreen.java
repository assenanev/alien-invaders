package com.xquadro.android.alieninvaders.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.List.ListStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.xquadro.android.alieninvaders.levels.Level;
import com.xquadro.android.alieninvaders.settings.Player;

public class NavigationScreen extends AbstractScreen {
	
	String[] listEntries1 = {

			"Alien Kamikazes: 0",
			"Alien Fighters: 0",
			"Alien Corvettes: 0",
			"Alien Destroyers: 0",
			"Alien Frigates: 0"};
	String[] listEntries2 = {
			"Alien Light Cruiser: 0",
			"Alien Heavy Cruiser: 0",
			"Alien Battle Cruiser: 0",
			"Alien Battle Ship: 0",
			"Alien Dreadnoughts: 0"};
	
	Label star;

	
	public static TextureAtlas atlas;
	AlienInvadersGame game;
	
	Window jumpDialog;
	
	Level activeLevel;
	private List<String> list1;
	private List<String> list2;

	public NavigationScreen (AlienInvadersGame alienInvadersGame) {
		super(alienInvadersGame, "data/spiral.png");
		this.game = alienInvadersGame;
		atlas = game.assetManager.get("data/atlases/ai.atlas", TextureAtlas.class);
		activeLevel = game.levels.getLevels().get(0);

		ImageButtonStyle btnLevelStyle = new ImageButtonStyle();
		btnLevelStyle.up = new TextureRegionDrawable(atlas.findRegion("btnLevel"));
		
		NinePatch patch = new NinePatch(atlas.createPatch("window15xt85"));

		int count = game.levels.getLevels().size;
		for (int i = 0; i < count; i++){
			Level l = game.levels.getLevels().get(i);
			ImageButton btnLevel;
			btnLevel = new ImageButton(btnLevelStyle);
			if(l.isEarth()){
				btnLevel.setColor(0, 1, 0, 1);
			} else {
				
				if(Player.getInstance().isLevelAlien(l)){
					switch (l.getDifficulty()) {
					case EASY:
						btnLevel.setColor(1, 0.6f, 0, 1);
						break;
					case MEDIUM:
						btnLevel.setColor(1, 0.3f, 0, 1);
						break;
					case HARD:
						btnLevel.setColor(1, 0, 0, 1);
						break;
					default:
						break;
					}
				} else {
					btnLevel.setColor(0, 0f, 1, 1);
				}
			}
			
			int btnSize = 30;
			btnLevel.setSize(btnSize, btnSize);
			btnLevel.setPosition(game.width*l.getPositionX() - btnSize/2, game.height*l.getPositionY() - btnSize/2);
			btnLevel.setName(""+i);
			btnLevel.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					activeLevel = game.levels.getLevels().get(Integer.parseInt(actor.getName()));
					if(Player.getInstance().isLevelAlien(activeLevel)){
						listEntries1[0] = "Alien Kamikazes: " + activeLevel.getCountAlienKamikaze();
						listEntries1[1] = "Alien Fighters: " + activeLevel.getCountAlienFighter();
						listEntries1[2] = "Alien Corvettes: " + activeLevel.getCountAlienCorvette() ;
						listEntries1[3] = "Alien Destroyers: " + activeLevel.getCountAlienDestroyer();
						listEntries1[4] = "Alien Frigates: " + activeLevel.getCountAlienFrigate();
						list1.setItems(listEntries1);
						
						listEntries2[0] = "Alien Light Cruiser: " + activeLevel.getCountAlienLightCruiser();
						listEntries2[1] = "Alien Heavy Cruiser: " + activeLevel.getCountAlienHeavyCruiser();
						listEntries2[2] = "Alien Battle Cruiser: " + activeLevel.getCountAlienBattleCruiser() ;
						listEntries2[3] = "Alien Battle Ship: " + activeLevel.getCountAlienBattleShip();
						listEntries2[4] = "Alien Dreadnoughts: " + activeLevel.getCountAlienDreadnought();
						list2.setItems(listEntries2);
					} else {
						listEntries1[0] = "Alien Kamikazes: 0";
						listEntries1[1] = "Alien Fighters: 0";
						listEntries1[2] = "Alien Corvettes: 0";
						listEntries1[3] = "Alien Destroyers: 0";
						listEntries1[4] = "Alien Frigates: 0";
						list1.setItems(listEntries1);
						
						listEntries2[0] = "Alien Light Cruiser: 0";
						listEntries2[1] = "Alien Heavy Cruiser: 0";
						listEntries2[2] = "Alien Battle Cruiser: 0";
						listEntries2[3] = "Alien Battle Ship: 0";
						listEntries2[4] = "Alien Dreadnoughts: 0";
						list2.setItems(listEntries2);
					}
					star.setText("Star: " + activeLevel.getName());
					
					jumpDialog.setVisible(true);
					SoundUtils.playSound(game.assetManager, "beep2.ogg");
				}      
			});
			stage.addActor(btnLevel);
		}
		

		ImageButton btnBack = new ImageButton(new TextureRegionDrawable(atlas.findRegion("btnBackUp")),
        		new TextureRegionDrawable(atlas.findRegion("btnBackDown")));
		btnBack.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				SoundUtils.playSound(game.assetManager, "beep2.ogg");
				activeLevel = game.levels.getLevels().get(0);
				jumpDialog.setVisible(false);
			}
		        
		});
		
		ImageButton btnJumpB = new ImageButton(new TextureRegionDrawable(atlas.findRegion("btnJumpBUp")),
        		new TextureRegionDrawable(atlas.findRegion("btnJumpBDown")));

		btnJumpB.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				SoundUtils.playSound(game.assetManager, "beep2.ogg");	
				//game.setScreen(new HyperjumpScreen(game, true, activeLevel));
				game.getAdsController().showInterstitialAd(new Runnable() {
					@Override
					public void run() {
						game.setScreen(new HyperjumpScreen(game, true, activeLevel));
					}
				});
				
			}
		        
		});
		
		
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = game.font28;
		//labelStyle.fontColor = new Color(0.8f, 1f, 1f, 1f);

		star = new Label("Star: ", labelStyle);
		
		ListStyle listStyle = new ListStyle();
		listStyle.font = game.font19;
		//listStyle.fontColorSelected = new Color(0.8f, 1f, 1f, 1f);
		//listStyle.fontColorUnselected = new Color(0.8f, 1f, 1f, 1f);
		listStyle.selection = new TextureRegionDrawable(atlas.findRegion("select"));;
	
		list1 = new List<String>(listStyle);
		list1.setItems(listEntries1);
		list2 = new List<String>(listStyle);
		list2.setItems(listEntries2);
        
		WindowStyle wStyle = new WindowStyle();
		wStyle.titleFont = new BitmapFont();
		wStyle.titleFontColor = new Color();
		wStyle.background = new NinePatchDrawable(patch);

		float dialogPadding = 50;
		jumpDialog = new Window("Dialog", wStyle);
		jumpDialog.setSize(game.width - 2*dialogPadding, game.height - 2*dialogPadding);
		jumpDialog.setPosition(dialogPadding, dialogPadding);
		jumpDialog.setModal(true);
		jumpDialog.setVisible(false);
		jumpDialog.row();
		jumpDialog.add(star).expandY().colspan(2);
		jumpDialog.row();
		jumpDialog.add(list1).expand();
		jumpDialog.add(list2).expand();
		jumpDialog.row();
		jumpDialog.add(btnBack).width(100).height(100).bottom().left();
		jumpDialog.add(btnJumpB).width(100).height(100).bottom().right();
		
		stage.addActor(jumpDialog);
		
	}

	@Override
	void goToPrevScreen() {
		if (jumpDialog.isVisible()){
			activeLevel = game.levels.getLevels().get(0);
			jumpDialog.setVisible(false);
		} else {
			game.setScreen(new MainScreen(game));
		}
		
	}

}
