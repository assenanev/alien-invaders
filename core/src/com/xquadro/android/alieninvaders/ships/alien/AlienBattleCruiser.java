package com.xquadro.android.alieninvaders.ships.alien;

import com.xquadro.android.alieninvaders.ships.weapons.AlienTurret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret;
import com.xquadro.android.alieninvaders.world.World;

public class AlienBattleCruiser extends AlienShip {
	public static final float WIDTH = 1.51f;
	public static final float HEIGHT = 0.705f;

	public AlienBattleCruiser(World world, float x, float y) {
		super(world, x, y, WIDTH, HEIGHT, false);		
		loadLightnings();
		loadModules();
		loadTurrets();
		createCollisionPolygon();
		hitPointsMax = 300;
		maxAccel = 0.05f;
		maxSpeed = 2;
		radarRange = 12;
		killCoins = 35;
		hitPoints = hitPointsMax;
		shipClass = ShipClass.BATTLECRUISER;
	}


	

	
	public void loadModules(){
		AlienEngine at = new AlienEngine(-0.58f, 0.19f);
		modules.add(at);
		at = new AlienEngine(-0.58f, -0.19f);
		modules.add(at);
		AlienHull ah = new AlienHull(0.22f, 0f);
		modules.add(ah);		
		AlienTurretBase atb = new AlienTurretBase(-0.28f, 0.13f);
		modules.add(atb);
		atb = new AlienTurretBase(-0.28f, -0.13f);
		modules.add(atb);
		atb = new AlienTurretBase(-0.03f, 0.2f);
		modules.add(atb);
		atb = new AlienTurretBase(-0.03f, -0.2f);
		modules.add(atb);
		atb = new AlienTurretBase(0.3f, 0.27f);
		modules.add(atb);
		atb = new AlienTurretBase(0.3f, -0.27f);
		modules.add(atb);
		atb = new AlienTurretBase(0.7f, 0f);
		modules.add(atb);


	}
	
	public void loadLightnings(){
		
		AlienLightning al = new AlienLightning(-0.58f, 0.19f, -0.58f, -0.19f);
		lightnings.add(al);
		al = new AlienLightning(-0.28f, 0.13f, -0.28f, -0.13f);
		lightnings.add(al);
		al = new AlienLightning(-0.03f, 0.2f, -0.03f, -0.2f);
		lightnings.add(al);
		al = new AlienLightning(-0.58f, 0.19f, -0.28f, 0.13f);
		lightnings.add(al);
		al = new AlienLightning(-0.58f, -0.19f, -0.28f, -0.13f);
		lightnings.add(al);
		al = new AlienLightning(-0.03f, 0.2f, -0.28f, 0.13f);
		lightnings.add(al);
		al = new AlienLightning(-0.03f, -0.2f, -0.28f, -0.13f);
		lightnings.add(al);
		al = new AlienLightning(-0.03f, 0.2f, 0.22f, 0f);
		lightnings.add(al);
		al = new AlienLightning(-0.03f, -0.2f, 0.22f, 0f);
		lightnings.add(al);
		al = new AlienLightning(0.3f, 0.27f, 0.22f, 0f);
		lightnings.add(al);
		al = new AlienLightning(0.3f, -0.27f, 0.22f, 0f);
		lightnings.add(al);
		al = new AlienLightning(0.3f, 0.27f, 0.7f, 0f);
		lightnings.add(al);
		al = new AlienLightning(0.3f, -0.27f, 0.7f, 0f);
		lightnings.add(al);

		al = new AlienLightning(0.22f, 0f, 0.7f, 0f);
		lightnings.add(al);


	}

	
	public void loadTurrets(){	
		Turret at = new AlienTurret(world, this, Turret.Type.PLASMA_BLASTER, 0.3f, 0.27f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.PLASMA_BLASTER, 0.3f, -0.27f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.PLASMA_BLASTER, 0.7f, 0f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.LASER_CANNON, -0.28f, 0.13f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.LASER_CANNON, -0.28f, -0.13f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.MACHINE_GUN,-0.03f, 0.2f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.MACHINE_GUN, -0.03f, -0.2f); //136, 50		
		turrets.add(at);
	}

}
