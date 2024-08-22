package com.xquadro.android.alieninvaders.ships.earthships;

import com.xquadro.android.alieninvaders.ships.Ship.ShipClass;
import com.xquadro.android.alieninvaders.ships.weapons.Turret;

public class EarthShipUtils {
	public static float getShipWidth(ShipClass shipClass){
		float width = 0;
		switch (shipClass) {		
		case FIGHTER:
			width = EarthFighter.WIDTH;
			break;
		case CORVETTE:
			width = EarthCorvette.WIDTH;
			break;
		case DESTROYER:
			width = EarthDestroyer.WIDTH;
			break;
		case FRIGATE:
			width = EarthFrigate.WIDTH;
			break;
		case LIGHTCRUISER:
			width = EarthLightCruiser.WIDTH;
			break;
		case HEAVYCRUISER:
			width = EarthHeavyCruiser.WIDTH;
			break;
		case BATTLECRUISER:
			width = EarthBattleCruiser.WIDTH;
			break;
		case BATTLESHIP:
			width = EarthBattleShip.WIDTH;
			break;
		case DREADNOUGHT:
			width = EarthDreadnought.WIDTH;
			break;
		case KAMIKAZE:
			break;
		default:
			break;
		}
		return width;
	}
	
	public static int getTurretCount(ShipClass shipClass, Turret.Type type){
		int machine_guns = 0;
		int plasma_blasters = 0;
		int laser_cannons = 0;
		int res = 0;
		switch (shipClass) {
		
		case FIGHTER:
			machine_guns = EarthFighter.MACHINE_GUN_COUNT;
			plasma_blasters = EarthFighter.PLASMA_BLASTER_COUNT;
			laser_cannons = EarthFighter.LASER_CANNON_COUNT;
			break;
		case CORVETTE:
			machine_guns = EarthCorvette.MACHINE_GUN_COUNT;
			plasma_blasters = EarthCorvette.PLASMA_BLASTER_COUNT;
			laser_cannons = EarthCorvette.LASER_CANNON_COUNT;
			break;
		case DESTROYER:
			machine_guns = EarthDestroyer.MACHINE_GUN_COUNT;
			plasma_blasters = EarthDestroyer.PLASMA_BLASTER_COUNT;
			laser_cannons = EarthDestroyer.LASER_CANNON_COUNT;
			break;
		case FRIGATE:
			machine_guns = EarthFrigate.MACHINE_GUN_COUNT;
			plasma_blasters = EarthFrigate.PLASMA_BLASTER_COUNT;
			laser_cannons = EarthFrigate.LASER_CANNON_COUNT;
			break;
		case LIGHTCRUISER:
			machine_guns = EarthLightCruiser.MACHINE_GUN_COUNT;
			plasma_blasters = EarthLightCruiser.PLASMA_BLASTER_COUNT;
			laser_cannons = EarthLightCruiser.LASER_CANNON_COUNT;
			break;
		case HEAVYCRUISER:
			machine_guns = EarthHeavyCruiser.MACHINE_GUN_COUNT;
			plasma_blasters = EarthHeavyCruiser.PLASMA_BLASTER_COUNT;
			laser_cannons = EarthHeavyCruiser.LASER_CANNON_COUNT;
			break;
		case BATTLECRUISER:
			machine_guns = EarthBattleCruiser.MACHINE_GUN_COUNT;
			plasma_blasters = EarthBattleCruiser.PLASMA_BLASTER_COUNT;
			laser_cannons = EarthBattleCruiser.LASER_CANNON_COUNT;
			break;
		case BATTLESHIP:
			machine_guns = EarthBattleShip.MACHINE_GUN_COUNT;
			plasma_blasters = EarthBattleShip.PLASMA_BLASTER_COUNT;
			laser_cannons = EarthBattleShip.LASER_CANNON_COUNT;
			break;
		case DREADNOUGHT:
			machine_guns = EarthDreadnought.MACHINE_GUN_COUNT;
			plasma_blasters = EarthDreadnought.PLASMA_BLASTER_COUNT;
			laser_cannons = EarthDreadnought.LASER_CANNON_COUNT;
			break;
		case KAMIKAZE:
			break;
		default:
			break;
		}
		switch (type) {
		case LASER_CANNON:
			res = laser_cannons;
			break;
		case PLASMA_BLASTER:
			res = plasma_blasters;
			break;
		case MACHINE_GUN:
			res = machine_guns;
			break;

		default:
			break;
		}
		return res;
	}
	
	
	public static int getShipPrice(ShipClass shipClass){
		int price = 0;
		switch (shipClass) {
		
		case FIGHTER:
			price = EarthFighter.PRICE;
			break;
		case CORVETTE:
			price = EarthCorvette.PRICE;
			break;
		case DESTROYER:
			price = EarthDestroyer.PRICE;
			break;
		case FRIGATE:
			price = EarthFrigate.PRICE;
			break;
		case LIGHTCRUISER:
			price = EarthLightCruiser.PRICE;
			break;
		case HEAVYCRUISER:
			price = EarthHeavyCruiser.PRICE;
			break;
		case BATTLECRUISER:
			price = EarthBattleCruiser.PRICE;
			break;
		case BATTLESHIP:
			price = EarthBattleShip.PRICE;
			break;
		case DREADNOUGHT:
			price = EarthDreadnought.PRICE;
			break;
		case KAMIKAZE:
			break;
		default:
			break;
		}
		return price;
	}
	
	public static float getShipMaxSpeed(ShipClass shipClass){
		float speed = 0;
		switch (shipClass) {
		
		case FIGHTER:
			speed = EarthFighter.MAX_SPEED;
			break;
		case CORVETTE:
			speed = EarthCorvette.MAX_SPEED;
			break;
		case DESTROYER:
			speed = EarthDestroyer.MAX_SPEED;
			break;
		case FRIGATE:
			speed = EarthFrigate.MAX_SPEED;
			break;
		case LIGHTCRUISER:
			speed = EarthLightCruiser.MAX_SPEED;
			break;
		case HEAVYCRUISER:
			speed = EarthHeavyCruiser.MAX_SPEED;
			break;
		case BATTLECRUISER:
			speed = EarthBattleCruiser.MAX_SPEED;
			break;
		case BATTLESHIP:
			speed = EarthBattleShip.MAX_SPEED;
			break;
		case DREADNOUGHT:
			speed = EarthDreadnought.MAX_SPEED;
			break;
		case KAMIKAZE:
			break;
		default:
			break;
		}
		return speed;
	}
	
	public static float getShipMaxAccel(ShipClass shipClass){
		float accel = 0;
		switch (shipClass) {
		
		case FIGHTER:
			accel = EarthFighter.MAX_ACCEL;
			break;
		case CORVETTE:
			accel = EarthCorvette.MAX_ACCEL;
			break;
		case DESTROYER:
			accel = EarthDestroyer.MAX_ACCEL;
			break;
		case FRIGATE:
			accel = EarthFrigate.MAX_ACCEL;
			break;
		case LIGHTCRUISER:
			accel = EarthLightCruiser.MAX_ACCEL;
			break;
		case HEAVYCRUISER:
			accel = EarthHeavyCruiser.MAX_ACCEL;
			break;
		case BATTLECRUISER:
			accel = EarthBattleCruiser.MAX_ACCEL;
			break;
		case BATTLESHIP:
			accel = EarthBattleShip.MAX_ACCEL;
			break;
		case DREADNOUGHT:
			accel = EarthDreadnought.MAX_ACCEL;
			break;
		case KAMIKAZE:
			break;
		default:
			break;
		}
		return accel;
	}
	
	public static int getShipMaxHitPoints(ShipClass shipClass){
		int hitPoints = 0;
		switch (shipClass) {
		
		case FIGHTER:
			hitPoints = EarthFighter.HIT_POINTS_MAX;
			break;
		case CORVETTE:
			hitPoints = EarthCorvette.HIT_POINTS_MAX;
			break;
		case DESTROYER:
			hitPoints = EarthDestroyer.HIT_POINTS_MAX;
			break;
		case FRIGATE:
			hitPoints = EarthFrigate.HIT_POINTS_MAX;
			break;
		case LIGHTCRUISER:
			hitPoints = EarthLightCruiser.HIT_POINTS_MAX;
			break;
		case HEAVYCRUISER:
			hitPoints = EarthHeavyCruiser.HIT_POINTS_MAX;
			break;
		case BATTLECRUISER:
			hitPoints = EarthBattleCruiser.HIT_POINTS_MAX;
			break;
		case BATTLESHIP:
			hitPoints = EarthBattleShip.HIT_POINTS_MAX;
			break;
		case DREADNOUGHT:
			hitPoints = EarthDreadnought.HIT_POINTS_MAX;
			break;
		case KAMIKAZE:
			break;
		default:
			break;
		}
		return hitPoints;
	}

	public static float getShipHeight(ShipClass shipClass){
		float height = 0;
		switch (shipClass) {
		
		case FIGHTER:
			height = EarthFighter.HEIGHT;
			break;
		case CORVETTE:
			height = EarthCorvette.HEIGHT;
			break;
		case DESTROYER:
			height = EarthDestroyer.HEIGHT;
			break;
		case FRIGATE:
			height = EarthFrigate.HEIGHT;
			break;
		case LIGHTCRUISER:
			height = EarthLightCruiser.HEIGHT;
			break;
		case HEAVYCRUISER:
			height = EarthHeavyCruiser.HEIGHT;
			break;
		case BATTLECRUISER:
			height = EarthBattleCruiser.HEIGHT;
			break;
		case BATTLESHIP:
			height = EarthBattleShip.HEIGHT;
			break;
		case DREADNOUGHT:
			height = EarthDreadnought.HEIGHT;
			break;
		case KAMIKAZE:
			break;
		default:
			break;
		}
		return height;
	}

}
