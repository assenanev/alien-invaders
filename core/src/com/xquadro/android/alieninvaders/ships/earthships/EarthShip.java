package com.xquadro.android.alieninvaders.ships.earthships;

import com.badlogic.gdx.math.Polygon;
import com.xquadro.android.alieninvaders.ships.Ship;
import com.xquadro.android.alieninvaders.ships.weapons.EarthTurret;
import com.xquadro.android.alieninvaders.world.World;

public class EarthShip extends Ship {

	//public float radarRange = 10;
	
	public int price = 100;
	
	public EarthShip(World world, float x, float y, float width, float height) {
		super(world, x, y, width, height);
		// TODO Auto-generated constructor stub
		createCollisionPolygon();
		maxAccel = 1f;
	}
	
	
	
	@Override
	public void createCollisionPolygon() {
		float tempWidth = 0.9f * width;
		float tempHeight = 0.75f * height;

		collisionPolygon = new Polygon(new float[] {-tempWidth/2, -tempHeight/2,
													tempWidth/2, -tempHeight/2,
													tempWidth/2, tempHeight/2,
													-tempWidth/2, tempHeight/2});
			
		collisionPolygon.setOrigin(0, 0);

	}



	public void update(float deltaTime, float knobPercentX, float knobPercentY, 			
		float weaponKnobPercentX, float weaponKnobPercentY, boolean openFire, boolean autoFire) {
		
		stateTime +=deltaTime;
		switch (state) {
		case ALIVE:
			if(hitPoints < 0){
				state = State.EXPLODE;
				stateTime = 0;
			}
			accel.set(knobPercentX*maxAccel, knobPercentY*maxAccel);
			updatePhysics(deltaTime);
			updateTurrets(deltaTime, weaponKnobPercentX, weaponKnobPercentY, openFire, autoFire);
			break;
		case EXPLODE:
			break;
		case DEAD:
			//remove from world
		default:
			break;
		}
	}

	public void updateTurrets(float deltaTime, float weaponKnobPercentX, float weaponKnobPercentY, boolean openFire, boolean autoFire) {
		int len = turrets.size();
		for (int i = 0; i < len; i++){
			EarthTurret t = (EarthTurret) turrets.get(i);
			t.update(deltaTime, weaponKnobPercentX, weaponKnobPercentY, openFire, autoFire);
		}
		
	}
	
}

