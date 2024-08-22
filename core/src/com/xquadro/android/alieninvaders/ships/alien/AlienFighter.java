package com.xquadro.android.alieninvaders.ships.alien;

import com.xquadro.android.alieninvaders.ships.weapons.AlienTurret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret;
import com.xquadro.android.alieninvaders.world.World;

public class AlienFighter extends AlienShip {
	public static final float WIDTH = 0.66f;
	public static final float HEIGHT = 0.407f;

	public AlienFighter(World world, float x, float y) {
		super(world, x, y, WIDTH, HEIGHT, false);		
		loadLightnings();
		loadModules();
		loadTurrets();
		createCollisionPolygon();
		hitPointsMax = 25;
		maxAccel = 0.2f;
		maxSpeed = 2;
		radarRange = 12;
		killCoins = 5;
		hitPoints = hitPointsMax;
		shipClass = ShipClass.FIGHTER;
	}

	public void loadLightnings(){
		
		AlienLightning al = new AlienLightning(-0.195f, 0, 0.205f, 0);
		lightnings.add(al);
		al = new AlienLightning(-0.195f, 0, 0.005f, 0.2f);
		lightnings.add(al);
		al = new AlienLightning(0.205f, 0, 0.005f, 0.2f);
		lightnings.add(al);
	}
	

	
	public void loadModules(){
		AlienEngine at = new AlienEngine(-0.195f, 0);
		modules.add(at);
		AlienHull ah = new AlienHull(0.205f, 0);
		modules.add(ah);
		
		AlienTurretBase atb = new AlienTurretBase(0.005f, 0.2f);
		modules.add(atb);
	}

	
	public void loadTurrets(){		
		Turret at = new AlienTurret(world, this, Turret.Type.MACHINE_GUN, 0.005f, 0.2f); //136, 50		
		turrets.add(at);
	}
	
	

}
