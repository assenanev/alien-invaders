package com.xquadro.android.alieninvaders.ships.earthships;

import com.xquadro.android.alieninvaders.ships.weapons.EarthTurret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret.Type;
import com.xquadro.android.alieninvaders.world.World;


public class EarthCorvette extends EarthShip {
	public static final float WIDTH = 0.52f;
	public static final float HEIGHT = 0.3f;
	public static final int PRICE = 50;
	public static final int HIT_POINTS_MAX = 250;
	public static final float MAX_ACCEL = 1.2f;
	public static final float MAX_SPEED = 2.1f;
	public static final int PLASMA_BLASTER_COUNT = 0;
	public static final int LASER_CANNON_COUNT = 1;
	public static final int MACHINE_GUN_COUNT = 1;

	public EarthCorvette(World world, float x, float y) {
		super(world, x, y,WIDTH, HEIGHT);
		shipClass = ShipClass.CORVETTE; 
		loadTurrets();
		hitPointsMax = HIT_POINTS_MAX;
		maxAccel = MAX_ACCEL;
		maxSpeed = MAX_SPEED;
		price = PRICE;
		hitPoints = hitPointsMax;
	}
	
	void loadTurrets(){	
		Turret t = new EarthTurret(world, this, Type.LASER_CANNON, 0.23f*WIDTH - WIDTH/2, 0.29f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.MACHINE_GUN, 0.70f*WIDTH - WIDTH/2, 0.29f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
	}

}
