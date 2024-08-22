package com.xquadro.android.alieninvaders.celestial;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Planet extends CelestialBody {
	public final Vector2 velocity;
	public final CelestialBody star;
	public float sateliteAngle = 0;
	public float sateliteRotationSpeed = 0;
	float orbitalRadius = 0;
	
	
	public Planet (float orbitalRadius,float initialSateliteAngle, float diameter, Celestial type, CelestialBody star, boolean rotationDirection) {
		super(star.position.x + orbitalRadius, star.position.y, diameter);

		this.sateliteAngle = initialSateliteAngle;
		this.star = star;
		this.orbitalRadius = orbitalRadius;
		sateliteRotationSpeed = rotationDirection ? 50/orbitalRadius : 50/orbitalRadius*(-1);
		velocity = new Vector2();
		textureId = type;
	}
	
	public void update(float deltaTime) {
		angle += rotationSpeed * deltaTime;	
		sateliteAngle += sateliteRotationSpeed * deltaTime;
		position.x = star.position.x + orbitalRadius * MathUtils.cosDeg(sateliteAngle);
		position.y = star.position.y + orbitalRadius * MathUtils.sinDeg(sateliteAngle);
	}
}
