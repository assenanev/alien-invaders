package com.xquadro.android.alieninvaders.ships.weapons;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.xquadro.android.alieninvaders.world.World;

public class Projectile{
	public enum State {
		FIRED, EXPLODED, DEAD
	};

	public enum Type {
		NONE, LASER, BULLET, PLASMA
	};

	public Type type = Type.LASER;
	public State state = State.DEAD;
	public float stateTime;

	public boolean alien;
	
	World world;

	public final Vector2 position = new Vector2();
	public final Vector2 acceleration = new Vector2();
	public final Vector2 velocity = new Vector2();
	public float angle;

	public float[] localCollisionBounds = new float[8];
	public float[] worldCollisionBounds = new float[8];

	public float speed;
	public int attack;
	public float lifeTime;
	public float width;
	public float height;
	public float explodeTime = 0.15f;
	private Vector2 tempVector = new Vector2();

	public void init(World world, Type type, boolean alien) {
		this.world = world;
		this.type = type;
		this.alien = alien;
		state = State.FIRED;
		stateTime = 0;

		switch (type) {
		case PLASMA:
			speed = 2.5f;
			attack = 6;
			lifeTime = 4f;
			width = 0.2f;
			height = 0.05f;
			break;

		case LASER:
			speed = 3;
			attack = 4;
			lifeTime = 3f;
			width = 0.15f;
			height = 0.035f;
			break;

		case BULLET:
			speed = 3.8f;
			attack = 1;
			lifeTime = 2.1f;
			width = 0.08f;
			height = 0.025f;
			break;

		default:
			break;

		}
		setCollisionBounds();
		updateWorldCollisionBounds();
	}

	public void setCollisionBounds() {
		localCollisionBounds[0] = -width / 2;
		localCollisionBounds[1] = -height / 2;
		localCollisionBounds[2] = width / 2;
		localCollisionBounds[3] = -height / 2;
		localCollisionBounds[4] = width / 2;
		localCollisionBounds[5] = height / 2;
		localCollisionBounds[6] = -width / 2;
		localCollisionBounds[7] = height / 2;
	}

	public float[] updateWorldCollisionBounds () {
		final float[] localCollisionBounds = this.localCollisionBounds;
		final float[] worldCollisionBounds = this.worldCollisionBounds;
		final float positionX = position.x;
		final float positionY = position.y;

		final float rotation = this.angle;
		final float cos = MathUtils.cosDeg(rotation);
		final float sin = MathUtils.sinDeg(rotation);

		for (int i = 0, n = localCollisionBounds.length; i < n; i += 2) {
			float x = localCollisionBounds[i];
			float y = localCollisionBounds[i + 1];

			if (rotation != 0) {
				float oldX = x;
				x = cos * x - sin * y;
				y = sin * oldX + cos * y;
			}

			worldCollisionBounds[i] = positionX + x;
			worldCollisionBounds[i + 1] = positionY + y;
		}
		return worldCollisionBounds;
	}



	public void update(float deltaTime) {
		stateTime += deltaTime;
		
		switch (state) {
		case FIRED:
			position.add(velocity.x * deltaTime, velocity.y * deltaTime);
			updateWorldCollisionBounds();
			detectCollisions();
			if (stateTime > lifeTime) {
				state = State.DEAD;
				stateTime = 0;
			}
			break;
		case EXPLODED:
			if(stateTime > explodeTime ) {
				state = State.DEAD;
				stateTime = 0;
			}
		case DEAD:
			// back to pool
			break;

		default:
			break;
		}
	}

	public void initVelocity() {
		velocity.set(speed*MathUtils.cosDeg(angle), speed*MathUtils.sinDeg(angle));		
	}
	
	public void detectCollisions(){
		if(this.alien){
			detectAlienCollisions();
		} else {
			detectEarthCollisions();
		}
	}
	
	private void detectAlienCollisions(){
		tempVector.set(this.position); 
		if(tempVector.sub(world.ship.position).len2() < 5 * 5) {
			if(world.ship.collisionPolygon.contains(position.x, position.y)){
				state = State.EXPLODED;
				stateTime = 0;
				world.ship.hitPoints -= this.attack;
			}
		}
	}
	
	private void detectEarthCollisions(){
		int count = world.alienShips.size();
		for (int i = 0; i < count; i++){
			tempVector .set(this.position); 
			if(tempVector.sub(world.alienShips.get(i).position).len2() < 5 * 5) {
				if(world.alienShips.get(i).collisionPolygon.contains(position.x, position.y)){
					state = State.EXPLODED;
					stateTime = 0;
					world.alienShips.get(i).hitPoints -= this.attack;
				}
			}
		}
	}
}
