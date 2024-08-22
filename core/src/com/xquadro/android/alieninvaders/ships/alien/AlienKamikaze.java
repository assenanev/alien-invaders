package com.xquadro.android.alieninvaders.ships.alien;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.xquadro.android.alieninvaders.world.World;



public class AlienKamikaze extends AlienShip {
	public static final float WIDTH = 0.61f;
	public static final float HEIGHT = 0.25f;
	
	public int attack = 100;

	Vector2 tempVector;
	public AlienKamikaze(World world, float x, float y) {
		super(world, x, y, WIDTH, HEIGHT, true);
		
		loadLightnings();
		loadModules();
		loadTurrets();
		createCollisionPolygon();
		hitPointsMax = 5;
		maxAccel = 2;
		maxSpeed = 2.3f;
		radarRange = 15;
		killCoins = 5;
		hitPoints = hitPointsMax;
		shipClass = ShipClass.KAMIKAZE;
		
		tempVector = new Vector2();
	}
	
	
	public void loadLightnings(){
		AlienLightning al = new AlienLightning(-0.17f, 0, 0.18f,0);
		lightnings.add(al);
	}
	
	public void loadModules(){
		AlienEngine at = new AlienEngine(-0.17f, 0);
		modules.add(at);
		AlienHull ah = new AlienHull(0.18f, 0);
		modules.add(ah);
	}

	
	public void loadTurrets(){
	}
	
	
	
	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		super.update(deltaTime);
		detectCollisions();
	}


	public void detectCollisions(){
		tempVector.set(this.position); 
		if(tempVector.sub(world.ship.position).len2() > 4 * 4) {
			return;
		} else {
			if(Intersector.overlapConvexPolygons(this.collisionPolygon.getTransformedVertices(), world.ship.collisionPolygon.getTransformedVertices(), null)){
				state = State.EXPLODE;
				stateTime = 0;
				world.ship.hitPoints -= this.attack;
			}
		}
	}

}
