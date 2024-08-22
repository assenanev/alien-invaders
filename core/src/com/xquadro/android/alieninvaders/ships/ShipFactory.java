package com.xquadro.android.alieninvaders.ships;

import com.xquadro.android.alieninvaders.ships.Ship.ShipClass;
import com.xquadro.android.alieninvaders.ships.alien.AlienBattleCruiser;
import com.xquadro.android.alieninvaders.ships.alien.AlienBattleShip;
import com.xquadro.android.alieninvaders.ships.alien.AlienCorvette;
import com.xquadro.android.alieninvaders.ships.alien.AlienDestroyer;
import com.xquadro.android.alieninvaders.ships.alien.AlienDreadnought;
import com.xquadro.android.alieninvaders.ships.alien.AlienFighter;
import com.xquadro.android.alieninvaders.ships.alien.AlienFrigate;
import com.xquadro.android.alieninvaders.ships.alien.AlienHeavyCruiser;
import com.xquadro.android.alieninvaders.ships.alien.AlienKamikaze;
import com.xquadro.android.alieninvaders.ships.alien.AlienLightCruiser;
import com.xquadro.android.alieninvaders.ships.alien.AlienShip;
import com.xquadro.android.alieninvaders.ships.earthships.EarthBattleCruiser;
import com.xquadro.android.alieninvaders.ships.earthships.EarthBattleShip;
import com.xquadro.android.alieninvaders.ships.earthships.EarthCorvette;
import com.xquadro.android.alieninvaders.ships.earthships.EarthDestroyer;
import com.xquadro.android.alieninvaders.ships.earthships.EarthDreadnought;
import com.xquadro.android.alieninvaders.ships.earthships.EarthFighter;
import com.xquadro.android.alieninvaders.ships.earthships.EarthFrigate;
import com.xquadro.android.alieninvaders.ships.earthships.EarthHeavyCruiser;
import com.xquadro.android.alieninvaders.ships.earthships.EarthLightCruiser;
import com.xquadro.android.alieninvaders.ships.earthships.EarthShip;
import com.xquadro.android.alieninvaders.world.World;

public class ShipFactory {
	
	public static Ship getShip (World world, boolean isAlien, ShipClass shipClass, float x, float y){
		Ship ship;
		if (isAlien){
			ship = getAlienShip(world, shipClass, x, y);
		} else {
			ship = getEarthShip(world, shipClass, x, y);
		}
		return ship;
	}
	
	public static AlienShip getAlienShip(World world, ShipClass shipClass, float x, float y){		
		AlienShip alienShip;
		switch (shipClass) {
		case KAMIKAZE:
			alienShip = new AlienKamikaze(world, x, y);
			break;
		case FIGHTER:
			alienShip = new AlienFighter(world, x, y);
			break;
		case CORVETTE:
			alienShip = new AlienCorvette(world, x, y);
			break;
		case DESTROYER:
			alienShip = new AlienDestroyer(world, x, y);
			break;
		case FRIGATE:
			alienShip = new AlienFrigate(world, x, y);
			break;
		case LIGHTCRUISER:
			alienShip = new AlienLightCruiser(world, x, y);
			break;
		case HEAVYCRUISER:
			alienShip = new AlienHeavyCruiser(world, x, y);
			break;
		case BATTLECRUISER:
			alienShip = new AlienBattleCruiser(world, x, y);
			break;
		case BATTLESHIP:
			alienShip = new AlienBattleShip(world, x, y);
			break;
		case DREADNOUGHT:
		default:
			alienShip = new AlienDreadnought(world, x, y);
			break;
		}
		return alienShip;
	}

	public static EarthShip getEarthShip(World world, ShipClass shipClass, float x, float y){		
		EarthShip earthShip;
		switch (shipClass) {
		case FIGHTER:
			earthShip = new EarthFighter(world, x, y);
			break;
		case CORVETTE:
			earthShip = new EarthCorvette(world, x, y);
			break;
		case DESTROYER:
			earthShip = new EarthDestroyer(world, x, y);
			break;
		case FRIGATE:
			earthShip = new EarthFrigate(world, x, y);
			break;
		case LIGHTCRUISER:
			earthShip = new EarthLightCruiser(world, x, y);
			break;
		case HEAVYCRUISER:
			earthShip = new EarthHeavyCruiser(world, x, y);
			break;
		case BATTLECRUISER:
			earthShip = new EarthBattleCruiser(world, x, y);
			break;
		case BATTLESHIP:
			earthShip = new EarthBattleShip(world, x, y);
			break;
		case DREADNOUGHT:
		default:
			earthShip = new EarthDreadnought(world, x, y);
			break;
		}
		return earthShip;
	}
}
