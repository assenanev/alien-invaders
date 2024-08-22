package com.xquadro.android.alieninvaders.celestial;

public class Vortex extends Planet {

	public Vortex(CelestialBody star, float initialSateliteAngle) {
		//super(35, initialSateliteAngle, 4, Celestial.VORTEX, star);
		super(35, 0, 4, Celestial.VORTEX, star, true);
		this.rotationSpeed = -15;
		this.sateliteRotationSpeed = 0.5f;
	}

}