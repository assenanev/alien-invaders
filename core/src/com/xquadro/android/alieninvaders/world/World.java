package com.xquadro.android.alieninvaders.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.xquadro.android.alieninvaders.celestial.CelestialBody;
import com.xquadro.android.alieninvaders.celestial.SpaceStation;
import com.xquadro.android.alieninvaders.celestial.Star;
import com.xquadro.android.alieninvaders.celestial.SystemFactory;
import com.xquadro.android.alieninvaders.celestial.Vortex;
import com.xquadro.android.alieninvaders.levels.Level;
import com.xquadro.android.alieninvaders.settings.Player;
import com.xquadro.android.alieninvaders.ships.Ship;
import com.xquadro.android.alieninvaders.ships.Ship.ShipClass;
import com.xquadro.android.alieninvaders.ships.ShipFactory;
import com.xquadro.android.alieninvaders.ships.alien.AlienShip;
import com.xquadro.android.alieninvaders.ships.earthships.EarthShip;
import com.xquadro.android.alieninvaders.ships.weapons.Projectile;
import com.xquadro.android.alieninvaders.ships.weapons.ProjectilePool;

public class World {	
	public enum State {
		RUNNING, ENDING, ENDED
	};
	
	public interface WorldListener {
		public void earthShot();
		public void alienShot();
		public void earthHit();
		public void alienHit();
		public void earthExplode();
		public void alienExplode();
		public void sweep();
	}

	public static final float WORLD_WIDTH = 250;
	public static final float WORLD_HEIGHT = 250;
	
	public WorldListener listener;
	AssetManager assetManager;

	public final List<CelestialBody> system;
	public final List<AlienShip> alienShips;
	public EarthShip ship = null;
	

	public State state = State.ENDED;
	
	public ProjectilePool projectilePool;
	public final List<Projectile> projectiles;

	public final Random rand;
	
	SpaceStation spaceStation = null;
	Vortex vortex;
	
	float aspect;
	
	public boolean stationProximity = false;
	public boolean vortexProximity = false;
	
	ParticleEffectPool bulletFXPool;
	Array<PooledEffect> bulletFX = new Array<PooledEffect>();
	ParticleEffectPool explosionFXPool;
	Array<PooledEffect> explosionFX = new Array<PooledEffect>();
	
	Vector2 tempVector = new Vector2();
	
	Level lvl = null;
	
	public boolean earthShipAutoFire = false;
	
	protected World(){
		rand = new Random();
		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		aspect = w / h;

		this.system = new ArrayList<CelestialBody>();		
		this.alienShips = new ArrayList<AlienShip>();
		this.projectilePool = new ProjectilePool();
		this.projectiles = new ArrayList<Projectile>();

		state = State.RUNNING;
	}
	
	public World(WorldListener listener, Level lvl, AssetManager assetManager) {
		this();
		
		this.listener = listener;
		this.lvl = lvl;
		this.assetManager = assetManager;
		
		prepareParticles();
		createSystem();
		createShip();
		createAliens();
	}
	
	void prepareParticles(){
		ParticleEffect bulletEffect = new ParticleEffect();
		bulletEffect.load(Gdx.files.internal("data/pe/small.p"), assetManager.get("data/atlases/ai.atlas",
				TextureAtlas.class));
		bulletFXPool = new ParticleEffectPool(bulletEffect, 1, 500);
		
		ParticleEffect explosionEffect = new ParticleEffect();
		explosionEffect.load(  Gdx.files.internal("data/pe/big.p"), assetManager.get("data/atlases/ai.atlas",
				TextureAtlas.class));
		explosionFXPool = new ParticleEffectPool(explosionEffect, 1, 200);
	}
	
	protected void createShip() {
		ShipClass sc = Player.getInstance().getActiveShip();
		if(lvl.isEarth()){
			ship = ShipFactory.getEarthShip(this, sc, World.WORLD_WIDTH/2+28, World.WORLD_HEIGHT/2);
		} else {
			ship = ShipFactory.getEarthShip(this, sc, vortex.position.x, vortex.position.y);
		}
		ship.hitPoints = Player.getInstance().getShipHealth(sc);		
	}
	
	public void createAliens(){
		if(Player.getInstance().isLevelAlien(lvl)){
			createAlien(lvl.getCountAlienKamikaze(), Ship.ShipClass.KAMIKAZE);
			createAlien(lvl.getCountAlienFighter(), Ship.ShipClass.FIGHTER);
			createAlien(lvl.getCountAlienCorvette(), Ship.ShipClass.CORVETTE);
			createAlien(lvl.getCountAlienDestroyer(), Ship.ShipClass.DESTROYER);
			createAlien(lvl.getCountAlienFrigate(), Ship.ShipClass.FRIGATE);
			createAlien(lvl.getCountAlienLightCruiser(), Ship.ShipClass.LIGHTCRUISER);
			createAlien(lvl.getCountAlienHeavyCruiser(), Ship.ShipClass.HEAVYCRUISER);
			createAlien(lvl.getCountAlienBattleCruiser(), Ship.ShipClass.BATTLECRUISER);
			createAlien(lvl.getCountAlienBattleShip(), Ship.ShipClass.BATTLESHIP);
			createAlien(lvl.getCountAlienDreadnought(), Ship.ShipClass.DREADNOUGHT);
		}
	}

	public void createAlien(int count, Ship.ShipClass shipClass){	
		float posX, posY;
		float availableWidth, availableHeight;
		float spread = 0.7f;
		for (int i = 0; i < count; i++){
			AlienShip ab;
			availableWidth = World.WORLD_WIDTH - WorldRenderer.FRUSTUM_WIDTH;
			availableHeight = World.WORLD_HEIGHT - WorldRenderer.FRUSTUM_WIDTH * aspect;
			posX = availableWidth * spread * rand.nextFloat() + availableWidth * (1-spread)/2;
			posY = availableHeight * spread * rand.nextFloat() + availableHeight * (1-spread)/2;

			ab = ShipFactory.getAlienShip(this, shipClass, posX, posY);
			alienShips.add(ab);
		}
	}
	
	public void createSystem(){

		Star star = SystemFactory.fillSystem(lvl.getLevelName(), system, rand);
		
		vortex = new Vortex(star, 40 * rand.nextFloat()-20);
		if(lvl.isEarth()){
			spaceStation = new SpaceStation(star);
		}


	}

	
	public void update(float deltaTime, float knobPercentX, float knobPercentY, float weaponKnobPercentX, float weaponKnobPercentY, boolean knobIsTouched) {
		updateSystem(deltaTime);
		updateEarthShip(deltaTime, knobPercentX, knobPercentY, weaponKnobPercentX, weaponKnobPercentY, knobIsTouched, earthShipAutoFire);
		updateAliens(deltaTime);
		updateProjectiles(deltaTime);
		updateBulletFX(deltaTime);
		updateExplosionFX(deltaTime);
	}
	
	
	
	public void updateSystem(float deltaTime) {
		int len = system.size();
		for(int i = 0; i < len; i++){
			CelestialBody s = system.get(i);
			s.update(deltaTime);
		}
		
		if(spaceStation != null){
			spaceStation.update(deltaTime);
		}
		
		if(vortex != null){
			vortex.update(deltaTime);
		}
		
	}
	
	public void updateAliens(float deltaTime) {

		for(int i = alienShips.size() - 1; i >= 0; i--){
			AlienShip as = alienShips.get(i);
			switch (as.state) {
			case ALIVE:
				as.update(deltaTime);
				break;
			case EXPLODE:
				PooledEffect effect = explosionFXPool.obtain();
				effect.setPosition(as.position.x, as.position.y);
				explosionFX.add(effect);
				as.state = Ship.State.DEAD;
				Player.getInstance().addUnobtanium(as.killCoins);
				listener.alienExplode();
				break;
			case DEAD:

			default:
				alienShips.remove(i);
				if(alienShips.size() == 0){
					Player.getInstance().saveLevel(lvl, false);
					Player.getInstance().addUnobtanium(25);
					Player.getInstance().saveUnobtanium();
				}
				break;
			}

		}
		
	}
	
	public void updateProjectiles(float deltaTime) {
		for(int i = projectiles.size() - 1; i >= 0; i--){
			Projectile p = projectiles.get(i);
			switch (p.state) {
			case FIRED:
				p.update(deltaTime);
				break;
			case EXPLODED:
				PooledEffect effect = bulletFXPool.obtain();
				effect.setPosition(p.position.x, p.position.y);
				bulletFX.add(effect);
				p.state = Projectile.State.DEAD;
				if(p.alien){
					listener.earthHit();
				}else {
					listener.alienHit();
				}
				break;
			case DEAD:;
			default:
				projectiles.remove(i);
				projectilePool.free(p);
				break;
			}		
		}
	}
	
	public void updateBulletFX(float deltaTime) {
		for (int i = bulletFX.size - 1; i >= 0; i--) {
			PooledEffect effect = bulletFX.get(i);
			effect.update(deltaTime);
			if (effect.isComplete()) {
				effect.free();
				bulletFX.removeIndex(i);
		   }
		}
	}
	
	public void updateExplosionFX(float deltaTime) {
		for (int i = explosionFX.size - 1; i >= 0; i--) {
			PooledEffect effect = explosionFX.get(i);
			effect.update(deltaTime);
			if (effect.isComplete()) {
				effect.free();
				explosionFX.removeIndex(i);
		   }
		}
		if(state == State.ENDING && explosionFX.size == 0){
			state = State.ENDED;
		}
	}
	
	public void resetBulletFX(){

		for (int i = bulletFX.size - 1; i >= 0; i--){
			 bulletFX.get(i).free();
		}
		bulletFX.clear();
	}
	
	public void resetExplosionFX() {
		for (int i = explosionFX.size - 1; i >= 0; i--){
			explosionFX.get(i).free();
		}
		explosionFX.clear();
	}

	protected void updateEarthShip(float deltaTime, float knobPercentX, float knobPercentY, float weaponKnobPercentX, float weaponKnobPercentY, boolean openFire, boolean autoFire) {
		ship.update(deltaTime, knobPercentX, knobPercentY, weaponKnobPercentX, weaponKnobPercentY, openFire, autoFire);
		switch (ship.state) {
		case ALIVE:
			ship.update(deltaTime);
			tempVector.set(ship.position); 
			if(spaceStation!=null && tempVector.sub(spaceStation.position).len2() < 4 * 4) {
				if(!stationProximity){
					listener.sweep();
				}
				stationProximity = true;
			} else {
				stationProximity = false;
			}
			
			tempVector.set(ship.position);
			if(vortex!=null && tempVector.sub(vortex.position).len2() < 4 * 4) {
				if(!vortexProximity){
					listener.sweep();
				}
				vortexProximity = true;
			} else {
				vortexProximity = false;
			}
			
			break;
		case EXPLODE:
			PooledEffect effect = explosionFXPool.obtain();
			effect.setPosition(ship.position.x, ship.position.y);
			explosionFX.add(effect);
			ship.state = Ship.State.DEAD;
			ship.stateTime = 0;
			listener.earthExplode();
			break;
		case DEAD:

		default:
			//TODO
//			ship.state = Ship.State.ALIVE;
			state = State.ENDING;
			ship.hitPoints = ship.hitPointsMax;
			Player.getInstance().setShipHealth(ship.shipClass, ship.hitPoints);
			break;
		}
			
	}
	
	public void clear() {
		
		system.clear();
		alienShips.clear();
		resetBulletFX();
		resetExplosionFX();
	}

}



