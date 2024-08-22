package com.xquadro.android.alieninvaders.celestial;

public class SpaceStation extends Planet {

	public SpaceStation(CelestialBody star) {
		super(25, 0, 4, Celestial.SPACE_STATION, star, true);
		this.rotationSpeed = 5;
		this.sateliteRotationSpeed = 0.1f;
	}

}