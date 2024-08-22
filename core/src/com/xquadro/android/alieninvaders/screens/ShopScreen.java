package com.xquadro.android.alieninvaders.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.List.ListStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.xquadro.android.alieninvaders.settings.Player;
import com.xquadro.android.alieninvaders.ships.Ship;
import com.xquadro.android.alieninvaders.ships.Ship.ShipClass;
import com.xquadro.android.alieninvaders.ships.earthships.EarthBattleShip;
import com.xquadro.android.alieninvaders.ships.earthships.EarthShipUtils;
import com.xquadro.android.alieninvaders.world.WorldRenderer;

public class ShopScreen extends AbstractScreen {
	private static final int BTN_UNLOCK_ID = 0;
	private static final int BTN_REPAIR_ID = 1;
	private static final int BTN_EQUIP_ID = 2;
	private static final int ICON_LOCK_ID = 3;
	private static final int SLIDER_HEALTH_ID = 4;

	public static TextureAtlas atlas;
	
	String[] listEntries1 = {
			"At the space station you can:",
			"1. Unlock new ships, if you have enough Unobtainium;",
			"2. Repair damaged ships;",
			"3. Change your ship;"};
	
	Label star;

	Array<Group> rows = new Array<Group>();

	Image ActiveShipIcon;
	Image bg3;

	Image gems;
	Label unobtanium;

	TextureRegionDrawable fighterDrawable;
	TextureRegionDrawable corvetteDrawable;
	TextureRegionDrawable destroyerDrawable;
	TextureRegionDrawable frigateDrawable;
	TextureRegionDrawable lightCruiserDrawable;
	TextureRegionDrawable heavyCruiserDrawable;
	TextureRegionDrawable battleCruiserDrawable;
	TextureRegionDrawable battleShipDrawable;
	TextureRegionDrawable dreadnoughtDrawable;

	float screenPadding = 50;
	float shipImgBGSize = 150;
	
	Window helpDialog;

	public ShopScreen(AlienInvadersGame alienInvadersGame) {
		super(alienInvadersGame, "data/blueplanet.png");

//		 Player.getInstance().addUnobtanium(500);
//		 Player.getInstance().saveUnobtanium();

		atlas = game.assetManager.get("data/atlases/ai.atlas",
				TextureAtlas.class);

		fighterDrawable = new TextureRegionDrawable(
				atlas.findRegion(WorldRenderer
						.getEarthShipRegionName(ShipClass.FIGHTER)));
		corvetteDrawable = new TextureRegionDrawable(
				atlas.findRegion(WorldRenderer
						.getEarthShipRegionName(ShipClass.CORVETTE)));
		destroyerDrawable = new TextureRegionDrawable(
				atlas.findRegion(WorldRenderer
						.getEarthShipRegionName(ShipClass.DESTROYER)));
		frigateDrawable = new TextureRegionDrawable(
				atlas.findRegion(WorldRenderer
						.getEarthShipRegionName(ShipClass.FRIGATE)));
		lightCruiserDrawable = new TextureRegionDrawable(
				atlas.findRegion(WorldRenderer
						.getEarthShipRegionName(ShipClass.LIGHTCRUISER)));
		heavyCruiserDrawable = new TextureRegionDrawable(
				atlas.findRegion(WorldRenderer
						.getEarthShipRegionName(ShipClass.HEAVYCRUISER)));
		battleCruiserDrawable = new TextureRegionDrawable(
				atlas.findRegion(WorldRenderer
						.getEarthShipRegionName(ShipClass.BATTLECRUISER)));
		battleShipDrawable = new TextureRegionDrawable(
				atlas.findRegion(WorldRenderer
						.getEarthShipRegionName(ShipClass.BATTLESHIP)));
		dreadnoughtDrawable = new TextureRegionDrawable(
				atlas.findRegion(WorldRenderer
						.getEarthShipRegionName(ShipClass.DREADNOUGHT)));

		NinePatch patch = new NinePatch(atlas.createPatch("window20xt85"));
		NinePatch patch1 = new NinePatch(atlas.createPatch("window20xt10"));

		SliderStyle sliderStyle = new SliderStyle();
		sliderStyle.background = new TextureRegionDrawable(
				atlas.findRegion("sliderbg"));
		sliderStyle.knobBefore = new TextureRegionDrawable(
				atlas.findRegion("sliderbf"));
		sliderStyle.knobAfter = new TextureRegionDrawable(
				atlas.findRegion("slideraf"));

		Table table = new Table();
		table.row().height(screenPadding);
		table.add();

		for (ShipClass shipClass : ShipClass.values()) {
			if (shipClass == ShipClass.KAMIKAZE)
				continue;

			String rowName = "" + shipClass.ordinal();

			Group row = new Group();
			row.setName(rowName);
			rows.add(row);
			row.setSize(game.width - 3 * screenPadding - shipImgBGSize,
					shipImgBGSize);

			Image bg1 = new Image(patch);
			bg1.setSize(shipImgBGSize, shipImgBGSize);
			bg1.setPosition(0, 0);
			row.addActor(bg1);

			ImageButton shipIcon = new ImageButton(getShipDrawable(shipClass));
			shipIcon.setSize(
					shipImgBGSize * 0.8f
							* EarthShipUtils.getShipWidth(shipClass)
							/ EarthBattleShip.WIDTH, shipImgBGSize * 0.8f
							* EarthShipUtils.getShipHeight(shipClass)
							/ EarthBattleShip.WIDTH);
			shipIcon.setPosition(
					(shipImgBGSize - shipImgBGSize * 0.8f
							* EarthShipUtils.getShipWidth(shipClass)
							/ EarthBattleShip.WIDTH) / 2,
					(shipImgBGSize - shipImgBGSize * 0.8f
							* EarthShipUtils.getShipHeight(shipClass)
							/ EarthBattleShip.WIDTH) / 2);

			shipIcon.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					ShipClass activeShip = ShipClass.values()[Integer
							.parseInt(actor.getParent().getName())];
					SoundUtils.playSound(game.assetManager, "beep2.ogg");
					game.setScreen(new ShipDataScreen(game, activeShip));
				}

			});
			row.addActor(shipIcon);

			Image iconLock = new Image(atlas.findRegion("iconLock"));
			iconLock.setName("" + ICON_LOCK_ID);
			iconLock.setSize(shipImgBGSize / 7.5f, shipImgBGSize / 7.5f);
			iconLock.setPosition(
					bg1.getX() + bg1.getWidth() - iconLock.getWidth()
							- shipImgBGSize / 8, bg1.getY() + shipImgBGSize / 8);
			iconLock.setColor(1, 1, 1, 0.5f);
			iconLock.setVisible(false);
			row.addActor(iconLock);

			Image bg2 = new Image(patch);
			bg2.setSize(row.getWidth() - shipImgBGSize - screenPadding,
					shipImgBGSize);
			bg2.setPosition(shipImgBGSize + screenPadding, 0);
			row.addActor(bg2);

			LabelStyle labelStyle = new LabelStyle();
			labelStyle.font = game.font19;

			Label shipClassLabel = new Label("Class: "
					+ Ship.getShipClassName(shipClass), labelStyle);
			shipClassLabel.setPosition(shipImgBGSize + 1.4f * screenPadding,
					shipImgBGSize - shipClassLabel.getHeight() - 0.4f
							* screenPadding);
			row.addActor(shipClassLabel);

			Slider sliderHealth = new Slider(0, 100, 1, false, sliderStyle);
			sliderHealth.setName("" + SLIDER_HEALTH_ID);
			sliderHealth.setSize(bg2.getWidth() / 4, 4);
			sliderHealth.setPosition(shipClassLabel.getX(),
					shipClassLabel.getY() - sliderHealth.getHeight()
							- screenPadding / 15);
			// sliderHealth.setValue(80);
			sliderHealth.setTouchable(Touchable.disabled);
			sliderHealth.setColor(1, 1, 1, 0.5f);
			row.addActor(sliderHealth);

			float btnSize = 60;
			float btnBorderYOffset = 20f;
			float btnBorderXOffset = 20f;
			float btnOffset = 10f;

			ImageButtonStyle btnUnlockStyle = new ImageButtonStyle();
			btnUnlockStyle.imageUp = new TextureRegionDrawable(
					atlas.findRegion("btnUnlockUp"));
			btnUnlockStyle.imageDown = new TextureRegionDrawable(
					atlas.findRegion("btnUnlockDown"));
			btnUnlockStyle.imageDisabled = new TextureRegionDrawable(
					atlas.findRegion("btnUnlockDisabled"));

			ImageButton btnUnlock = new ImageButton(btnUnlockStyle);
			btnUnlock.setName("" + BTN_UNLOCK_ID);
			btnUnlock.setSize(btnSize, btnSize);
			btnUnlock.setPosition(row.getWidth() - btnSize * 4
					- btnBorderXOffset + 3 * btnOffset, btnBorderYOffset);
			btnUnlock.setDisabled(true);
			btnUnlock.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					ShipClass activeShip = ShipClass.values()[Integer
							.parseInt(actor.getParent().getName())];
					Player.getInstance().unlockClass(activeShip);
					Player.getInstance().setActiveShip(activeShip);
					updateUI();
					SoundUtils.playSound(game.assetManager, "beep2.ogg");
				}

			});
			row.addActor(btnUnlock);

			ImageButtonStyle btnRepairStyle = new ImageButtonStyle();
			btnRepairStyle.imageUp = new TextureRegionDrawable(
					atlas.findRegion("btnRepairUp"));
			btnRepairStyle.imageDown = new TextureRegionDrawable(
					atlas.findRegion("btnRepairDown"));
			btnRepairStyle.imageDisabled = new TextureRegionDrawable(
					atlas.findRegion("btnRepairDisabled"));

			ImageButton btnRepair = new ImageButton(btnRepairStyle);
			btnRepair.setName("" + BTN_REPAIR_ID);
			btnRepair.setSize(btnSize, btnSize);
			btnRepair.setPosition(row.getWidth() - btnSize * 3
					- btnBorderXOffset + 2 * btnOffset, btnBorderYOffset + 2
					* btnOffset);
			btnRepair.setDisabled(true);
			btnRepair.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {

					ShipClass activeShip = ShipClass.values()[Integer
							.parseInt(actor.getParent().getName())];
					Player p = Player.getInstance();
					int unobtanium = p.getUnobtanium();
					float hitPoints = p.getShipHealth(activeShip);
					float maxHitPoints = EarthShipUtils
							.getShipMaxHitPoints(activeShip);
					float price = EarthShipUtils.getShipPrice(activeShip);
					float damageRatio = (maxHitPoints - hitPoints)
							/ maxHitPoints;
					float repairCost = damageRatio * price;

					if (unobtanium >= repairCost) {
						p.setShipHealth(activeShip,
								EarthShipUtils.getShipMaxHitPoints(activeShip));
						p.takeUnobtanium((int) repairCost);
						p.saveUnobtanium();
					} else {
						float repairRatio = unobtanium / repairCost;
						float healthToAdd = hitPoints
								+ (maxHitPoints - hitPoints) * repairRatio;
						p.setShipHealth(activeShip, (int) healthToAdd);
						p.takeUnobtanium(unobtanium);
						p.saveUnobtanium();
					}
					updateUI();
					SoundUtils.playSound(game.assetManager, "beep2.ogg");
				}

			});
			row.addActor(btnRepair);

			ImageButtonStyle btnEquipStyle = new ImageButtonStyle();
			btnEquipStyle.imageUp = new TextureRegionDrawable(
					atlas.findRegion("btnEquipUp"));
			btnEquipStyle.imageDown = new TextureRegionDrawable(
					atlas.findRegion("btnEquipDown"));
			btnEquipStyle.imageDisabled = new TextureRegionDrawable(
					atlas.findRegion("btnEquipDisabled"));

			ImageButton btnEquip = new ImageButton(btnEquipStyle);
			btnEquip.setName("" + BTN_EQUIP_ID);
			btnEquip.setSize(btnSize, btnSize);

			btnEquip.setPosition(row.getWidth() - btnSize * 2
					- btnBorderXOffset + btnOffset, btnBorderYOffset);
			btnEquip.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					ShipClass activeShip = ShipClass.values()[Integer
							.parseInt(actor.getParent().getName())];
					Player.getInstance().setActiveShip(activeShip);
					updateUI();
					SoundUtils.playSound(game.assetManager, "beep2.ogg");
				}

			});
			row.addActor(btnEquip);

			ImageButton btnAbout = new ImageButton(new TextureRegionDrawable(
					atlas.findRegion("btnAboutUp")), new TextureRegionDrawable(
					atlas.findRegion("btnAboutDown")));
			btnAbout.setSize(btnSize, btnSize);
			btnAbout.setPosition(row.getWidth() - btnSize - btnBorderXOffset,
					btnBorderYOffset + 2 * btnOffset);
			btnAbout.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					ShipClass activeShip = ShipClass.values()[Integer
							.parseInt(actor.getParent().getName())];
					SoundUtils.playSound(game.assetManager, "beep2.ogg");
					game.setScreen(new ShipDataScreen(game, activeShip));

				}

			});

			row.addActor(btnAbout);

			row.setSize(game.width - 2 * screenPadding, shipImgBGSize);
			table.row();
			table.add(row).height(row.getHeight()).width(row.getWidth());
			table.row().height(screenPadding);
			table.add();
		}

		ScrollPaneStyle style = new ScrollPaneStyle(null, null, null, null,
				null);
		ScrollPane pane = new ScrollPane(table, style);
		pane.setScrollingDisabled(true, false);
		pane.setWidth(game.width - 2 * screenPadding);
		pane.setHeight(game.height);// pane.pack();
		pane.setPosition(screenPadding, 0);
		pane.validate();
		// pane.scrollTo(scrollTo, 0, 400, 400);
		stage.addActor(pane);

		bg3 = new Image(patch);
		bg3.setSize(shipImgBGSize, shipImgBGSize);
		bg3.setPosition(game.width - shipImgBGSize - screenPadding, game.height
				- shipImgBGSize - screenPadding);
		stage.addActor(bg3);

		ActiveShipIcon = new Image();
		setActiveShipIcon();
		stage.addActor(ActiveShipIcon);

		gems = new Image(atlas.findRegion("gems"));
		gems.setSize(screenPadding / 2, screenPadding / 2);
		gems.setPosition(bg3.getX() + (bg3.getWidth() - gems.getWidth()) / 2,
				bg3.getY() - gems.getHeight() - screenPadding / 3);
		gems.setColor(1, 1, 1, 0.8f);
		stage.addActor(gems);

		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = game.font19;
		labelStyle.fontColor = new Color(0, 1, 1, 0.8f);

		unobtanium = new Label("" + Player.getInstance().getUnobtanium(),
				labelStyle);
		unobtanium.setAlignment(Align.center, Align.center);
		unobtanium.setPosition(
				gems.getX() + (gems.getWidth() - unobtanium.getWidth()) / 2,
				gems.getY() - unobtanium.getHeight() - screenPadding / 10);
		stage.addActor(unobtanium);

		ImageButton btnBack = new ImageButton(new TextureRegionDrawable(
				atlas.findRegion("btnBackUp")), new TextureRegionDrawable(
				atlas.findRegion("btnBackDown")));
		btnBack.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				SoundUtils.playSound(game.assetManager, "beep2.ogg");
				game.setScreen(new GameScreen(game, game.levels.getLevels()
						.get(0)));
			}

		});
		btnBack.setSize(100, 100);
		btnBack.setPosition(bg3.getX() + (bg3.getWidth() - btnBack.getWidth())
				/ 2, screenPadding);
		stage.addActor(btnBack);

		updateUI();
		
		LabelStyle label1Style = new LabelStyle();
		label1Style.font = game.font28;
		//labelStyle.fontColor = new Color(0.8f, 1f, 1f, 1f);

		ImageButton btnHelpBack = new ImageButton(new TextureRegionDrawable(
				atlas.findRegion("btnBackUp")), new TextureRegionDrawable(
				atlas.findRegion("btnBackDown")));
		btnHelpBack.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				helpDialog.setVisible(false);
				Player.getInstance().setHelpShopShown();
				SoundUtils.playSound(game.assetManager, "beep2.ogg");
			}

		});

		star = new Label("Tutorial", label1Style);
		
		ListStyle listStyle = new ListStyle();
		listStyle.font = game.font19;
		//listStyle.fontColorSelected = new Color(0.8f, 1f, 1f, 1f);
		//listStyle.fontColorUnselected = new Color(0.8f, 1f, 1f, 1f);
		listStyle.selection = new TextureRegionDrawable(atlas.findRegion("select"));
		
		List<String> list1 = new List<String>(listStyle);
		list1.setItems(listEntries1);

		WindowStyle wStyle = new WindowStyle();
		wStyle.titleFont = new BitmapFont();
		wStyle.titleFontColor = new Color();
		wStyle.background = new NinePatchDrawable(patch1);

		float dialogPadding = 50;
		helpDialog = new Window("Help", wStyle);
		helpDialog.setSize(game.width - 2*dialogPadding, game.height - 2*dialogPadding);
		helpDialog.setPosition(dialogPadding, dialogPadding);
		helpDialog.setModal(true);
		helpDialog.setVisible(!Player.getInstance().isHelpShopShown());
		helpDialog.row();
		helpDialog.add(star);
		helpDialog.row();
		helpDialog.add(list1).expand();
		helpDialog.row();
		helpDialog.add(btnHelpBack).width(100).height(100).bottom().left();
		
		stage.addActor(helpDialog);
	}

	void updateUI() {
		setActiveShipIcon();
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
		Player player = Player.getInstance();
		float health = 100;
		for (Group row : rows) {
			ShipClass rowShip = ShipClass.values()[Integer.parseInt(row
					.getName())];
			Slider slider = (Slider) row.findActor("" + SLIDER_HEALTH_ID);
			health = (float) (100 * player.getShipHealth(rowShip))
					/ EarthShipUtils.getShipMaxHitPoints(rowShip);
			slider.setValue(health);
		}
	}

	public void setActiveShipIcon() {
		ActiveShipIcon.setDrawable(getShipDrawable(Player.getInstance()
				.getActiveShip()));

		ActiveShipIcon.setSize(
				shipImgBGSize
						* 0.8f
						* EarthShipUtils.getShipWidth(Player.getInstance()
								.getActiveShip()) / EarthBattleShip.WIDTH,
				shipImgBGSize
						* 0.8f
						* EarthShipUtils.getShipHeight(Player.getInstance()
								.getActiveShip()) / EarthBattleShip.WIDTH);
		ActiveShipIcon.setPosition(bg3.getX()
				+ (bg3.getWidth() - ActiveShipIcon.getWidth()) / 2, bg3.getY()
				+ (bg3.getHeight() - ActiveShipIcon.getHeight()) / 2);
	}

	public TextureRegionDrawable getShipDrawable(ShipClass shipClass) {
		TextureRegionDrawable trd;
		switch (shipClass) {

		case FIGHTER:
			trd = fighterDrawable;
			break;
		case CORVETTE:
			trd = corvetteDrawable;
			break;
		case DESTROYER:
			trd = destroyerDrawable;
			break;
		case FRIGATE:
			trd = frigateDrawable;
			break;
		case LIGHTCRUISER:
			trd = lightCruiserDrawable;
			break;
		case HEAVYCRUISER:
			trd = heavyCruiserDrawable;
			break;
		case BATTLECRUISER:
			trd = battleCruiserDrawable;
			break;
		case BATTLESHIP:
			trd = battleShipDrawable;
			break;
		case DREADNOUGHT:
			trd = dreadnoughtDrawable;
			break;
		case KAMIKAZE:
		default:
			trd = fighterDrawable;
			break;
		}
		return trd;
	}

	@Override
	void goToPrevScreen() {
		if(helpDialog.isVisible()){
			helpDialog.setVisible(false);
			Player.getInstance().setHelpShopShown();
		}
		game.setScreen(new GameScreen(game, game.levels.getLevels().get(0)));
	}

	private void updateLockButtons() {
		Player player = Player.getInstance();
		boolean disable = true;

		for (Group row : rows) {
			ShipClass rowShip = ShipClass.values()[Integer.parseInt(row
					.getName())];
			ImageButton btnUnlock = (ImageButton) row.findActor(""
					+ BTN_UNLOCK_ID);
			disable = true;
			if (!player.isShipUnlocked(rowShip)
					&& player.getUnobtanium() >= EarthShipUtils
							.getShipPrice(rowShip)) {
				disable = false;
			}
			btnUnlock.setDisabled(disable);
		}
	}

	private void updateLockIcons() {
		Player player = Player.getInstance();
		boolean visible = true;

		for (Group row : rows) {
			ShipClass rowShip = ShipClass.values()[Integer.parseInt(row
					.getName())];
			Image lockIcon = (Image) row.findActor("" + ICON_LOCK_ID);
			visible = true;
			if (player.isShipUnlocked(rowShip)) {
				visible = false;
			}
			lockIcon.setVisible(visible);
		}
	}

	private void updateRepairButtons() {
		Player player = Player.getInstance();
		boolean disable = true;

		for (Group row : rows) {
			ShipClass rowShip = ShipClass.values()[Integer.parseInt(row
					.getName())];

			ImageButton btnRepair = (ImageButton) row.findActor(""
					+ BTN_REPAIR_ID);
			disable = true;
			if (player.getShipHealth(rowShip) < EarthShipUtils
					.getShipMaxHitPoints(rowShip)) {
				disable = false;
			}
			btnRepair.setDisabled(disable);
		}
	}

	private void updateEquipButtons() {
		Player player = Player.getInstance();
		boolean disable = true;

		for (Group row : rows) {
			ShipClass rowShip = ShipClass.values()[Integer.parseInt(row
					.getName())];
			ImageButton btnEquip = (ImageButton) row.findActor(""
					+ BTN_EQUIP_ID);
			disable = true;
			if (player.isShipUnlocked(rowShip)) {
				disable = false;
			}
			btnEquip.setDisabled(disable);
		}
	}

	@Override
	public void hide() {
		super.hide();
		Player.getInstance().saveUnobtanium();
	}

}
