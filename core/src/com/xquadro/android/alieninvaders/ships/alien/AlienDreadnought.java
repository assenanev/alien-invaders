package com.xquadro.android.alieninvaders.ships.alien;

import com.xquadro.android.alieninvaders.ships.weapons.AlienTurret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret;
import com.xquadro.android.alieninvaders.world.World;

public class AlienDreadnought extends AlienShip {
	public static final float WIDTH = 1.18f;
	public static final float HEIGHT = 0.865f;

	public AlienDreadnought(World world, float x, float y) {
		super(world, x, y, WIDTH, HEIGHT, false);		
		loadLightnings();
		loadModules();
		loadTurrets();
		createCollisionPolygon();
		hitPointsMax = 400;
		maxAccel = 0.05f;
		maxSpeed = 2;
		radarRange = 12;
		killCoins = 50;
		hitPoints = hitPointsMax;
		shipClass = ShipClass.DREADNOUGHT;
	}


	

	
	public void loadModules(){
		AlienEngine at = new AlienEngine(-0.58f, 0.19f);
		modules.add(at);
		at = new AlienEngine(-0.58f, -0.19f);
		modules.add(at);
		
		AlienHull ah = new AlienHull(-0.29f, 0f);
		modules.add(ah);
		ah = new AlienHull(0.17f, 0f);
		modules.add(ah);
		
		AlienTurretBase atb = new AlienTurretBase(-0.33f, 0.3f);
		modules.add(atb);
		atb = new AlienTurretBase(-0.33f, -0.3f);
		modules.add(atb);
		atb = new AlienTurretBase(-0.08f, 0.22f);
		modules.add(atb);
		atb = new AlienTurretBase(-0.08f, -0.22f);
		modules.add(atb);
		atb = new AlienTurretBase(0.17f, 0.3f);
		modules.add(atb);
		atb = new AlienTurretBase(0.17f, -0.3f);
		modules.add(atb);
		atb = new AlienTurretBase(0.42f, 0.18f);
		modules.add(atb);
		atb = new AlienTurretBase(0.42f, -0.18f);
		modules.add(atb);
		atb = new AlienTurretBase(0.62f, 0f);
		modules.add(atb);
	}
	
	public void loadLightnings(){
		
		AlienLightning al = new AlienLightning(-0.58f, 0.19f, -0.29f, 0f);
		lightnings.add(al);
		al = new AlienLightning(-0.58f, -0.19f, -0.29f, 0f);
		lightnings.add(al);
		al = new AlienLightning(0.17f, 0f, -0.29f, 0f);
		lightnings.add(al);
		al = new AlienLightning(0.17f, 0f, 0.42f, 0.18f);
		lightnings.add(al);
		al = new AlienLightning(0.17f, 0f, 0.42f, -0.18f);
		lightnings.add(al);
		al = new AlienLightning(0.62f, 0f, 0.42f, 0.18f);
		lightnings.add(al);
		al = new AlienLightning(0.62f, 0f, 0.42f, -0.18f);
		lightnings.add(al);
		al = new AlienLightning(-0.08f, 0.22f, -0.29f, 0f);
		lightnings.add(al);
		al = new AlienLightning(-0.08f, -0.22f, -0.29f, 0f);
		lightnings.add(al);
		al = new AlienLightning(-0.08f, 0.22f, 0.17f, 0f);
		lightnings.add(al);
		al = new AlienLightning(-0.08f, -0.22f, 0.17f, 0f);
		lightnings.add(al);
		al = new AlienLightning(-0.58f, 0.19f, -0.33f, 0.3f);
		lightnings.add(al);
		al = new AlienLightning(-0.58f, -0.19f, -0.33f, -0.3f);
		lightnings.add(al);
		al = new AlienLightning(-0.08f, 0.22f, -0.33f, 0.3f);
		lightnings.add(al);
		al = new AlienLightning(-0.08f, -0.22f, -0.33f, -0.3f);
		lightnings.add(al);
		al = new AlienLightning(-0.08f, 0.22f, 0.17f, 0.3f);
		lightnings.add(al);
		al = new AlienLightning(-0.08f, -0.22f, 0.17f, -0.3f);
		lightnings.add(al);
		al = new AlienLightning(0.42f, 0.18f, 0.17f, 0.3f);
		lightnings.add(al);
		al = new AlienLightning(0.42f, -0.18f, 0.17f, -0.3f);
		lightnings.add(al);
		
		
	
	}

	
	public void loadTurrets(){	
		Turret at = new AlienTurret(world, this, Turret.Type.PLASMA_BLASTER, -0.33f, 0.3f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.PLASMA_BLASTER, -0.33f, -0.3f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.PLASMA_BLASTER, -0.08f, 0.22f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.PLASMA_BLASTER, -0.08f, -0.22f); //136, 50		
		turrets.add(at);
		
		at = new AlienTurret(world, this, Turret.Type.LASER_CANNON, 0.17f, 0.3f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.LASER_CANNON, 0.17f, -0.3f); //136, 50		
		turrets.add(at);
		
		at = new AlienTurret(world, this, Turret.Type.MACHINE_GUN, 0.42f, 0.18f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.MACHINE_GUN, 0.42f, -0.18f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.MACHINE_GUN, 0.62f, 0f); //136, 50
		turrets.add(at);

	}

}
