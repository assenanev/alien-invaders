package com.xquadro.android.alieninvaders.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
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
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.xquadro.android.alieninvaders.settings.Player;
import com.xquadro.android.alieninvaders.ships.Ship;
import com.xquadro.android.alieninvaders.ships.Ship.ShipClass;
import com.xquadro.android.alieninvaders.ships.earthships.EarthBattleShip;
import com.xquadro.android.alieninvaders.ships.earthships.EarthShipUtils;
import com.xquadro.android.alieninvaders.ships.weapons.Turret.Type;
import com.xquadro.android.alieninvaders.world.WorldRenderer;


public class ShipDataScreen extends AbstractScreen {	
	String[] listEntries1 = {
			"Class: ",
			"Shield: ",
			"Acceleration: ",
			"Speed: ",
			"Laser cannons: ",
			"Plasma Blasters: ",
			"Machine Guns: ",
			"",
			"Price: "};

	public static TextureAtlas atlas;
	
	ShipClass shipClass;
	
	Image gems;
	Label unobtanium;

	ImageButton btnUnlock;
	ImageButton btnEquip;
	ImageButton btnRepair;
	
	Slider sliderHealth;
	Image iconLock;

	ImageButton btnBack;
	
	float shipImgBGSize = 150;
	float screenPadding = 50;

	public ShipDataScreen(AlienInvadersGame alienInvadersGame, ShipClass screenShipClass) {
		super(alienInvadersGame, "data/blueplanet.png");
		
		this.shipClass = screenShipClass;
		atlas = game.assetManager.get("data/atlases/ai.atlas", TextureAtlas.class);
		
		NinePatch patch = new NinePatch(atlas.createPatch("window20xt85"));
		
		SliderStyle sliderStyle = new SliderStyle();
		sliderStyle.background = new TextureRegionDrawable(
				atlas.findRegion("sliderbg"));
		sliderStyle.knobBefore = new TextureRegionDrawable(
				atlas.findRegion("sliderbf"));
		sliderStyle.knobAfter = new TextureRegionDrawable(
				atlas.findRegion("slideraf"));

		Group group = new Group();
		group.setSize(game.width - 2*screenPadding, game.height - 2*screenPadding);
		group.setPosition(screenPadding, screenPadding);
		
		Image bg1 = new Image(patch);
		bg1.setSize(shipImgBGSize, shipImgBGSize);
		bg1.setPosition(0, group.getHeight() - shipImgBGSize);
		group.addActor(bg1);
		
		Image shipIcon = new Image(atlas.findRegion(WorldRenderer.getEarthShipRegionName(shipClass)));
		shipIcon.setSize(shipImgBGSize * 0.8f * EarthShipUtils.getShipWidth(shipClass)/EarthBattleShip.WIDTH,
				shipImgBGSize * 0.8f * EarthShipUtils.getShipHeight(shipClass)/EarthBattleShip.WIDTH);
		shipIcon.setPosition((shipImgBGSize - shipImgBGSize * 0.8f * EarthShipUtils.getShipWidth(shipClass)/EarthBattleShip.WIDTH) / 2, 
				group.getHeight() - shipImgBGSize + (shipImgBGSize - shipImgBGSize * 0.8f * EarthShipUtils.getShipHeight(shipClass)/EarthBattleShip.WIDTH)/2);
		group.addActor(shipIcon);
		
		iconLock = new Image(atlas.findRegion("iconLock"));
		iconLock.setSize(shipImgBGSize / 7.5f, shipImgBGSize / 7.5f);
		iconLock.setPosition(
				bg1.getX() + bg1.getWidth() - iconLock.getWidth()
						- shipImgBGSize / 8, bg1.getY() + shipImgBGSize / 8);
		iconLock.setColor(1, 1, 1, 0.5f);
		iconLock.setVisible(false);
		group.addActor(iconLock);

		Image bg2 = new Image(patch);
		bg2.setSize(group.getWidth() - shipImgBGSize - screenPadding, group.getHeight());
		bg2.setPosition(shipImgBGSize + screenPadding, 0);
		group.addActor(bg2);
		
		listEntries1[0] = "Class: " + Ship.getShipClassName(shipClass);
		listEntries1[1] = "Shield: " + EarthShipUtils.getShipMaxHitPoints(shipClass);
		listEntries1[2] = "Acceleration: " + EarthShipUtils.getShipMaxAccel(shipClass);
		listEntries1[3] = "Speed: " + EarthShipUtils.getShipMaxSpeed(shipClass);
		listEntries1[4] = "Laser cannons: " + EarthShipUtils.getTurretCount(shipClass, Type.LASER_CANNON);
		listEntries1[5] = "Plasma Blasters: " + EarthShipUtils.getTurretCount(shipClass, Type.PLASMA_BLASTER);
		listEntries1[6] = "Machine Guns: " + EarthShipUtils.getTurretCount(shipClass, Type.MACHINE_GUN);
		listEntries1[7] = "";
		listEntries1[8] = "Price: " + EarthShipUtils.getShipPrice(screenShipClass);
		ListStyle listStyle = new ListStyle();
		listStyle.font = game.font22;
		listStyle.selection = new TextureRegionDrawable(atlas.findRegion("select"));;

		List<String> list1 = new List<String>(listStyle);
		list1.setItems(listEntries1);
		
		list1.setPosition(bg2.getX() + screenPadding-10, 
				bg2.getY() + bg2.getHeight() - list1.getHeight() - screenPadding +10);
		group.addActor(list1);
		

		sliderHealth = new Slider(0, 100, 1, false, sliderStyle);
		sliderHealth.setSize(bg1.getWidth() - 40, 4);
		sliderHealth.setPosition(bg1.getX() + (bg1.getWidth() - sliderHealth.getWidth())/2,
				bg1.getY() - sliderHealth.getHeight() - screenPadding / 3);
		sliderHealth.setValue(80);
		sliderHealth.setTouchable(Touchable.disabled);
		sliderHealth.setColor(1, 1, 1, 0.5f);
		group.addActor(sliderHealth);

		float btnSize = 60;
		float btnBorderYOffset = 20f;
		float btnBorderXOffset = 20f;
		float btnOffset = 10f;
		
		ImageButtonStyle btnUnlockStyle = new ImageButtonStyle();
		btnUnlockStyle.imageUp = new TextureRegionDrawable(atlas.findRegion("btnUnlockUp"));
		btnUnlockStyle.imageDown = new TextureRegionDrawable(atlas.findRegion("btnUnlockDown"));
		btnUnlockStyle.imageDisabled = new TextureRegionDrawable(atlas.findRegion("btnUnlockDisabled"));
		
		btnUnlock = new ImageButton(btnUnlockStyle);
		btnUnlock.setSize(btnSize, btnSize);
		btnUnlock.setPosition(group.getWidth() - btnSize * 3 - btnBorderXOffset + 2 * btnOffset, btnBorderYOffset);
		btnUnlock.setDisabled(true);
		btnUnlock.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Player.getInstance().unlockClass(shipClass);
				Player.getInstance().setActiveShip(shipClass);
				updateUI();
				SoundUtils.playSound(game.assetManager, "beep2.ogg");
			}
		        
		});		
		group.addActor(btnUnlock);
		
		ImageButtonStyle btnRepairStyle = new ImageButtonStyle();
		btnRepairStyle.imageUp = new TextureRegionDrawable(atlas.findRegion("btnRepairUp"));
		btnRepairStyle.imageDown = new TextureRegionDrawable(atlas.findRegion("btnRepairDown"));
		btnRepairStyle.imageDisabled = new TextureRegionDrawable(atlas.findRegion("btnRepairDisabled"));

		btnRepair = new ImageButton(btnRepairStyle);
		btnRepair.setSize(btnSize, btnSize);
		btnRepair.setPosition(group.getWidth() - btnSize * 2 - btnBorderXOffset + btnOffset, btnBorderYOffset + 2*btnOffset);
		btnRepair.setDisabled(true);
		btnRepair.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Player p = Player.getInstance();
				int unobtanium = p.getUnobtanium();
				float hitPoints = p.getShipHealth(shipClass);
				float maxHitPoints = EarthShipUtils
						.getShipMaxHitPoints(shipClass);
				float price = EarthShipUtils.getShipPrice(shipClass);
				float damageRatio = (maxHitPoints - hitPoints)
						/ maxHitPoints;
				float repairCost = damageRatio * price;

				if (unobtanium >= repairCost) {
					p.setShipHealth(shipClass,
							EarthShipUtils.getShipMaxHitPoints(shipClass));
					p.takeUnobtanium((int) repairCost);
					p.saveUnobtanium();
				} else {
					float repairRatio = unobtanium / repairCost;
					float healthToAdd = hitPoints
							+ (maxHitPoints - hitPoints) * repairRatio;
					p.setShipHealth(shipClass, (int) healthToAdd);
					p.takeUnobtanium(unobtanium);
					p.saveUnobtanium();
				}
				updateUI();
				SoundUtils.playSound(game.assetManager, "beep2.ogg");
			}
		        
		});		
		group.addActor(btnRepair);
		
		ImageButtonStyle btnEquipStyle = new ImageButtonStyle();
		btnEquipStyle.imageUp = new TextureRegionDrawable(atlas.findRegion("btnEquipUp"));
		btnEquipStyle.imageDown = new TextureRegionDrawable(atlas.findRegion("btnEquipDown"));
		btnEquipStyle.imageDisabled = new TextureRegionDrawable(atlas.findRegion("btnEquipDisabled"));

		btnEquip = new ImageButton(btnEquipStyle);
		btnEquip.setSize(btnSize, btnSize);
		btnEquip.setPosition(200, 0);
		
		btnEquip.setPosition(group.getWidth() - btnSize - btnBorderXOffset, btnBorderYOffset);
		btnEquip.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Player.getInstance().setActiveShip(shipClass);
				SoundUtils.playSound(game.assetManager, "beep2.ogg"
);
				game.setScreen(new ShopScreen(game));
			}
		        
		});		
		group.addActor(btnEquip);
		
		btnBack = new ImageButton(new TextureRegionDrawable(atlas.findRegion("btnBackUp")),
        		new TextureRegionDrawable(atlas.findRegion("btnBackDown")));
		btnBack.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				SoundUtils.playSound(game.assetManager, "beep2.ogg");
				game.setScreen(new ShopScreen(game));
			}
		        
		});
		btnBack.setSize(100, 100);
		btnBack.setPosition(bg1.getWidth()/2 - btnBack.getWidth()/2, 0);
		group.addActor(btnBack);
		
		gems = new Image(atlas.findRegion("gems"));
		gems.setSize(screenPadding / 2, screenPadding / 2);
		gems.setPosition(bg1.getX() + (bg1.getWidth() - gems.getWidth())/2,
				sliderHealth.getY() - gems.getHeight() - screenPadding / 4);
		gems.setColor(1, 1, 1, 0.8f);
		group.addActor(gems);

		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = game.font19;
		labelStyle.fontColor = new Color(0, 1, 1, 0.8f);

		unobtanium = new Label("" + Player.getInstance().getUnobtanium(),
				labelStyle);
		unobtanium.setAlignment(Align.center, Align.center);
		unobtanium.setPosition(
				gems.getX() + (gems.getWidth() - unobtanium.getWidth()) / 2,
				gems.getY() - unobtanium.getHeight() - screenPadding / 10);
		group.addActor(unobtanium);
		
		stage.addActor(group);
		
		updateUI();
    }
	
	void updateUI() {
		undateUnobtaniumLabel();
		updateLockButtons();
		updateLockIcons();
		updateEquipButtons();
		updateRepairButtons();
		updateHealthSliders();
	}
	
	void undateUnobtaniumLabel() {
		unobtanium.setText("" + Player.getInstance().getUnobtanium());
		unobtanium.setPosition(
				gems.getX() + (gems.getWidth() - unobtanium.getWidth()) / 2,
				gems.getY() - unobtanium.getHeight() - screenPadding / 10);
	}
	
	void updateHealthSliders() {
		float health = (float) (100 * Player.getInstance().getShipHealth(shipClass))
					/ EarthShipUtils.getShipMaxHitPoints(shipClass);
		sliderHealth.setValue(health);		
	}
	
	private void updateLockButtons() {
		Player player = Player.getInstance();
		boolean disable = true;
		if (!player.isShipUnlocked(shipClass)
				&& player.getUnobtanium() >= EarthShipUtils
						.getShipPrice(shipClass)) {
			disable = false;
		}
		btnUnlock.setDisabled(disable);
		
	}

	private void updateLockIcons() {
		Player player = Player.getInstance();
		boolean visible = true;
		if (player.isShipUnlocked(shipClass)) {
			visible = false;
		}
		iconLock.setVisible(visible);	
	}

	private void updateRepairButtons() {
		Player player = Player.getInstance();
		boolean disable = true;

		if (player.getShipHealth(shipClass) < EarthShipUtils.getShipMaxHitPoints(shipClass)) {
			disable = false;
		}
		btnRepair.setDisabled(disable);
		
	}

	private void updateEquipButtons() {
		Player player = Player.getInstance();
		boolean disable = true;
		
		if (player.isShipUnlocked(shipClass)) {
			disable = false;
		}
		btnEquip.setDisabled(disable);
	}

	@Override
	void goToPrevScreen() {
		game.setScreen(new MainScreen(game));
	}
}
