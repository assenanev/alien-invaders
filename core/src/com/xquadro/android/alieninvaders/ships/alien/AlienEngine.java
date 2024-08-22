package com.xquadro.android.alieninvaders.ships.alien;

public class AlienEngine extends AlienModule {
	public static final float WIDTH = 0.27f;
	public static final float HEIGHT = 0.25f;

	public AlienEngine(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		type = Type.ENGINE;
	}
}
