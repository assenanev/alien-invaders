package com.xquadro.android.alieninvaders.ships.earthships;

import com.xquadro.android.alieninvaders.ships.weapons.EarthTurret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret;
import com.xquadro.android.alieninvaders.ships.weapons.Turret.Type;
import com.xquadro.android.alieninvaders.world.World;


public class EarthBattleShip extends EarthShip {
	public static final float WIDTH = 2.1f;
	public static final float HEIGHT = 1.125f;
	public static final int PRICE = 650;
	public static final int HIT_POINTS_MAX = 850;
	public static final float MAX_ACCEL = 1.01f;
	public static final float MAX_SPEED = 2f;
	public static final int PLASMA_BLASTER_COUNT = 3;
	public static final int LASER_CANNON_COUNT = 2;
	public static final int MACHINE_GUN_COUNT = 3;

	public EarthBattleShip(World world, float x, float y) {
		super(world, x, y,WIDTH, HEIGHT);
		shipClass = ShipClass.BATTLESHIP;
		loadTurrets();
		turningSpeed = 50;
		hitPointsMax = HIT_POINTS_MAX;
		maxAccel = MAX_ACCEL;
		maxSpeed = MAX_SPEED;
		price = PRICE;
		hitPoints = hitPointsMax;
	}

	
	void loadTurrets(){	
		Turret t = new EarthTurret(world, this, Type.PLASMA_BLASTER, 0.23f*WIDTH - WIDTH/2, 0.27f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.PLASMA_BLASTER, 0.3f*WIDTH - WIDTH/2, 0.39f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.PLASMA_BLASTER, 0.3f*WIDTH - WIDTH/2, 0.15f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.MACHINE_GUN, 0.56f*WIDTH - WIDTH/2, 0.27f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.MACHINE_GUN, 0.64f*WIDTH - WIDTH/2, 0.44f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.MACHINE_GUN, 0.64f*WIDTH - WIDTH/2, 0.1f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.LASER_CANNON, 0.9f*WIDTH - WIDTH/2, 0.37f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
		t = new EarthTurret(world, this, Type.LASER_CANNON, 0.9f*WIDTH - WIDTH/2, 0.17f*WIDTH - HEIGHT/2); //136, 50
		turrets.add(t);
	}

}
