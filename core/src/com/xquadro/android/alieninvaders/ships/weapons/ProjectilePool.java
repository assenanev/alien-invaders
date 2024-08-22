package com.xquadro.android.alieninvaders.ships.weapons;

import com.badlogic.gdx.utils.Pool;

public class ProjectilePool extends Pool<Projectile> {

	@Override
	protected Projectile newObject() {
		Projectile projectile = new Projectile();
		return projectile;
	}

}
