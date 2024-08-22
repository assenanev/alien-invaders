package com.xquadro.android.alieninvaders.ships.weapons;


import com.badlogic.gdx.math.Vector2;
import com.xquadro.android.alieninvaders.ships.Ship;
import com.xquadro.android.alieninvaders.world.World;

public class AlienTurret extends Turret {
	public static final float WIDTH = 0.35f;
	Vector2 tempPosition;
	Ship target;

	
	public AlienTurret(World world, Ship ship, Type type, float x, float y) {
		super(world, ship, type, true, x, y, WIDTH, WIDTH);
		tempPosition = new Vector2();
		target = world.ship;
	}
	
	public void update(float deltaTime) {	
		updateWorldPosition();
		tempPosition.set(target.position).sub(worldPosition);
		boolean openFire;
		if (target.state == Ship.State.ALIVE && tempPosition.len2() < range * range) {
			angle = tempPosition.angle();
			openFire = true;
		} else {
			//angle = ship.angle;
			openFire = false;
		}
		super.update(deltaTime, openFire);
	}

}
