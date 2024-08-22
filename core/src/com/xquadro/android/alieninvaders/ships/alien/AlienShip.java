package com.xquadro.android.alieninvaders.ships.alien;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Polygon;
import com.xquadro.android.alieninvaders.ships.Ship;
import com.xquadro.android.alieninvaders.ships.weapons.AlienTurret;
import com.xquadro.android.alieninvaders.world.World;

public class AlienShip extends Ship {
	public final List<AlienModule> modules;
	public final List<AlienLightning> lightnings;
	public final NavigationAI navAI; 
	public float radarRange = 10;
	public float attackRange = 5;
	public float maxAccel = 0.1f;
	public int killCoins = 1;
	
	public AlienShip(World world, float x, float y, float width, float height, boolean kamikaze) {
		super(world, x, y, width, height);
		this.modules = new ArrayList<AlienModule>();
		this.lightnings = new ArrayList<AlienLightning>();
		navAI = new NavigationAI(world, this, kamikaze);
	}

	@Override
	public void createCollisionPolygon() {
		float tempWidth = 0.9f * width;
		float tempHeight = 0.9f * height;

		collisionPolygon = new Polygon(new float[] {-tempWidth/2, -tempHeight/2,
													tempWidth/2, -tempHeight/2,
													tempWidth/2, tempHeight/2,
													-tempWidth/2, tempHeight/2});
			
		collisionPolygon.setOrigin(0, 0);

	}

	public void update(float deltaTime) {
		stateTime +=deltaTime;
		switch (state) {
		case ALIVE:
			if(hitPoints < 0){
				state = State.EXPLODE;
				stateTime = 0;
			}
			updatePhysics(deltaTime);
			navAI.update(deltaTime);
			updateTurrets(deltaTime);
			updateLightnings(deltaTime);
			break;
		case EXPLODE:
			break;
		case DEAD:
			//remove from world
		default:
			break;
		}
	}
	
	public void stop(){
		velocity.set(0,0);
		accel.set(0,0);
	}

	public void updateTurrets(float deltaTime) {
		int len = turrets.size();
		for (int i = 0; i < len; i++){
			AlienTurret t = (AlienTurret) turrets.get(i);
			t.update(deltaTime);
		}
	}
	
	public void updateLightnings(float deltaTime){
		int len = lightnings.size();
		for (int i = 0; i < len; i++){
			AlienLightning al = lightnings.get(i);
			al.update(deltaTime);
		}
	}
	
	
	
	
}


