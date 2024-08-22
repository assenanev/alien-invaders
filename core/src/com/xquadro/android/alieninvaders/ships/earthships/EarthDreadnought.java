package com.xquadro.android.alieninvaders.ships.earthships;

import com.xquadro.android.alieninvaders.ships.weapons.EarthTurret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret.Type;
import com.xquadro.android.alieninvaders.world.World;


public class EarthDreadnought extends EarthShip {
	public static final float WIDTH = 2.025f;
	public static final float HEIGHT = 1.45f;
	public static final int PRICE = 700;
	public static final int HIT_POINTS_MAX = 950;
	public static final float MAX_ACCEL = 1f;
	public static final float MAX_SPEED = 2f;
	public static final int PLASMA_BLASTER_COUNT = 3;
	public static final int LASER_CANNON_COUNT = 3;
	public static final int MACHINE_GUN_COUNT = 3;

	public EarthDreadnought(World world, float x, float y) {
		super(world, x, y,WIDTH, HEIGHT);
		shipClass = ShipClass.DREADNOUGHT;
		loadTurrets();
		turningSpeed = 50;
		hitPointsMax = HIT_POINTS_MAX;
		maxAccel = MAX_ACCEL;
		maxSpeed = MAX_SPEED;
		price = PRICE;
		hitPoints = hitPointsMax;
	}

	
	void loadTurrets(){	
		Turret t = new EarthTurret(world, this, Type.PLASMA_BLASTER, 0.24f*WIDTH - WIDTH/2, 0.36f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.PLASMA_BLASTER, 0.32f*WIDTH - WIDTH/2, 0.48f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.PLASMA_BLASTER, 0.32f*WIDTH - WIDTH/2, 0.23f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.MACHINE_GUN, 0.47f*WIDTH - WIDTH/2, 0.52f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.MACHINE_GUN, 0.47f*WIDTH - WIDTH/2, 0.22f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.MACHINE_GUN, 0.58f*WIDTH - WIDTH/2, 0.36f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.LASER_CANNON, 0.72f*WIDTH - WIDTH/2, 0.36f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.LASER_CANNON, 0.93f*WIDTH - WIDTH/2, 0.46f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.LASER_CANNON, 0.93f*WIDTH - WIDTH/2, 0.25f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
	}

}
