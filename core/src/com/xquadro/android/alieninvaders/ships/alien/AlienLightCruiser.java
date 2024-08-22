package com.xquadro.android.alieninvaders.ships.alien;

import com.xquadro.android.alieninvaders.ships.weapons.AlienTurret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret;
import com.xquadro.android.alieninvaders.world.World;

public class AlienLightCruiser extends AlienShip {
	public static final float WIDTH = 0.9f;
	public static final float HEIGHT = 0.605f;

	public AlienLightCruiser(World world, float x, float y) {
		super(world, x, y, WIDTH, HEIGHT, false);		
		loadLightnings();
		loadModules();
		loadTurrets();
		createCollisionPolygon();
		hitPointsMax = 200;
		maxAccel = 0.06f;
		maxSpeed = 2;
		radarRange = 12;
		killCoins = 25;
		hitPoints = hitPointsMax;
		shipClass = ShipClass.LIGHTCRUISER;
	}


	

	
	public void loadModules(){
		AlienEngine at = new AlienEngine(-0.33f, 0);
		modules.add(at);
		AlienHull ah = new AlienHull(0.03f, 0f);
		modules.add(ah);		
		AlienTurretBase atb = new AlienTurretBase(0.34f, 0f);
		modules.add(atb);
		atb = new AlienTurretBase(-0.14f, 0.22f);
		modules.add(atb);
		atb = new AlienTurretBase(-0.14f, -0.22f);
		modules.add(atb);
		atb = new AlienTurretBase(0.22f, 0.22f);
		modules.add(atb);
		atb = new AlienTurretBase(0.22f, -0.22f);
		modules.add(atb);

	}
	
	public void loadLightnings(){
		
		AlienLightning al = new AlienLightning(-0.33f, 0, 0.03f, 0f);
		lightnings.add(al);
		al = new AlienLightning(0.03f, 0f, 0.34f, 0f);
		lightnings.add(al);
		al = new AlienLightning(-0.33f, 0, -0.14f, 0.22f);
		lightnings.add(al);
		al = new AlienLightning(-0.33f, 0, -0.14f, -0.22f);
		lightnings.add(al);
		al = new AlienLightning(0.03f, 0f, -0.14f, 0.22f);
		lightnings.add(al);
		al = new AlienLightning(0.03f, 0f, -0.14f, -0.22f);
		lightnings.add(al);
		al = new AlienLightning(0.03f, 0f, 0.22f, 0.22f);
		lightnings.add(al);
		al = new AlienLightning(0.03f, 0f, 0.22f, -0.22f);
		lightnings.add(al);
		al = new AlienLightning(0.34f, 0f, 0.22f, 0.22f);
		lightnings.add(al);
		al = new AlienLightning(0.34f, 0f, 0.22f, -0.22f);
		lightnings.add(al);


	}

	
	public void loadTurrets(){	
		Turret at = new AlienTurret(world, this, Turret.Type.PLASMA_BLASTER, 0.34f, 0); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.LASER_CANNON, -0.14f, 0.22f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.LASER_CANNON, -0.14f, -0.22f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.MACHINE_GUN, 0.22f, 0.22f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.MACHINE_GUN, 0.22f, -0.22f); //136, 50		
		turrets.add(at);


	}

}
