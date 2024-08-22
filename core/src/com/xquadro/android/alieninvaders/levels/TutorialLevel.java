package com.xquadro.android.alieninvaders.levels;

public class TutorialLevel extends Level {

	public TutorialLevel() {
		this.levelName = LevelName.SUN;
		this.name = "Tutorial";
		this.positionX = -1;
		this.positionY = -1;
		this.isEarth = true;
		this.difficulty = Difficulty.EASY;
		this.countAlienKamikaze = 0;
		this.countAlienFighter = 1;
		this.countAlienCorvette = 0;
		this.countAlienDestroyer = 0;
		this.countAlienFrigate = 0;
		this.countAlienLightCruiser = 0;
		this.countAlienHeavyCruiser = 0;
		this.countAlienBattleCruiser = 0;
		this.countAlienBattleShip = 0;
		this.countAlienDreadnought = 0;
	}
	
	
}
