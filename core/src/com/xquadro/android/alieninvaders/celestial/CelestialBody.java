package com.xquadro.android.alieninvaders.celestial;

import com.badlogic.gdx.math.Vector2;

public class CelestialBody {
	public enum Celestial { STAR_BLUE, STAR_CYAN, 
		STAR_RED, STAR_VIOLET, STAR_YELLOW,
		
		PLANET_0, PLANET_1, PLANET_2,
		PLANET_3, PLANET_4, PLANET_5,
		PLANET_6, PLANET_7, PLANET_CALISTO_0,
		PLANET_CALISTO_1, PLANET_CALISTO_GREEN, PLANET_EARTH_GREEN,
		PLANET_EARTH, PLANET_FOBOS, PLANET_GANYMEDE,
		PLANET_IO, PLANET_JUPITER_0, PLANET_JUPITER_1,
		PLANET_JUPITER_2, PLANET_MIMAS, PLANET_MIRANDA,
		PLANET_MOON_0, PLANET_TRITON, 
		
		SPACE_STATION, VORTEX};
		
	public final Vector2 position;
	public final float diameter;
	
	public Celestial textureId = Celestial.STAR_YELLOW;
	
	public float angle = 0;
	public float rotationSpeed = 5;

	public CelestialBody (float x, float y, float diameter) {
		this.position = new Vector2(x, y);
		this.diameter = diameter;
		//this.bounds = new Rectangle(-width / 2, -height / 2, width, height);
	}
	
	public void update(float deltaTime) {
		angle += rotationSpeed * deltaTime;		
	}
}
