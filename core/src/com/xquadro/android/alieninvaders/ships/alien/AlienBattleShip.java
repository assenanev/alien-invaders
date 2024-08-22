package com.xquadro.android.alieninvaders.ships.alien;

import com.xquadro.android.alieninvaders.ships.weapons.AlienTurret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret;
import com.xquadro.android.alieninvaders.world.World;

public class AlienBattleShip extends AlienShip {
	public static final float WIDTH = 1.43f;
	public static final float HEIGHT = 0.765f;

	public AlienBattleShip(World world, float x, float y) {
		super(world, x, y, WIDTH, HEIGHT, false);		
		loadLightnings();
		loadModules();
		loadTurrets();
		createCollisionPolygon();
		hitPointsMax = 350;
		maxAccel = 0.05f;
		maxSpeed = 2;
		radarRange = 12;
		killCoins = 40;
		hitPoints = hitPointsMax;
		shipClass = ShipClass.BATTLESHIP;
	}


	

	
	public void loadModules(){
		AlienEngine at = new AlienEngine(-0.455f, 0.19f);
		modules.add(at);
		at = new AlienEngine(-0.455f, -0.19f);
		modules.add(at);
		
		AlienHull ah = new AlienHull(0.095f, 0.3f);
		modules.add(ah);
		ah = new AlienHull(0.095f, -0.3f);
		modules.add(ah);
		
		AlienTurretBase atb = new AlienTurretBase(-0.255f, 0f);
		modules.add(atb);
		atb = new AlienTurretBase(-0.005f, 0f);
		modules.add(atb);
		atb = new AlienTurretBase(0.245f, 0f);
		modules.add(atb);
		atb = new AlienTurretBase(0.495f, 0f);
		modules.add(atb);
		
		atb = new AlienTurretBase(-0.205f, 0.35f);
		modules.add(atb);
		atb = new AlienTurretBase(-0.205f, -0.35f);
		modules.add(atb);
		
		atb = new AlienTurretBase(0.395f, 0.25f);
		modules.add(atb);
		atb = new AlienTurretBase(0.395f, -0.25f);
		modules.add(atb);


	}
	
	public void loadLightnings(){
		
		AlienLightning al = new AlienLightning(-0.455f, 0.19f, -0.255f, 0f);
		lightnings.add(al);
		al = new AlienLightning(-0.455f, -0.19f, -0.255f, 0f);
		lightnings.add(al);
		
		al = new AlienLightning(-0.005f, 0f, -0.255f, 0f);
		lightnings.add(al);
		al = new AlienLightning(-0.005f, 0f, 0.245f, 0f);
		lightnings.add(al);
		al = new AlienLightning(0.245f, 0f, 0.495f, 0f);
		lightnings.add(al);
		
		al = new AlienLightning(-0.455f, 0.19f, -0.205f, 0.35f);
		lightnings.add(al);
		al = new AlienLightning(-0.455f, -0.19f, -0.205f, -0.35f);
		lightnings.add(al);
		
		al = new AlienLightning(-0.255f, 0f, -0.205f, 0.35f);
		lightnings.add(al);
		al = new AlienLightning(-0.255f, 0f, -0.205f, -0.35f);
		lightnings.add(al);
		al = new AlienLightning(-0.005f, 0f, -0.205f, 0.35f);
		lightnings.add(al);
		al = new AlienLightning(-0.005f, 0f, -0.205f, -0.35f);
		lightnings.add(al);
		al = new AlienLightning(0.095f, 0.3f, -0.205f, 0.35f);
		lightnings.add(al);
		al = new AlienLightning(0.095f, -0.3f, -0.205f, -0.35f);
		lightnings.add(al);
		
		al = new AlienLightning(0.095f, 0.3f, -0.005f, 0f);
		lightnings.add(al);
		al = new AlienLightning(0.095f, -0.3f, -0.005f, 0f);
		lightnings.add(al);
		al = new AlienLightning(0.095f, 0.3f, 0.245f, 0f);
		lightnings.add(al);
		al = new AlienLightning(0.095f, -0.3f, 0.245f, 0f);
		lightnings.add(al);
		al = new AlienLightning(0.095f, 0.3f, 0.395f, 0.25f);
		lightnings.add(al);
		al = new AlienLightning(0.095f, -0.3f, 0.395f, -0.25f);
		lightnings.add(al);
		
		al = new AlienLightning(0.245f, 0f, 0.395f, 0.25f);
		lightnings.add(al);
		al = new AlienLightning(0.245f, 0f, 0.395f, -0.25f);
		lightnings.add(al);
		al = new AlienLightning(0.495f, 0f, 0.395f, 0.25f);
		lightnings.add(al);
		al = new AlienLightning(0.495f, 0f, 0.395f, -0.25f);
		lightnings.add(al);



	}

	
	public void loadTurrets(){	
		Turret at = new AlienTurret(world, this, Turret.Type.MACHINE_GUN, -0.255f, 0f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.MACHINE_GUN, -0.005f, 0f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.MACHINE_GUN, 0.245f, 0f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.PLASMA_BLASTER, 0.495f, 0f); //136, 50
		turrets.add(at);
		
		
		at = new AlienTurret(world, this, Turret.Type.LASER_CANNON, -0.205f, 0.35f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.LASER_CANNON, -0.205f, -0.35f); //136, 50		
		turrets.add(at);
		
		at = new AlienTurret(world, this, Turret.Type.PLASMA_BLASTER, 0.395f, 0.25f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.PLASMA_BLASTER, 0.395f, -0.25f); //136, 50		
		turrets.add(at);
	}

}
