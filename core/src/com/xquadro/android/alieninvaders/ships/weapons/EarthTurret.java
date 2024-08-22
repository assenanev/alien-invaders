package com.xquadro.android.alieninvaders.ships.weapons;

import com.badlogic.gdx.math.MathUtils;
import com.xquadro.android.alieninvaders.ships.Ship;
import com.xquadro.android.alieninvaders.world.World;

public class EarthTurret extends Turret {
	public static final float WIDTH = 0.35f;
	
	float lockAngle = 0;


	public EarthTurret(World world, Ship ship, Type type, float x, float y) {
		super(world, ship, type, false, x, y, WIDTH, WIDTH);
	}
	
	public void update(float deltaTime, float knobPercentX, float knobPercentY, boolean openFire, boolean autoFire) {
		if (MathUtils.radDeg * MathUtils.atan2(knobPercentY, knobPercentX) != 0) {
			angle = MathUtils.radDeg * MathUtils.atan2(knobPercentY, knobPercentX);
			lockAngle = angle - ship.angle;
		} else {
			angle = lockAngle + ship.angle;
		}
		if (autoFire){
			super.update(deltaTime, true);
		} else {
			super.update(deltaTime, openFire);			
		}
		
	}
}



