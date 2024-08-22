package com.xquadro.android.alieninvaders.ships.earthships;

import com.xquadro.android.alieninvaders.ships.weapons.EarthTurret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret.Type;
import com.xquadro.android.alieninvaders.world.World;


public class EarthHeavyCruiser extends EarthShip {
	public static final float WIDTH = 1.8f;
	public static final float HEIGHT = 0.85f;
	public static final int PRICE = 450;
	public static final int HIT_POINTS_MAX = 650;
	public static final float MAX_ACCEL = 1.04f;
	public static final float MAX_SPEED = 2f;
	public static final int PLASMA_BLASTER_COUNT = 2;
	public static final int LASER_CANNON_COUNT = 2;
	public static final int MACHINE_GUN_COUNT = 2;

	public EarthHeavyCruiser(World world, float x, float y) {
		super(world, x, y,WIDTH, HEIGHT);
		shipClass = ShipClass.HEAVYCRUISER; 
		loadTurrets();
		turningSpeed = 50;
		hitPointsMax = HIT_POINTS_MAX;
		maxAccel = MAX_ACCEL;
		maxSpeed = MAX_SPEED;
		price = PRICE;
		hitPoints = hitPointsMax;
	}

	
	void loadTurrets(){	
		Turret t = new EarthTurret(world, this, Type.LASER_CANNON, 0.2f*WIDTH - WIDTH/2, 0.24f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.PLASMA_BLASTER, 0.28f*WIDTH - WIDTH/2, 0.36f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.PLASMA_BLASTER, 0.28f*WIDTH - WIDTH/2, 0.11f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.MACHINE_GUN, 0.56f*WIDTH - WIDTH/2, 0.24f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.MACHINE_GUN, 0.68f*WIDTH - WIDTH/2, 0.24f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.LASER_CANNON, 0.89f*WIDTH - WIDTH/2, 0.24f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);

	}


}
