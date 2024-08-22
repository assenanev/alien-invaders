package com.xquadro.android.alieninvaders.world;

import com.badlogic.gdx.assets.AssetManager;
import com.xquadro.android.alieninvaders.levels.TutorialLevel;
import com.xquadro.android.alieninvaders.ships.Ship;

public class TutorialWorld extends World {
	


	public TutorialWorld(WorldListener listener, AssetManager assetManager) {
		this.listener = listener;
		this.assetManager = assetManager;
		this.lvl = new TutorialLevel();
		
		prepareParticles();
		createSystem();
		vortex.sateliteRotationSpeed = 0;
		spaceStation.sateliteRotationSpeed = 0;
		createShip();
		createAliens();
	}

	@Override
	protected void updateEarthShip(float deltaTime, float knobPercentX,
			float knobPercentY, float weaponKnobPercentX,
			float weaponKnobPercentY, boolean openFire, boolean autoFire) {
		// TODO Auto-generated method stub
//		super.updateEarthShip(deltaTime, knobPercentX, knobPercentY,
//				weaponKnobPercentX, weaponKnobPercentY, openFire, autoFire);
		if(ship.state == Ship.State.DEAD){
			ship.state = Ship.State.ALIVE;
			ship.hitPoints = ship.hitPointsMax;
			state = State.RUNNING;
		}
	}
	
	

}
