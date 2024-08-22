package com.xquadro.android.alieninvaders.ships.alien;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class AlienModule {
	
	public final Vector2 position;
	public final Rectangle bounds;
	public float angle;

	public static enum Type { ENGINE, HULL, TURRET_BASE};
	
	public Type type;

	public AlienModule(float x, float y, float width, float height) {
		this.position = new Vector2(x, y);
		this.bounds = new Rectangle(x - width / 2, y - height / 2, width, height);
		angle = 0;
	}
}
