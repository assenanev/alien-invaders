package com.xquadro.android.alieninvaders.celestial;



public class Star extends CelestialBody {

	public Star(float x, float y, float diameter, Celestial type) {		
		super(x, y, diameter);
		textureId = type;
	}

}
