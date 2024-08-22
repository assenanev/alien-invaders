package com.xquadro.android.alieninvaders.ships.earthships;

import com.xquadro.android.alieninvaders.ships.weapons.EarthTurret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret.Type;
import com.xquadro.android.alieninvaders.world.World;


public class EarthLightCruiser extends EarthShip {
	public static final float WIDTH = 1.2f;
	public static final float HEIGHT = 0.775f;
	public static final int PRICE = 350;
	public static final int HIT_POINTS_MAX = 550;
	public static final float MAX_ACCEL = 1.06f;
	public static final float MAX_SPEED = 2f;
	public static final int PLASMA_BLASTER_COUNT = 2;
	public static final int LASER_CANNON_COUNT = 1;
	public static final int MACHINE_GUN_COUNT = 2;
	
	

	public EarthLightCruiser(World world, float x, float y) {
		super(world, x, y,WIDTH, HEIGHT);
		shipClass = ShipClass.LIGHTCRUISER; 
		loadTurrets();
		turningSpeed = 60;
		hitPointsMax = HIT_POINTS_MAX;
		maxAccel = MAX_ACCEL;
		maxSpeed = MAX_SPEED;
		price = PRICE;
		hitPoints = hitPointsMax;
	}

	
	void loadTurrets(){	
		Turret t = new EarthTurret(world, this, Type.LASER_CANNON, 0.17f*WIDTH - WIDTH/2, 0.32f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.PLASMA_BLASTER, 0.43f*WIDTH - WIDTH/2, 0.41f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.PLASMA_BLASTER, 0.43f*WIDTH - WIDTH/2, 0.23f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.MACHINE_GUN, 0.7f*WIDTH - WIDTH/2, 0.43f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.MACHINE_GUN, 0.7f*WIDTH - WIDTH/2, 0.21f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
	}

}
