package com.xquadro.android.alieninvaders.ships.alien;

import com.xquadro.android.alieninvaders.ships.weapons.AlienTurret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret;
import com.xquadro.android.alieninvaders.world.World;

public class AlienHeavyCruiser extends AlienShip {
	public static final float WIDTH = 1.13f;
	public static final float HEIGHT = 0.665f;

	public AlienHeavyCruiser(World world, float x, float y) {
		super(world, x, y, WIDTH, HEIGHT, false);		
		loadLightnings();
		loadModules();
		loadTurrets();
		createCollisionPolygon();
		hitPointsMax = 250;
		maxAccel = 0.05f;
		maxSpeed = 2;
		radarRange = 12;
		killCoins = 30;
		hitPoints = hitPointsMax;
		shipClass = ShipClass.HEAVYCRUISER;
	}


	

	
	public void loadModules(){
		AlienEngine at = new AlienEngine(-0.43f, 0);
		modules.add(at);
		AlienHull ah = new AlienHull(0.17f, 0f);
		modules.add(ah);		
		AlienTurretBase atb = new AlienTurretBase(-0.13f, 0f);
		modules.add(atb);
		atb = new AlienTurretBase(0.47f, 0f);
		modules.add(atb);
		atb = new AlienTurretBase(-0.28f, 0.25f);
		modules.add(atb);
		atb = new AlienTurretBase(-0.28f, -0.25f);
		modules.add(atb);
		atb = new AlienTurretBase(0.27f, 0.25f);
		modules.add(atb);
		atb = new AlienTurretBase(0.27f, -0.25f);
		modules.add(atb);

	}
	
	public void loadLightnings(){
		
		AlienLightning al = new AlienLightning(-0.43f, 0, -0.13f, 0f);
		lightnings.add(al);
		al = new AlienLightning(-0.13f, 0f, 0.17f, 0f);
		lightnings.add(al);
		al = new AlienLightning(0.17f, 0f, 0.47f, 0f);
		lightnings.add(al);
		al = new AlienLightning(-0.43f, 0, -0.28f, 0.25f);
		lightnings.add(al);
		al = new AlienLightning(-0.43f, 0, -0.28f, -0.25f);
		lightnings.add(al);
		al = new AlienLightning(-0.13f, 0f, -0.28f, 0.25f);
		lightnings.add(al);
		al = new AlienLightning(-0.13f, 0f, -0.28f, -0.25f);
		lightnings.add(al);
		al = new AlienLightning(0.17f, 0f, -0.28f, 0.25f);
		lightnings.add(al);
		al = new AlienLightning(0.17f, 0f, -0.28f, -0.25f);
		lightnings.add(al);
		al = new AlienLightning(0.17f, 0f, 0.27f, 0.25f);
		lightnings.add(al);
		al = new AlienLightning(0.17f, 0f, 0.27f, -0.25f);
		lightnings.add(al);
		al = new AlienLightning(0.47f, 0f, 0.27f, 0.25f);
		lightnings.add(al);
		al = new AlienLightning(0.47f, 0f, 0.27f, -0.25f);
		lightnings.add(al);


	}

	
	public void loadTurrets(){	
		Turret at = new AlienTurret(world, this, Turret.Type.PLASMA_BLASTER, -0.13f, 0f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.PLASMA_BLASTER, 0.47f, 0f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.LASER_CANNON, -0.28f, 0.25f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.LASER_CANNON, -0.28f, -0.25f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.MACHINE_GUN, 0.27f, 0.25f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.MACHINE_GUN, 0.27f, -0.25f); //136, 50		
		turrets.add(at);
	}

}
