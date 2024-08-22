package com.xquadro.android.alieninvaders.ships.earthships;

import com.xquadro.android.alieninvaders.ships.weapons.EarthTurret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret.Type;
import com.xquadro.android.alieninvaders.world.World;


public class EarthFrigate extends EarthShip {
	public static final float WIDTH = 1f;
	public static final float HEIGHT = 0.5f;
	public static final int PRICE = 250;
	public static final int HIT_POINTS_MAX = 450;
	public static final float MAX_ACCEL = 1.08f;
	public static final float MAX_SPEED = 2f;
	public static final int PLASMA_BLASTER_COUNT = 2;
	public static final int LASER_CANNON_COUNT = 1;
	public static final int MACHINE_GUN_COUNT = 1;

	public EarthFrigate(World world, float x, float y) {
		super(world, x, y,WIDTH, HEIGHT);
		shipClass = ShipClass.FRIGATE; 
		loadTurrets();
		turningSpeed = 75;
		hitPointsMax = HIT_POINTS_MAX;
		maxAccel = MAX_ACCEL;
		maxSpeed = MAX_SPEED;
		price = PRICE;
		hitPoints = hitPointsMax;
	}

	
	void loadTurrets(){	
		Turret t = new EarthTurret(world, this, Type.LASER_CANNON, 0.68f*WIDTH - WIDTH/2, 0.25f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.MACHINE_GUN, 0.175f*WIDTH - WIDTH/2, 0.25f*WIDTH - HEIGHT/2);//35, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.PLASMA_BLASTER, 0.42f*WIDTH - WIDTH/2, 0.16f*WIDTH - HEIGHT/2);//84, 32
		turrets.add(t);
		t = new EarthTurret(world, this, Type.PLASMA_BLASTER, 0.42f*WIDTH - WIDTH/2, 0.34f*WIDTH - HEIGHT/2);//84, 68
		turrets.add(t);	
	}

}
