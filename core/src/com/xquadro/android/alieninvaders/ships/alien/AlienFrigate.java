package com.xquadro.android.alieninvaders.ships.alien;

import com.xquadro.android.alieninvaders.ships.weapons.AlienTurret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret;
import com.xquadro.android.alieninvaders.world.World;

public class AlienFrigate extends AlienShip {
	public static final float WIDTH = 0.86f;
	public static final float HEIGHT = 0.725f;

	public AlienFrigate(World world, float x, float y) {
		super(world, x, y, WIDTH, HEIGHT, false);		
		loadLightnings();
		loadModules();
		loadTurrets();
		createCollisionPolygon();
		hitPointsMax = 150;
		maxAccel = 0.07f;
		maxSpeed = 2;
		radarRange = 12;
		killCoins = 20;
		hitPoints = hitPointsMax;
		shipClass = ShipClass.FRIGATE;
	}


	

	
	public void loadModules(){
		AlienEngine at = new AlienEngine(-0.295f, 0);
		modules.add(at);
		AlienHull ah = new AlienHull(0.305f, 0f);
		modules.add(ah);		
		AlienTurretBase atb = new AlienTurretBase(-0.07f, -0.2f);
		modules.add(atb);
		atb = new AlienTurretBase(-0.07f, 0.2f);
		modules.add(atb);
		atb = new AlienTurretBase(0.18f, -0.28f);
		modules.add(atb);
		atb = new AlienTurretBase(0.18f, 0.28f);
		modules.add(atb);
	}
	
	public void loadLightnings(){
		
		AlienLightning al = new AlienLightning(-0.295f, 0, 0.305f, 0f);
		lightnings.add(al);
		al = new AlienLightning(-0.295f, 0, -0.07f, -0.2f);
		lightnings.add(al);
		al = new AlienLightning(-0.295f, 0, -0.07f, 0.2f);
		lightnings.add(al);
		al = new AlienLightning(0.18f, -0.28f, -0.07f, -0.2f);
		lightnings.add(al);
		al = new AlienLightning(0.18f, 0.28f, -0.07f, 0.2f);
		lightnings.add(al);
		al = new AlienLightning(0.18f, -0.28f, 0.305f, 0f);
		lightnings.add(al);
		al = new AlienLightning(0.18f, 0.28f, 0.305f, 0f);
		lightnings.add(al);


	}

	
	public void loadTurrets(){	
		Turret at = new AlienTurret(world, this, Turret.Type.LASER_CANNON, -0.07f, -0.2f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.LASER_CANNON, -0.07f, 0.2f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.MACHINE_GUN, 0.18f, -0.28f); //136, 50		
		turrets.add(at);
		at = new AlienTurret(world, this, Turret.Type.MACHINE_GUN, 0.18f, 0.28f); //136, 50		
		turrets.add(at);

	}
	
	

}
