package com.xquadro.android.alieninvaders.ships.earthships;

import com.xquadro.android.alieninvaders.ships.weapons.EarthTurret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret.Type;
import com.xquadro.android.alieninvaders.world.World;


public class EarthDestroyer extends EarthShip {
	public static final float WIDTH = 0.9f;
	public static final float HEIGHT = 0.5f;
	public static final int PRICE = 150;
	public static final int HIT_POINTS_MAX = 350;
	public static final float MAX_ACCEL = 1.1f;
	public static final float MAX_SPEED = 2f;
	public static final int PLASMA_BLASTER_COUNT = 1;
	public static final int LASER_CANNON_COUNT = 0;
	public static final int MACHINE_GUN_COUNT = 2;

	public EarthDestroyer(World world, float x, float y) {
		super(world, x, y,WIDTH, HEIGHT);
		shipClass = ShipClass.DESTROYER; 
		loadTurrets();
		turningSpeed = 75;
		hitPointsMax = HIT_POINTS_MAX;
		maxAccel = MAX_ACCEL;
		maxSpeed = MAX_SPEED;
		price = PRICE;
		hitPoints = hitPointsMax;
	}

	
	void loadTurrets(){	
		Turret t = new EarthTurret(world, this, Type.PLASMA_BLASTER, 0.20f*WIDTH - WIDTH/2, 0.27f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.MACHINE_GUN, 0.48f*WIDTH - WIDTH/2, 0.38f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.MACHINE_GUN, 0.48f*WIDTH - WIDTH/2, 0.17f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
	}

}
