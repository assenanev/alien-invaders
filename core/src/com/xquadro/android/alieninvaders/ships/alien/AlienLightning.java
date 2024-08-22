package com.xquadro.android.alieninvaders.ships.alien;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;


public class AlienLightning  {
	public final Vector2 position;
	public final float width;
	public final float height;
	public float angle;
	
	public float stateTime = 0;
	
	public AlienLightning(float x, float y, float width, float height, float sx) {
		this.position = new Vector2(x, y);
		this.width = width;
		this.height = height;
		angle = 0;
	}
	

	public AlienLightning (float fromX, float fromY, float toX, float toY) {
		float x = toX - fromX;
		float y = toY - fromY;
		this.height = 0.19f;
		this.width = (float)Math.sqrt(x * x + y * y);
		
		float originX = fromX + x/2;
		float originY = fromY + y/2;
		this.position = new Vector2(originX, originY);

		angle = (float)Math.atan2(y, x) * MathUtils.radiansToDegrees;
		if (angle < 0) angle += 360;
	}
	
	
	
	
	public void update (float deltaTime) {		
		stateTime += deltaTime;
	}
}
