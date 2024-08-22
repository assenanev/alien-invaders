package com.xquadro.android.alieninvaders.screens;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.xquadro.android.alieninvaders.levels.Level;

public class HyperjumpScreen extends AbstractScreen {
	public enum State {BEFORE_JUMP, JUMP, AFTER_JUMP};
	
	public static TextureAtlas atlas;
	
	Animation hyperJump;

	private float stateTime = 0;
	private State state = State.BEFORE_JUMP;
	
	boolean toSystem;
	
	Level level;

	public HyperjumpScreen (AlienInvadersGame alienInvadersGame, boolean toSystem, Level lvl) {
		super(alienInvadersGame, "data/stars.png");
		this.toSystem = toSystem;
		this.level = lvl;

		atlas = game.assetManager.get("data/atlases/hyper.atlas", TextureAtlas.class);
		hyperJump = new Animation(0.025f, atlas.findRegions("hyper"), Animation.PlayMode.LOOP_PINGPONG);
		
	}

	@Override
	void goToPrevScreen() {
		if (!toSystem) {
			game.setScreen(new MainScreen(game));		
		} else {
			game.setScreen(new NavigationScreen(game));
		}
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		super.render(delta);
		stateTime += delta;

		update();
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		switch (state) {
		case BEFORE_JUMP:
			batch.draw(hyperJump.getKeyFrame(0), 0, (game.height - game.width) /2, game.width, game.width);
			break;

		case JUMP:
			batch.draw(hyperJump.getKeyFrame(stateTime), 0, (game.height - game.width) /2, game.width, game.width);
			break;

		case AFTER_JUMP:
		default:
			batch.draw(hyperJump.getKeyFrame(0), 0, (game.height - game.width) /2, game.width, game.width);
			break;

		}
		batch.end();
	}
	
	private void update() {
		switch (state) {
		case BEFORE_JUMP:
			updateBeforeJump();
			break;
			
		case JUMP:
			updateJump();
			break;	

		case AFTER_JUMP:
		default:
			updateAfterJump();
			break;
		}
		
	}

	private void updateBeforeJump() {
		if (stateTime > 0.3f){
			state = State.JUMP;
			stateTime = 0;
		}	
	}
	
	private void updateJump() {
		if (stateTime > 0.25f){
			state = State.AFTER_JUMP;
			stateTime = 0;
		}	
	}
	
	private void updateAfterJump() {
		if (stateTime > 0.3f){
			if(toSystem){
				game.setScreen(new GameScreen(game, level));
			} else {
				game.setScreen(new NavigationScreen(game));
			}
		}	
	}

}
