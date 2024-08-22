package com.xquadro.android.alieninvaders.ships.weapons;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.xquadro.android.alieninvaders.ships.Ship;
import com.xquadro.android.alieninvaders.world.World;

public class Turret {
	
	public enum State { SHOOT, RELOAD };
	public enum Type { LASER_CANNON, MACHINE_GUN, PLASMA_BLASTER };
	
	final Ship ship;
	final World world;
	
	public final Vector2 position;
	public final Vector2 worldPosition;
	
	public final float width;
	public final float height;
	
	public float angle;
	public float range = 5;

	public State state = State.SHOOT;
	public float stateTime = 0;
	
	public Type type;
	public float reloadTime = 0.2f;
	
	public boolean alien;
	

	public Turret(World world, Ship ship, Type type, boolean alien, float x, float y, float width, float height) {
		this.world = world;
		this.ship = ship;
		this.type = type;
		this.alien = alien;
		this.position = new Vector2(x, y);
		this.worldPosition = new Vector2();
		this.width = width;
		this.height = height;
		angle = 0;
		switch (this.type) {
		case LASER_CANNON:
			range = 9;
			reloadTime = 0.6f;
			break;
		case MACHINE_GUN:
			range = 8.3f;
			reloadTime = 0.2f;
			break;
		case PLASMA_BLASTER:
			range = 10;
			reloadTime = 1f;
			break;
		default:
			break;
		}
	}

	
	
	public void update(float deltaTime, boolean openFire) {
		stateTime += deltaTime;
		
		if(state == State.SHOOT && openFire){			
			shoot();
			state = State.RELOAD;
			stateTime = 0;
		} 
		
		if (state == State.RELOAD && stateTime > reloadTime){
			state = State.SHOOT;
			stateTime = 0;
		}
	}
	
	public void shoot() {
		updateWorldPosition();
		Projectile p = world.projectilePool.obtain();
		p.init(world, getProjectileType(), alien);
		p.angle = this.angle;
		p.position.set(worldPosition);
		p.initVelocity();
		if(!this.alien){
			p.velocity.add(ship.velocity); //add ship velocity to projectile
		}
		world.projectiles.add(p);
		if(type == Type.MACHINE_GUN){
			if(p.alien){
				world.listener.alienShot();
			} else {
				world.listener.earthShot();
			}
		}
	}
	
	Projectile.Type getProjectileType(){
		switch (this.type) {
		case MACHINE_GUN:
			return Projectile.Type.BULLET;
		case PLASMA_BLASTER:
			return Projectile.Type.PLASMA;
		case LASER_CANNON:
		default:
			return Projectile.Type.LASER;
		}
	}
	
	void updateWorldPosition(){
		
		final float positionX = ship.position.x;
		final float positionY = ship.position.y;
		final float rotation = ship.angle;
		
		final float cos = MathUtils.cosDeg(rotation);
		final float sin = MathUtils.sinDeg(rotation);
		
		float x = position.x;
		float y = position.y;
		
		float oldX = x;
		x = cos * x - sin * y;
		y = sin * oldX + cos * y;
		
		worldPosition.set(positionX + x, positionY + y);
	}
}

