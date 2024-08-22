package com.xquadro.android.alieninvaders.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.xquadro.android.alieninvaders.celestial.CelestialBody;
import com.xquadro.android.alieninvaders.celestial.SpaceStation;
import com.xquadro.android.alieninvaders.celestial.Vortex;
import com.xquadro.android.alieninvaders.ships.Ship;
import com.xquadro.android.alieninvaders.ships.alien.AlienShip;
import com.xquadro.android.alieninvaders.ships.earthships.EarthShip;

public class RadarRenderer {
	OrthographicCamera cam;
	SpriteBatch batch;
	Color tempColor;
	
	AssetManager assetManager;
	TextureAtlas atlas;
	
	float dotWidth = 15f;
	//int yOffset = 1050;
	int yOffset = 530;
	
	World world;

	public RadarRenderer(World world, SpriteBatch batcher, AssetManager assetManager) {
		this.world = world;
		this.assetManager = assetManager;
		this.atlas = assetManager.get("data/atlases/ai.atlas",
				TextureAtlas.class);
		float mapWidth = World.WORLD_WIDTH;
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		float aspect = w / h;
		this.cam = new OrthographicCamera(mapWidth, mapWidth/aspect);		
		this.cam.position.set(mapWidth/2, (mapWidth)/2 + yOffset, 0);
		this.cam.zoom = 11.5f;
		this.batch = batcher;
		tempColor = batch.getColor();
	}


	public void render(float deltaTime) {

		cam.update();
		batch.enableBlending();
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		batch.setColor(1,1,1,0.2f);
		batch.setColor(1,1,1,1f);
		batch.setColor(0.6f,0.6f,0.6f,1);
		renderSystem();
		batch.setColor(1f,0f,1f,1);
		renderSpaceStation();
		batch.setColor(1,0,0,1);
		renderAliens();
		batch.setColor(1f,1f,0f,1);
		renderVortex();
		batch.setColor(0,1,1,1);
		renderEarthShip();
		batch.setColor(tempColor);
		batch.end();
	}
	

	public void renderSystem (){
		int len = world.system.size();
		for(int i = 0; i < len; i++){
			CelestialBody s = world.system.get(i);
			batch.draw(atlas.findRegion("smallCircle"), s.position.x - dotWidth/2, s.position.y- dotWidth/2, dotWidth, dotWidth);
		}
	}
	
	void renderSpaceStation() {
		if (world.spaceStation != null) {
			SpaceStation s = world.spaceStation;
			batch.draw(atlas.findRegion("smallCircle"), s.position.x - dotWidth/2, s.position.y- dotWidth/2, dotWidth, dotWidth);
		}
	}
	
	void renderVortex() {
		if (world.vortex != null) {
			Vortex v = world.vortex;
			batch.draw(atlas.findRegion("smallCircle"), v.position.x - dotWidth/2, v.position.y- dotWidth/2, dotWidth, dotWidth);
		}
	}

	
	void renderEarthShip(){	
		EarthShip ship = world.ship;
		if(ship.state != Ship.State.DEAD){
			batch.draw(atlas.findRegion("smallCircle"), ship.position.x - dotWidth/2, ship.position.y- dotWidth/2, dotWidth, dotWidth);
		}
	}
	
	void renderAliens() {
		int count = world.alienShips.size();
		for(int i = 0; i < count; i++) {
			AlienShip as = world.alienShips.get(i);
			renderAlienShip(as);			
		}
	}
	
	void renderAlienShip(AlienShip alienShip){
		if(alienShip.state != Ship.State.DEAD){
			batch.draw(atlas.findRegion("smallCircle"), alienShip.position.x - dotWidth/2, alienShip.position.y- dotWidth/2, dotWidth, dotWidth);
		}
	}
	
}


