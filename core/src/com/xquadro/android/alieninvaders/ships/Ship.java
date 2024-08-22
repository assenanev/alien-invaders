package com.xquadro.android.alieninvaders.ships;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.xquadro.android.alieninvaders.ships.weapons.Turret;
import com.xquadro.android.alieninvaders.world.World;
import com.xquadro.android.alieninvaders.world.WorldRenderer;

public class Ship {
	public enum State	{
		ALIVE, EXPLODE, DEAD
	};
	
	public enum ShipClass {
		KAMIKAZE, FIGHTER, CORVETTE, DESTROYER, FRIGATE, LIGHTCRUISER, HEAVYCRUISER, BATTLECRUISER, BATTLESHIP, DREADNOUGHT
	};
	
	public int hitPointsMax = 100;
	public int hitPoints;
	
	public State state;
	public float stateTime;
	public ShipClass shipClass;
	
	protected World world;
	
	public final Vector2 position;
	public final float width;
	public final float height;
	public final Vector2 velocity;
	public final Vector2 velocityTemp;
	public final Vector2 accel;
	public Polygon collisionPolygon;
	
	public float angle;
	public float turningSpeed = 90f;
	public float maxAccel = 0.05f;
	public float maxSpeed = 1.5f;
	
	public final List<Turret> turrets;
	public float explodeTime = 3f;
	float world_aspect;

	public Ship (World world, float x, float y, float width, float height) {
		this.world = world;
		world_aspect = Gdx.graphics.getWidth() / Gdx.graphics.getHeight();
		this.position = new Vector2(x, y);
		this.width = width;
		this.height = height;
		velocity = new Vector2();
		velocityTemp = new Vector2();
		accel = new Vector2();
		angle = 0;
		this.turrets = new ArrayList<Turret>();
		state = State.ALIVE;
	}
	
	public void createCollisionPolygon() {
		collisionPolygon = new Polygon(new float[] {-width/2, -height/2,
													width/2, -height/2,
													width/2, height/2,
													-width/2, height/2});
		
		collisionPolygon.setOrigin(0, 0);
	}
	
	public void update(float deltaTime) {		
	}

	
	public void updatePhysics(float deltaTime) {
		velocityTemp.set(velocity);
		velocity.add(accel.x * deltaTime, accel.y * deltaTime);
		if (velocity.len2() > maxSpeed * maxSpeed){
			velocity.nor().scl(maxSpeed);
		}
		position.add(velocity.x * deltaTime, velocity.y * deltaTime);
		
		if (position.x > World.WORLD_WIDTH  - WorldRenderer.FRUSTUM_WIDTH/2) {
			position.x  = World.WORLD_WIDTH - WorldRenderer.FRUSTUM_WIDTH/2;
			velocity.x *= -1;
//			accel.x *= -1;
			angle = velocity.angle();
		}
		
		if (position.x < 0 + WorldRenderer.FRUSTUM_WIDTH/2) {
			position.x  = 0 + WorldRenderer.FRUSTUM_WIDTH/2;
			velocity.x *= -1;
//			accel.x *= -1;
			angle = velocity.angle();
		}
		if (position.y > World.WORLD_HEIGHT - WorldRenderer.FRUSTUM_WIDTH * world_aspect) {
			position.y  = World.WORLD_HEIGHT - WorldRenderer.FRUSTUM_WIDTH * world_aspect;
			velocity.y *= -1;
//			accel.y *= -1;
			angle = velocity.angle();
		}
		if (position.y < 0 + WorldRenderer.FRUSTUM_WIDTH * world_aspect){
			position.y  = 0 + WorldRenderer.FRUSTUM_WIDTH * world_aspect;
			velocity.y *= -1;
//			accel.y *= -1;
			angle = velocity.angle();
		}
		
		if (accel.len() != 0) {
			if (angle < accel.angle()) {
				if (accel.angle() - angle < 180) {
					angle += turningSpeed * deltaTime;
				} else {
					angle -= turningSpeed * deltaTime;
				}
				
			} else if (angle > accel.angle()) {
				if (angle - accel.angle() > 180) {
					angle += turningSpeed * deltaTime;
				} else {
					angle -= turningSpeed * deltaTime;
				}
			}
			
		    if(angle < 0) angle += 360;
		    if(angle > 360) angle -= 360;
		}
		
		collisionPolygon.setPosition(position.x, position.y);
		collisionPolygon.setRotation(angle);	
	}
	
	public void setPosition (float x, float y){
		position.set(x, y);
	}
	
	public int getTurretCount(Turret.Type turretType){
		int count = 0;
		for(Turret t : turrets){
			if(t.type == turretType){
				count++;
			}
		}
		return count;
	}
	
	public String getShipClassName(){
		return getShipClassName(this.shipClass);
	}
		
	public static String getShipClassName(ShipClass shipClass){
		String name;
		switch (shipClass) {
		case KAMIKAZE:
			name = "Kamikaze";
			break;
		case FIGHTER:
			name = "Fighter";
			break;
		case CORVETTE:
			name = "Corvette";
			break;
		case DESTROYER:
			name = "Destroyer";
			break;
		case FRIGATE:
			name = "Frigate";
			break;
		case LIGHTCRUISER:
			name = "Light Cruiser";
			break;
		case HEAVYCRUISER:
			name = "Heavy Cruiser";
			break;
		case BATTLECRUISER:
			name = "Battle Cruiser";
			break;
		case BATTLESHIP:
			name = "Battle Ship";
			break;
		case DREADNOUGHT:
		default:
			name = "Dreadnought";
			break;
		}
		return name;
	}
}
