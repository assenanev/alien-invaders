package com.xquadro.android.alieninvaders.ships.alien;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;
import com.xquadro.android.alieninvaders.ships.Ship;
import com.xquadro.android.alieninvaders.world.World;


public class NavigationAI {
	public enum State { CRUISE, ATTACK, WAIT, STOPPING };
	public enum Attact { CLOSING, RETARGET, RUN};
	World world;
	AlienShip ship;
	Ship target;
	Vector2 navTarget;
	public State state;
	public float stateTime;
	public Attact attackState;
	public float attactTime;
	boolean kamikaze;
	
	Random rand;
	Vector2 tempVector;
	
	public NavigationAI(World world, AlienShip ship, boolean kamikaze){
		this.ship = ship;
		this.kamikaze = kamikaze;
		this.world = world;
		this.target = world.ship;
		state = State.WAIT;
		attackState = Attact.CLOSING;
		navTarget = new Vector2();
		rand = new Random();
		tempVector = new Vector2();
	}
	
	public void update(float deltaTime){
		stateTime += deltaTime;
		tempVector.set(ship.position); 
		if (tempVector.sub(target.position).len2() < ship.radarRange * ship.radarRange) {
			state = State.ATTACK;
		}
		//add other attacking ships
		switch (state) {
		case CRUISE:
			updateCruise(deltaTime);
			break;
		case STOPPING:
			updateStopping(deltaTime);
			break;
		
		case WAIT:
			updateWait(deltaTime);
			break;
			
		case ATTACK:
			updateAttack(deltaTime);
			break;

		default:
			break;
		}
		
		
	}
	
	private void updateAttack(float deltaTime) {
		attactTime += deltaTime;

		switch (attackState) {
		case CLOSING:
			if (attactTime > 0.1f) {
				ship.accel.set(target.position).sub(ship.position).nor().scl(ship.maxAccel);
				attactTime = 0;
			}
			
			if (!kamikaze
					&& tempVector.sub(target.position).len2() < ship.attackRange * ship.attackRange*0.8f*0.8f) {
				attackState = Attact.RETARGET;
				attactTime = 0;
			}
			break;
			
		case RETARGET:
			ship.accel.set(target.position.x + (rand.nextFloat() * ship.attackRange*0.8f + ship.attackRange*0.3f) , 
					target.position.y + (rand.nextFloat() * ship.attackRange*0.8f + ship.attackRange*0.3f)).sub(ship.position).nor().scl(ship.maxAccel);
			attackState = Attact.RUN;
			stateTime = 0;
			
		case RUN:

			if (tempVector.sub(target.position).len2() < ship.attackRange * ship.attackRange) {
				attackState = Attact.CLOSING;
				stateTime = 0;
			}
			break;

		default:
			break;
		}
		
		
	}
	
	private void updateCruise (float deltaTime) {
		//refactor me
		if (ship.position.epsilonEquals(navTarget, 1f))	{
			ship.accel.scl(-1);
			state = State.STOPPING;
			stateTime = 0;
		} 		
	}
	
	private void updateStopping (float deltaTime) {	
		//refactor me?
		if (ship.velocity.len2() > 0.02f){
			ship.accel.set(0, 0);
			ship.velocity.set(0, 0);
			state = State.WAIT;
			stateTime = 0;
		} 		
	}
	
	private void updateWait (float deltaTime) {		
		if (stateTime > 5) {
			navTarget.set(rand.nextFloat()*World.WORLD_WIDTH*0.6f + World.WORLD_WIDTH*0.2f,
					rand.nextFloat()*World.WORLD_HEIGHT*0.6f + World.WORLD_HEIGHT*0.2f);
			ship.accel.set(navTarget).sub(ship.position).nor().scl(ship.maxAccel*0.1f);
			state = State.CRUISE;
			stateTime = 0;
		} 		
	}
}
