package com.xquadro.android.alieninvaders.ships.alien;

public class AlienHull extends AlienModule {
	public static final float ALIENHULL_WIDTH = 0.25f;
	public static final float ALIENHULL_HEIGHT = 0.25f;

	public AlienHull(float x, float y) {
		super(x, y, ALIENHULL_WIDTH, ALIENHULL_HEIGHT);
		type = Type.HULL;
	}
}
