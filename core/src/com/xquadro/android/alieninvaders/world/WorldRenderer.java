package com.xquadro.android.alieninvaders.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.xquadro.android.alieninvaders.celestial.CelestialBody;
import com.xquadro.android.alieninvaders.celestial.SpaceStation;
import com.xquadro.android.alieninvaders.celestial.Vortex;
import com.xquadro.android.alieninvaders.ships.Ship;
import com.xquadro.android.alieninvaders.ships.Ship.ShipClass;
import com.xquadro.android.alieninvaders.ships.alien.AlienLightning;
import com.xquadro.android.alieninvaders.ships.alien.AlienModule;
import com.xquadro.android.alieninvaders.ships.alien.AlienShip;
import com.xquadro.android.alieninvaders.ships.earthships.EarthShip;
import com.xquadro.android.alieninvaders.ships.weapons.Projectile;
import com.xquadro.android.alieninvaders.ships.weapons.Projectile.State;
import com.xquadro.android.alieninvaders.ships.weapons.Turret;

public class WorldRenderer {
	public static final float FRUSTUM_WIDTH = 15;
	public final float frustum_height;
	OrthographicCamera cam;
	SpriteBatch batch;
	Color tempColor;
	
	World world;
	
	AssetManager assetManager;
	TextureAtlas atlas;
	
	Animation lightningAnim;
	
	TiledMap tiledMap;
	OrthogonalTiledMapRenderer tileRenderer;
	float pixelToScreen;
	
	public WorldRenderer(World world, SpriteBatch batcher, AssetManager assetManager) {

		this.world = world;
		this.assetManager = assetManager;
		this.atlas = assetManager.get("data/atlases/ai.atlas",
				TextureAtlas.class);
		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		float aspect = w / h;
		pixelToScreen = FRUSTUM_WIDTH/Gdx.graphics.getWidth();
		
		lightningAnim = new Animation(0.15f, atlas.findRegions("lightning"), Animation.PlayMode.LOOP_PINGPONG);
		
		frustum_height = FRUSTUM_WIDTH/aspect;
		this.cam = new OrthographicCamera(FRUSTUM_WIDTH, FRUSTUM_WIDTH/aspect);		
		this.cam.position.set(this.world.ship.position.x, this.world.ship.position.y, 0);
		this.batch = batcher;
		tempColor = batch.getColor();
		
		this.tiledMap = assetManager.get("data/tiles/stars250.tmx");
		tileRenderer = new OrthogonalTiledMapRenderer(tiledMap, 1 / 64f);
	}

	public void render(float deltaTime) {

		cam.position.set(world.ship.position.x, world.ship.position.y, 0);
		cam.update();
		batch.enableBlending();
		batch.setProjectionMatrix(cam.combined);
		tileRenderer.setView(cam);
		tileRenderer.render();
		batch.begin();


		renderSystem();
		renderSpaceStation();
		renderVortex();
		
		renderAliens();
		renderEarthShip();
		
		renderProjectiles();
		renderBulletFX(deltaTime);
		renderExplosionFX(deltaTime);
		batch.end();
	}

	public void renderSystem (){
		int len = world.system.size();
		for(int i = 0; i < len; i++){
			CelestialBody s = world.system.get(i);
			
			batch.draw (getCelestialTexture(s.textureId), s.position.x - s.diameter/2, s.position.y- s.diameter/2,
					s.diameter/2, s.diameter/2,
					s.diameter, s.diameter,
					1, 1, s.angle);
		}
	}

	protected void renderSpaceStation() {
		if (world.spaceStation != null) {
			SpaceStation ss = world.spaceStation;

			batch.draw(getCelestialTexture(ss.textureId), ss.position.x
					- ss.diameter / 2, ss.position.y - ss.diameter / 2,
					ss.diameter / 2, ss.diameter / 2, ss.diameter, ss.diameter,
					1, 1, ss.angle);
		}
	}
	
	protected void renderVortex() {
		if (world.vortex != null) {
			Vortex v = world.vortex;

			batch.draw(getCelestialTexture(v.textureId), v.position.x
					- v.diameter / 2, v.position.y - v.diameter / 2,
					v.diameter / 2, v.diameter / 2, v.diameter, v.diameter,
					1, 1, v.angle);
		}
	}
	
	void renderEarthShip(){
		EarthShip ship = world.ship;
		if (ship.state == Ship.State.ALIVE)
			renderEarthShipAlive(ship);
	}
	
	public static String getEarthShipRegionName(ShipClass shipClass){
		String name;
		switch (shipClass) {
		case CORVETTE:
			name = "corvette";
			break;
		case DESTROYER:
			name = "destroyer";
			break;
		case FRIGATE:
			name = "frigate";
			break;
		case LIGHTCRUISER:
			name = "lightCruiser";
			break;
		case HEAVYCRUISER:
			name = "heavyCruiser";
			break;
		case BATTLECRUISER:
			name = "battleCruiser";
			break;
		case BATTLESHIP:
			name = "battleShip";
			break;
		case DREADNOUGHT:
			name = "dreadnought";
			break;
		case FIGHTER:
		default:
			name = "fighter";
			break;
		}
		return name;
	}
	
	void renderEarthShipAlive(EarthShip ship){		
		
		AtlasRegion ar = atlas.findRegion(getEarthShipRegionName(ship.shipClass));

		batch.draw (ar, 
				ship.position.x - ship.width/2, 
				ship.position.y - ship.height/2,
				ship.width/2,ship.height/2,
				ship.width, ship.height,
				1, 1, 
				ship.angle);
		
		int count = ship.turrets.size();
		AtlasRegion tr;
		for (int i = 0; i < count; i++){
			Turret t = ship.turrets.get(i);
			float tx = MathUtils.cosDeg(ship.angle) * (t.position.x) - MathUtils.sinDeg(ship.angle) * (t.position.y);
			float ty = MathUtils.sinDeg(ship.angle) * (t.position.x) + MathUtils.cosDeg(ship.angle) * (t.position.y);
			
			switch (t.type) {
			case MACHINE_GUN:
				tr = atlas.findRegion("turretMachineGun");
				break;
			case LASER_CANNON:
				tr = atlas.findRegion("turretLaser");
				break;
			case PLASMA_BLASTER:
			default:
				tr = atlas.findRegion("turretPlasmaEarth");
				break;
			}
			
			batch.draw (tr, 
					ship.position.x + tx - t.width/2,
					ship.position.y + ty - t.height/2,
					t.width/2, t.height/2,
					t.width, t.height,
					1, 1, 
					t.angle);
		}
		
	}
	
	public void renderBulletFX(float deltaTime) {
		for (int i = world.bulletFX.size - 1; i >= 0; i--) {
			PooledEffect effect = world.bulletFX.get(i);
			effect.draw(batch, deltaTime);
		}
	}
	
	public void renderExplosionFX(float deltaTime) {
		for (int i = world.explosionFX.size - 1; i >= 0; i--) {
			PooledEffect effect = world.explosionFX.get(i);
			effect.draw(batch, deltaTime);
		}
	}
	void renderAliens() {
		int count = world.alienShips.size();
		for(int i = 0; i < count; i++) {
			AlienShip as = world.alienShips.get(i);
			switch (as.state) {
			case ALIVE:
				renderAlienShip(as);
				break;
			case EXPLODE:
				break;
			default:
				break;
			}
						
		}
	}

	void renderProjectiles() {
		batch.setColor(1, 0.8f, 0.8f, 1);
		int count = world.projectiles.size();
		for(int i = 0; i < count; i++) {
			Projectile p = world.projectiles.get(i);
			AtlasRegion ar;
			
			if (p.state == State.FIRED){
			
			switch (p.type) {
			case BULLET:
				ar = p.alien?atlas.findRegion("bulletAlien"):atlas.findRegion("bulletEarth");
				break;
			case PLASMA:
				ar = p.alien?atlas.findRegion("plasmaAlien"):atlas.findRegion("plasmaEarth");
				break;
			case LASER:
			default:
				ar = p.alien?atlas.findRegion("laserAlien"):atlas.findRegion("laserEarth"); 
				break;
			}
			
			batch.draw (ar, 
					p.position.x - p.width/2, p.position.y - p.height/2,
					p.width/2, p.height/2,
					p.width, p.height,
					1, 1, 
					p.angle);
			}
		}
		batch.setColor(tempColor);
	}
	
	void renderAlienShip(AlienShip alienShip){
		int count = alienShip.lightnings.size();
		for (int i = 0; i < count; i++){
			AlienLightning al = alienShip.lightnings.get(i);
			float tx = MathUtils.cosDeg(alienShip.angle) * (al.position.x) - MathUtils.sinDeg(alienShip.angle) * (al.position.y);
			float ty = MathUtils.sinDeg(alienShip.angle) * (al.position.x) + MathUtils.cosDeg(alienShip.angle) * (al.position.y);
			
			batch.draw (lightningAnim.getKeyFrame(al.stateTime), 
					alienShip.position.x + tx - al.width/2,
					alienShip.position.y + ty - al.height/2,
					al.width/2, al.height/2,
					al.width, al.height,
					1, 1, 
					alienShip.angle+al.angle);
		}
		
		count = alienShip.modules.size();
		for (int i = 0; i < count; i++){
			AlienModule am = alienShip.modules.get(i);
			float tx = MathUtils.cosDeg(alienShip.angle) * (am.position.x) - MathUtils.sinDeg(alienShip.angle) * (am.position.y);
			float ty = MathUtils.sinDeg(alienShip.angle) * (am.position.x) + MathUtils.cosDeg(alienShip.angle) * (am.position.y);
			
			AtlasRegion ar;
			switch (am.type) {
			case ENGINE:
				ar = atlas.findRegion("alienEngine");				
				break;				
			case HULL:
				ar = atlas.findRegion("alienHull");
				break;
			case TURRET_BASE:
			default:
				ar = atlas.findRegion("alienModule");
				break;
			}

			batch.draw (ar, 
					alienShip.position.x + tx - am.bounds.width/2,
					alienShip.position.y + ty - am.bounds.height/2,
					am.bounds.width/2, am.bounds.height/2,
					am.bounds.width, am.bounds.height,
					1, 1, 
					alienShip.angle);
		}
		
		count = alienShip.turrets.size();
		AtlasRegion tr;
		for (int i = 0; i < count; i++){
			Turret t = alienShip.turrets.get(i);
			float tx = MathUtils.cosDeg(alienShip.angle) * (t.position.x) - MathUtils.sinDeg(alienShip.angle) * (t.position.y);
			float ty = MathUtils.sinDeg(alienShip.angle) * (t.position.x) + MathUtils.cosDeg(alienShip.angle) * (t.position.y);
			
			switch (t.type) {
			case MACHINE_GUN:
				tr = atlas.findRegion("turretMachineGun");
				break;
			case LASER_CANNON:
				tr = atlas.findRegion("turretLaser");
				break;
			case PLASMA_BLASTER:
			default:
				tr = atlas.findRegion("turretPlasmaAlien");
				break;
			}

			batch.draw (tr, 
					alienShip.position.x + tx - t.width/2,
					alienShip.position.y + ty - t.height/2,
					t.width/2, t.height/2,
					t.width, t.height,
					1, 1, 
					t.angle);
		}
		
		AtlasRegion hr = atlas.findRegion("smallRect2");
		float healthWidth = 0.6f;
		float healthHeight = 0.08f;
		float healthLeftRatio = (float) alienShip.hitPoints/alienShip.hitPointsMax;
		float healthWidthGreen = healthWidth*healthLeftRatio;
		float healthWigthRed = healthWidth - healthWidthGreen;
		batch.setColor(0,1,0,0.4f);
		batch.draw (hr, 
				alienShip.position.x - healthWidth/2, 
				alienShip.position.y + (alienShip.height/2)*1.5f,
				healthWidthGreen, healthHeight);
		
		batch.setColor(1,0,0,0.4f);
		batch.draw (hr, 
				alienShip.position.x - healthWidth/2 + healthWidthGreen, 
				alienShip.position.y + (alienShip.height/2)*1.5f,
				healthWigthRed, healthHeight);
		
		batch.setColor(1, 1, 1, 1);
	}
	
	public AtlasRegion getCelestialTexture(CelestialBody.Celestial id){
		AtlasRegion texture;
		switch (id) {
		case STAR_BLUE:
			texture = atlas.findRegion("starBlue");
			break;
		case STAR_CYAN:
			texture = atlas.findRegion("starCyan"); 
			break;
		case STAR_RED:
			texture = atlas.findRegion("starRed");
			break;
		case STAR_VIOLET:
			texture = atlas.findRegion("starViolet"); 
			break;
		case STAR_YELLOW:
			texture = atlas.findRegion("starYellow");
			break;
			
		case PLANET_0:
			texture = atlas.findRegion("planet0");
			break;
		case PLANET_1:
			texture = atlas.findRegion("planet1");
			break;
		case PLANET_2:
			texture = atlas.findRegion("planet2");
			break;
		case PLANET_3:
			texture = atlas.findRegion("planet3");
			break;
		case PLANET_4:
			texture = atlas.findRegion("planet4"); 
			break;
		case PLANET_5:
			texture = atlas.findRegion("planet5");
			break;
		case PLANET_6:
			texture = atlas.findRegion("planet6");
			break;
		case PLANET_7:
			texture = atlas.findRegion("planet7");
			break;
		case PLANET_CALISTO_0:
			texture = atlas.findRegion("planetCalisto0"); 
			break;
		case PLANET_CALISTO_1:
			texture = atlas.findRegion("planetCalisto1");
			break;
		case PLANET_CALISTO_GREEN:
			texture = atlas.findRegion("planetCalistoGreen"); 
			break;
		case PLANET_EARTH_GREEN:
			texture = atlas.findRegion("planetEarthGreen");
			break;
		case PLANET_EARTH:
			texture = atlas.findRegion("planetEarth");
			break;
		case PLANET_FOBOS:
			texture = atlas.findRegion("planetFobos");
			break;
		case PLANET_GANYMEDE:
			texture = atlas.findRegion("planetGanymede"); 
			break;
		case PLANET_IO:
			texture = atlas.findRegion("planetIo");
			break;
		case PLANET_JUPITER_0:
			texture = atlas.findRegion("planetJupiter0"); 
			break;
		case PLANET_JUPITER_1:
			texture = atlas.findRegion("planetJupiter1");
			break;
		case PLANET_JUPITER_2:
			texture = atlas.findRegion("planetJupiter2");
			break;
		case PLANET_MIMAS:
			texture = atlas.findRegion("planetMimas");
			break;
		case PLANET_MIRANDA:
			texture = atlas.findRegion("planetMiranda"); 
			break;
		case PLANET_MOON_0:
			texture = atlas.findRegion("planetMoon0");
			break;
		case PLANET_TRITON:
			texture = atlas.findRegion("planetTriton");
			break;
		case SPACE_STATION:
			texture = atlas.findRegion("station");
			break;
		case VORTEX:
			texture = atlas.findRegion("vortex");
			break;

		default:
			texture = atlas.findRegion("starBlue0");
			break;
		}
		return texture;
		
	}
	
}


