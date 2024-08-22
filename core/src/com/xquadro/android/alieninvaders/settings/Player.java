package com.xquadro.android.alieninvaders.settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.xquadro.android.alieninvaders.levels.Level;
import com.xquadro.android.alieninvaders.ships.Ship;
import com.xquadro.android.alieninvaders.ships.Ship.ShipClass;
import com.xquadro.android.alieninvaders.ships.earthships.EarthShipUtils;

public class Player {
	private static final Player instance = new Player();
	private int unobtanium = 0;
	
	private static final String PREFS_NAME = ".alieninvades";
	
	private static final String PREF_ACTIVE_SHIP = "active.ship";
	private static final String PREF_UNOBTANIUM = "inobtanium";
	
	private static final String PREF_FIGHTERLOCK = "fighter.lock";
	private static final String PREF_CORVETTELOCK = "corvette.lock";
	private static final String PREF_DESTROYERLOCK = "destroyer.lock";
	private static final String PREF_FRIGATELOCK = "frigate.lock";
	private static final String PREF_LIGHTCRUISERLOCK = "lightcruiser.lock";
	private static final String PREF_HEAVYCRUISERLOCK = "heavycruiser.lock";
	private static final String PREF_BATTLECRUISERLOCK = "battlecruiser.lock";
	private static final String PREF_BATTLESHIPLOCK = "battleship.lock";
	private static final String PREF_DREADNOUGHTLOCK = "dreadnought.lock";	
	
	private static final String PREF_FIGHTER_HEALTH = "fighter.health";
	private static final String PREF_CORVETTE_HEALTH = "corvette.health";
	private static final String PREF_DESTROYER_HEALTH = "destroyer.health";
	private static final String PREF_FRIGATE_HEALTH = "frigate.health";
	private static final String PREF_LIGHTCRUISER_HEALTH = "lightcruiser.health";
	private static final String PREF_HEAVYCRUISER_HEALTH = "heavycruiser.health";
	private static final String PREF_BATTLECRUISER_HEALTH = "battlecruiser.health";
	private static final String PREF_BATTLESHIP_HEALTH = "battleship.health";
	private static final String PREF_DREADNOUGHT_HEALTH = "dreadnought.health";	
	
	private static final String PREF_HELPSHOP_SHOW = "help.shop.show";
	private static final String PREF_TUTORIAL_SHOWN = "help.tutorial.shown";
	
	private Player(){
		restoreUnobtanium();
	}
	
	protected Preferences getPrefs() {
		return Gdx.app.getPreferences(PREFS_NAME);
	}
	
	public ShipClass getActiveShip() {
		//activeShip= ShipClass.values()[getPrefs().getInteger(PREF_ACTIVE_SHIP, 0)];
		return ShipClass.values()[getPrefs().getInteger(PREF_ACTIVE_SHIP, Ship.ShipClass.FIGHTER.ordinal())];
	}

	public void setActiveShip(ShipClass activeShip) {
		//this.activeShip = activeShip;
		Preferences prefs = getPrefs();
		prefs.putInteger(PREF_ACTIVE_SHIP, activeShip.ordinal());
		prefs.flush();
	}

	public static Player getInstance(){
		return instance;
	}

	public int getUnobtanium() {
		return unobtanium;
	}
	
	public void addUnobtanium(int unobtanium) {
		this.unobtanium = this.unobtanium + unobtanium;
	}
	
	public int takeUnobtanium(int unobtanium) {
		this.unobtanium = this.unobtanium - unobtanium;
		
		return this.unobtanium;
	}
	
	public void saveUnobtanium() {
		//this.activeShip = activeShip;
		Preferences prefs = getPrefs();
		prefs.putInteger(PREF_UNOBTANIUM, unobtanium);
		prefs.flush();
	}
	
	public void saveLevel(Level l, boolean isAlien) {
		//this.activeShip = activeShip;
		Preferences prefs = getPrefs();
		prefs.putBoolean(l.getName(), isAlien);
		prefs.flush();
	}
	
	public boolean isLevelAlien(Level l) {
		return getPrefs().getBoolean(l.getName(), true);
	}
	
	public void restoreUnobtanium(){
		unobtanium = getPrefs().getInteger(PREF_UNOBTANIUM, 0);
	}
	
	public boolean isShipUnlocked(ShipClass shipClass) {
		boolean isUnlocked = false;
		switch (shipClass) {
		case FIGHTER:
			isUnlocked = getPrefs().getBoolean(PREF_FIGHTERLOCK, true);
			break;
		case CORVETTE:
			isUnlocked = getPrefs().getBoolean(PREF_CORVETTELOCK, false);
			break;
		case DESTROYER:
			isUnlocked = getPrefs().getBoolean(PREF_DESTROYERLOCK, false);
			break;
		case FRIGATE:
			isUnlocked = getPrefs().getBoolean(PREF_FRIGATELOCK, false);
			break;
		case LIGHTCRUISER:
			isUnlocked = getPrefs().getBoolean(PREF_LIGHTCRUISERLOCK, false);
			break;
		case HEAVYCRUISER:
			isUnlocked = getPrefs().getBoolean(PREF_HEAVYCRUISERLOCK, false);
			break;
		case BATTLECRUISER:
			isUnlocked = getPrefs().getBoolean(PREF_BATTLECRUISERLOCK, false);
			break;
		case BATTLESHIP:
			isUnlocked = getPrefs().getBoolean(PREF_BATTLESHIPLOCK, false);
			break;
		case DREADNOUGHT:
			isUnlocked = getPrefs().getBoolean(PREF_DREADNOUGHTLOCK, false);
			break;
		default:
			break;
		}

		return isUnlocked;
	}
	
	public boolean isHelpShopShown() {
		return getPrefs().getBoolean(PREF_HELPSHOP_SHOW, false);
	}
	
	public boolean isTutorialShown() {
		return getPrefs().getBoolean(PREF_TUTORIAL_SHOWN, false);
	}
	
	public void setHelpShopShown() {
		boolean shown = true;
		Preferences prefs = getPrefs();
		prefs.putBoolean(PREF_HELPSHOP_SHOW, shown);
		prefs.flush();
	}
	
	public void setTutorialShown() {
		boolean shown = true;
		Preferences prefs = getPrefs();
		prefs.putBoolean(PREF_TUTORIAL_SHOWN, shown);
		prefs.flush();
	}
	
	public int getShipHealth(ShipClass shipClass) {
		int health = 0;
		int shipHealthMax = EarthShipUtils.getShipMaxHitPoints(shipClass);
		switch (shipClass) {
		case FIGHTER:
			health = getPrefs().getInteger(PREF_FIGHTER_HEALTH, shipHealthMax);
			break;
		case CORVETTE:
			health = getPrefs().getInteger(PREF_CORVETTE_HEALTH, shipHealthMax);
			break;
		case DESTROYER:
			health= getPrefs().getInteger(PREF_DESTROYER_HEALTH, shipHealthMax);
			break;
		case FRIGATE:
			health = getPrefs().getInteger(PREF_FRIGATE_HEALTH, shipHealthMax);
			break;
		case LIGHTCRUISER:
			health = getPrefs().getInteger(PREF_LIGHTCRUISER_HEALTH, shipHealthMax);
			break;
		case HEAVYCRUISER:
			health = getPrefs().getInteger(PREF_HEAVYCRUISER_HEALTH, shipHealthMax);
			break;
		case BATTLECRUISER:
			health = getPrefs().getInteger(PREF_BATTLECRUISER_HEALTH, shipHealthMax);
			break;
		case BATTLESHIP:
			health = getPrefs().getInteger(PREF_BATTLESHIP_HEALTH, shipHealthMax);
			break;
		case DREADNOUGHT:
			health = getPrefs().getInteger(PREF_DREADNOUGHT_HEALTH, shipHealthMax);
			break;
		default:
			break;
		}

		return health;
	}
	
	public void setShipHealth(ShipClass shipClass, int health) {
		Preferences prefs = getPrefs();
		switch (shipClass) {
		case FIGHTER:
			prefs.putInteger(PREF_FIGHTER_HEALTH, health);
			break;
		case CORVETTE:
			prefs.putInteger(PREF_CORVETTE_HEALTH, health);
			break;
		case DESTROYER:
			prefs.putInteger(PREF_DESTROYER_HEALTH, health);
			break;
		case FRIGATE:
			prefs.putInteger(PREF_FRIGATE_HEALTH, health);
			break;
		case LIGHTCRUISER:
			prefs.putInteger(PREF_LIGHTCRUISER_HEALTH, health);
			break;
		case HEAVYCRUISER:
			prefs.putInteger(PREF_HEAVYCRUISER_HEALTH, health);
			break;
		case BATTLECRUISER:
			prefs.putInteger(PREF_BATTLECRUISER_HEALTH, health);
			break;
		case BATTLESHIP:
			prefs.putInteger(PREF_BATTLESHIP_HEALTH, health);
			break;
		case DREADNOUGHT:
			prefs.putInteger(PREF_DREADNOUGHT_HEALTH, health);
			break;
		default:
			break;
		}
		prefs.flush();
	}
	
	public void unlockClass(ShipClass shipClass){
		Preferences prefs = getPrefs();
		prefs.putInteger(PREF_UNOBTANIUM, unobtanium);
		switch (shipClass) {
		case FIGHTER:
			prefs.putBoolean(PREF_FIGHTERLOCK, true);
			break;
		case CORVETTE:
			prefs.putBoolean(PREF_CORVETTELOCK, true);
			break;
		case DESTROYER:
			prefs.putBoolean(PREF_DESTROYERLOCK, true);
			break;
		case FRIGATE:
			prefs.putBoolean(PREF_FRIGATELOCK, true);
			break;
		case LIGHTCRUISER:
			prefs.putBoolean(PREF_LIGHTCRUISERLOCK, true);
			break;
		case HEAVYCRUISER:
			prefs.putBoolean(PREF_HEAVYCRUISERLOCK, true);
			break;
		case BATTLECRUISER:
			prefs.putBoolean(PREF_BATTLECRUISERLOCK, true);
			break;
		case BATTLESHIP:
			prefs.putBoolean(PREF_BATTLESHIPLOCK, true);
			break;
		case DREADNOUGHT:
			prefs.putBoolean(PREF_DREADNOUGHTLOCK, true);
			break;
		default:
			break;
		}
		prefs.flush();
		takeUnobtanium(EarthShipUtils.getShipPrice(shipClass));
		saveUnobtanium();
	}
}
