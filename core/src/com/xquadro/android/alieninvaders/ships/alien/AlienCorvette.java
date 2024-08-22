package com.xquadro.android.alieninvaders.ships.alien;

import com.xquadro.android.alieninvaders.ships.weapons.AlienTurret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret;
import com.xquadro.android.alieninvaders.world.World;

public class AlienCorvette extends AlienShip {
	public static final float WIDTH = 0.71f;
	public static final float HEIGHT = 0.565f;

	public AlienCorvette(World world, float x, float y) {
		super(world, x, y, WIDTH, HEIGHT, false);		
		loadLightnings();
		loadModules();
		loadTurrets();
		createCollisionPolygon();
		hitPointsMax = 60;
		maxAccel = 0.1f;
		maxSpeed = 2;
		radarRange = 12;
		killCoins = 10;
		hitPoints = hitPointsMax;
		shipClass = ShipClass.CORVETTE;
	}

	public void loadLightnings(){
		
		AlienLightning al = new AlienLightning(-0.22f, 0, 0.23f, 0);
		lightnings.add(al);
		al = new AlienLightning(-0.22f, 0, 0f, 0.2f);
		lightnings.add(al);
		al = new AlienLightning(-0.22f, 0, 0f, -0.2f);
		lightnings.add(al);
		al = new AlienLightning(0.23f, 0, 0f, 0.2f);
		lightnings.add(al);
		al = new AlienLightning(0.23f, 0, 0f, -0.2f);
		lightnings.add(al);

	}
	

	
	public void loadModules(){
		AlienEngine at = new AlienEngine(-0.22f, 0);
		modules.add(at);
		AlienHull ah = new AlienHull(0.23f, 0);
		modules.add(ah);
		
		AlienTurretBase atb = new AlienTurretBase(0f, 0.20f);
		modules.add(atb);
		atb = new AlienTurretBase(0f, -0.20f);
		modules.add(atb);
	}

	
	public void loadTurrets(){		
		Turret at = new AlienTurret(world, this, Turret.Type.MACHINE_GUN, 0f, 0.20f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.MACHINE_GUN, 0f, -0.20f); //136, 50		
		turrets.add(at);

	}
	
	

}
