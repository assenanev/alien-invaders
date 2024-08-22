package com.xquadro.android.alieninvaders.ships.alien;

import com.xquadro.android.alieninvaders.ships.weapons.AlienTurret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret;
import com.xquadro.android.alieninvaders.world.World;

public class AlienDestroyer extends AlienShip {
	public static final float WIDTH = 1.03f;
	public static final float HEIGHT = 0.457f;

	public AlienDestroyer(World world, float x, float y) {
		super(world, x, y, WIDTH, HEIGHT, false);		
		loadLightnings();
		loadModules();
		loadTurrets();
		createCollisionPolygon();
		hitPointsMax = 100;
		maxAccel = 0.08f;
		maxSpeed = 2;
		radarRange = 12;
		killCoins = 15;
		hitPoints = hitPointsMax;
		shipClass = ShipClass.DESTROYER;
	}


	

	
	public void loadModules(){
		AlienEngine at = new AlienEngine(-0.4f, 0);
		modules.add(at);
		AlienHull ah = new AlienHull(0.04f, 0.1f);
		modules.add(ah);		
		AlienTurretBase atb = new AlienTurretBase(-0.14f, -0.15f);
		modules.add(atb);
		atb = new AlienTurretBase(0.16f, -0.15f);
		modules.add(atb);
		atb = new AlienTurretBase(0.4f, 0f);
		modules.add(atb);
	}
	
	public void loadLightnings(){
		
		AlienLightning al = new AlienLightning(-0.4f, 0, 0.04f, 0.1f);
		lightnings.add(al);
		al = new AlienLightning(0.04f, 0.1f, 0.4f, 0f);
		lightnings.add(al);
		al = new AlienLightning(-0.4f, 0, -0.14f, -0.15f);
		lightnings.add(al);
		al = new AlienLightning(-0.14f, -0.15f, 0.16f, -0.15f);
		lightnings.add(al);
		al = new AlienLightning(0.16f, -0.15f, 0.4f, 0f);
		lightnings.add(al);
		al = new AlienLightning(-0.14f, -0.15f, 0.04f, 0.1f);
		lightnings.add(al);
		al = new AlienLightning(0.16f, -0.15f, 0.04f, 0.1f);
		lightnings.add(al);

	}

	
	public void loadTurrets(){
		Turret at = new AlienTurret(world, this, Turret.Type.LASER_CANNON, -0.14f, -0.15f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.MACHINE_GUN, 0.16f, -0.15f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.MACHINE_GUN, 0.4f, 0f); //136, 50		
		turrets.add(at);

	}
	
	

}
