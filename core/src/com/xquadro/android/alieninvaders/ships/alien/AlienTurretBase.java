package com.xquadro.android.alieninvaders.ships.alien;

public class AlienTurretBase extends AlienModule {
	public static final float ALIENTURRETBASE_WIDTH = 0.19f;
	public static final float ALIENTURRETBASE_HEIGHT = 0.165f;

	public AlienTurretBase(float x, float y) {
		super(x, y, ALIENTURRETBASE_WIDTH, ALIENTURRETBASE_HEIGHT);
		type = Type.TURRET_BASE;
	}
}
