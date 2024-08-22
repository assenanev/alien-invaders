package com.xquadro.android.alieninvaders.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.xquadro.android.alieninvaders.settings.Player;
import com.xquadro.android.alieninvaders.settings.Settings2;

public class MainScreen extends AbstractScreen {

	public static TextureAtlas atlas;
	
	ImageButton btnSound;
	ImageButton btnMusic;
	ImageButton btnVibrate;
	
	ImageButton btnPlay;
	ImageButton btnTutorial;
	ImageButton btnSettings;
	
	float btnSize = 125;	
	float btnBorderYOffset = 5f;
	float btnBorderXOffset = 10f;
	float btnOffset = 35f;
	
	boolean showSettings = false;

	public MainScreen(AlienInvadersGame alienInvadersGame) {
		super(alienInvadersGame, "data/blueplanet.png");
		
		atlas = game.assetManager.get("data/atlases/ai.atlas", TextureAtlas.class);
        
        btnSound = new ImageButton(new TextureRegionDrawable(atlas.findRegion("btnSoundUp")),
        		new TextureRegionDrawable(atlas.findRegion("btnSoundDown")), 
        		new TextureRegionDrawable(atlas.findRegion("btnSoundChecked")));
        btnSound.setPosition(game.width - btnSize * 3 - btnBorderXOffset + 2 * btnOffset, 
        		btnBorderYOffset + btnSize + btnOffset + btnOffset);     
        btnSound.setSize(btnSize, btnSize);
        btnSound.setChecked(Settings2.soundEnabled);
        btnSound.setVisible(showSettings);
        btnSound.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Settings2.soundEnabled = btnSound.isChecked();		
				Settings2.save();	
				SoundUtils.playSound(game.assetManager, "beep2.ogg");
			}		        
		});
        stage.addActor(btnSound);  
        
        btnMusic  = new ImageButton(new TextureRegionDrawable(atlas.findRegion("btnMusicUp")),
        		new TextureRegionDrawable(atlas.findRegion("btnMusicDown")), 
        		new TextureRegionDrawable(atlas.findRegion("btnMusicChecked")));
        btnMusic.setPosition(game.width - btnSize * 2 - btnBorderXOffset + btnOffset,
        		btnBorderYOffset + btnSize + btnOffset);
        btnMusic.setSize(btnSize, btnSize);
        btnMusic.setChecked(Settings2.musicEnabled);
        btnMusic.setVisible(showSettings);
        btnMusic.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Settings2.musicEnabled = btnMusic.isChecked();		
				Settings2.save();
				SoundUtils.toggleMusic(game.assetManager);
				SoundUtils.playSound(game.assetManager, "beep2.ogg");
			}		        
		});
        stage.addActor(btnMusic);

        btnVibrate = new ImageButton(new TextureRegionDrawable(atlas.findRegion("btnVibrateUp")),
        		new TextureRegionDrawable(atlas.findRegion("btnVibrateDown")), 
        		new TextureRegionDrawable(atlas.findRegion("btnVibrateChecked")));
        btnVibrate.setPosition(game.width - btnSize - btnBorderXOffset, 
        		btnBorderYOffset + btnSize + btnOffset + btnOffset);
        btnVibrate.setSize(btnSize, btnSize);
        btnVibrate.setChecked(Settings2.vibrateEnabled);
        btnVibrate.setVisible(showSettings);
        btnVibrate.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Settings2.vibrateEnabled = btnVibrate.isChecked();		
				Settings2.save();		
				SoundUtils.playSound(game.assetManager, "beep2.ogg");
			}		        
		});
        stage.addActor(btnVibrate); 
        
        btnTutorial = new ImageButton(new TextureRegionDrawable(atlas.findRegion("btnTutorialUp")),
				new TextureRegionDrawable(atlas.findRegion("btnTutorialDown")));
		btnTutorial.setPosition(game.width - btnSize - btnBorderXOffset, btnBorderYOffset);
		btnTutorial.setSize(btnSize, btnSize);
		btnTutorial.addListener(new ChangeListener() {

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				//game.setScreen(new HelpScreen(game));	
				//SoundUtils.playSound(game.assetManager, "click.ogg");
				//game.setScreen(new HyperjumpScreen(game, false));
				game.setScreen(new TutorialScreen1(game));
				SoundUtils.playSound(game.assetManager, "beep2.ogg");
			}
		        
		});
		stage.addActor(btnTutorial);
        
		btnSettings = new ImageButton(new TextureRegionDrawable(atlas.findRegion("btnSettingsUp")),
				new TextureRegionDrawable(atlas.findRegion("btnSettingsDown")),
				new TextureRegionDrawable(atlas.findRegion("btnSettingsDown")));
		
		btnSettings.setPosition(game.width - btnSize * 2 - btnBorderXOffset + btnOffset, btnBorderYOffset + btnOffset);
		btnSettings.setSize(btnSize, btnSize);
		btnSettings.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				showSettings = !showSettings;
				btnSound.setVisible(showSettings);
				btnMusic.setVisible(showSettings);
				btnVibrate.setVisible(showSettings);
				SoundUtils.playSound(game.assetManager, "beep2.ogg");
			}		        
		});
        stage.addActor(btnSettings);
        
        btnPlay = new ImageButton(new TextureRegionDrawable(atlas.findRegion("btnPlayUp")),
        		new TextureRegionDrawable(atlas.findRegion("btnPlayDown")));
        btnPlay.setPosition(game.width - btnSize * 3 - btnBorderXOffset + 2 * btnOffset, btnBorderYOffset);
        btnPlay.setSize(btnSize, btnSize);
        btnPlay.addListener(new ChangeListener() {

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if(Player.getInstance().isTutorialShown()){
					game.setScreen(new GameScreen(game, game.levels.getLevels().get(0)));
				} else {
					game.setScreen(new TutorialScreen1(game));
				}
				
				SoundUtils.playSound(game.assetManager, "beep2.ogg");
			}
		        
		});
        stage.addActor(btnPlay);
	}

	@Override
	void goToPrevScreen() {
		Gdx.app.exit();		
	}
}
