package com.xquadro.android.alieninvaders.world;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.xquadro.android.alieninvaders.celestial.SpaceStation;
import com.xquadro.android.alieninvaders.celestial.Vortex;

public class TutorialWorldRenderer extends WorldRenderer {
	public boolean changeStationColor = false;
	public boolean changeVortexColor = false;

	public TutorialWorldRenderer(World world, SpriteBatch batcher,
			AssetManager assetManager) {
		super(world, batcher, assetManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void renderSpaceStation() {
		if(changeStationColor){
			batch.setColor(0.7f,1f,0.3f,1);
		}
		if (world.spaceStation != null) {
			SpaceStation ss = world.spaceStation;

			batch.draw(getCelestialTexture(ss.textureId), ss.position.x
					- ss.diameter / 2, ss.position.y - ss.diameter / 2,
					ss.diameter / 2, ss.diameter / 2, ss.diameter, ss.diameter,
					1, 1, ss.angle);
		}
		batch.setColor(1,1,1,1);
	}

	@Override
	protected void renderVortex() {
		if(changeVortexColor){
			batch.setColor(1,1f,0f,1);
		}
		if (world.vortex != null) {
			Vortex v = world.vortex;

			batch.draw(getCelestialTexture(v.textureId), v.position.x
					- v.diameter / 2, v.position.y - v.diameter / 2,
					v.diameter / 2, v.diameter / 2, v.diameter, v.diameter,
					1, 1, v.angle);
		}
		batch.setColor(1,1,1,1);
	}

}
