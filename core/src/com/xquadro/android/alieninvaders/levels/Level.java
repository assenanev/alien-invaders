package com.xquadro.android.alieninvaders.levels;

public class Level {
	
	public enum LevelName {
		SUN, BETA_CENTAURI, PROCYON, ALTAIR, ELNATH, NAOS, ALCHIBA, 
		SYRMA, TARAZED, ALKALUROPS, AVIOR, MIRA, CAPELLA, REGEL, 
		ACHERNAR, ALDEBARAN, FOMALHAUT, ALPHA_CRUCIS, BETA_CRUCIS, 
		GRAFIAS, MARFAK, SEGIN, CANOPUS, THABIT, TEGMINE, SIRIUS, 
		ALPHA_CENTAURI, VEGA, ADHAFERA, BETELGEUSE, SPICA, ANTARES, 
		POLLUX, DENEB, ALRAI, TURAIS, ARCTURUS, BELLATRIX, CASTOR, 
		ELECTRA, KEID, SHARATAN, REGULUS, MIMOSA, WEZEN, PISCES, 
		ARIES, FURUD, NUSAKAN, MINKAR
	}
	
	public enum Difficulty {EASY, MEDIUM, HARD};
	protected LevelName levelName = LevelName.SUN;

	protected String name;
	protected float positionX;
	protected float positionY;
	protected boolean isEarth;
	
	protected Difficulty difficulty = Difficulty.HARD;

	protected int countAlienKamikaze;
	protected int countAlienFighter;
	protected int countAlienCorvette;
	protected int countAlienDestroyer;
	protected int countAlienFrigate;
	protected int countAlienLightCruiser;
	protected int countAlienHeavyCruiser;
	protected int countAlienBattleCruiser;
	protected int countAlienBattleShip;
	protected int countAlienDreadnought;
	
	
	public LevelName getLevelName() {
		return levelName;
	}

	public void setLevelName(LevelName levelName) {
		this.levelName = levelName;
	}
	
	public Difficulty getDifficulty() {
		return difficulty;
	}
	
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public float getPositionX() {
		return positionX;
	}
	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}
	public float getPositionY() {
		return positionY;
	}
	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}
	public boolean isEarth() {
		return isEarth;
	}
	public void setEarth(boolean isEarth) {
		this.isEarth = isEarth;
	}
	public int getCountAlienKamikaze() {
		return countAlienKamikaze;
	}
	public void setCountAlienKamikaze(int countAlienKamikaze) {
		this.countAlienKamikaze = countAlienKamikaze;
	}
	public int getCountAlienFighter() {
		return countAlienFighter;
	}
	public void setCountAlienFighter(int countAlienFighter) {
		this.countAlienFighter = countAlienFighter;
	}
	public int getCountAlienCorvette() {
		return countAlienCorvette;
	}
	public void setCountAlienCorvette(int countAlienCorvette) {
		this.countAlienCorvette = countAlienCorvette;
	}
	public int getCountAlienDestroyer() {
		return countAlienDestroyer;
	}
	public void setCountAlienDestroyer(int countAlienDestroyer) {
		this.countAlienDestroyer = countAlienDestroyer;
	}
	public int getCountAlienFrigate() {
		return countAlienFrigate;
	}
	public void setCountAlienFrigate(int countAlienFrigate) {
		this.countAlienFrigate = countAlienFrigate;
	}
	public int getCountAlienLightCruiser() {
		return countAlienLightCruiser;
	}
	public void setCountAlienLightCruiser(int countAlienLightCruiser) {
		this.countAlienLightCruiser = countAlienLightCruiser;
	}
	public int getCountAlienHeavyCruiser() {
		return countAlienHeavyCruiser;
	}
	public void setCountAlienHeavyCruiser(int countAlienHeavyCruiser) {
		this.countAlienHeavyCruiser = countAlienHeavyCruiser;
	}
	public int getCountAlienBattleCruiser() {
		return countAlienBattleCruiser;
	}
	public void setCountAlienBattleCruiser(int countAlienBattleCruiser) {
		this.countAlienBattleCruiser = countAlienBattleCruiser;
	}
	public int getCountAlienBattleShip() {
		return countAlienBattleShip;
	}
	public void setCountAlienBattleShip(int countAlienBattleShip) {
		this.countAlienBattleShip = countAlienBattleShip;
	}
	public int getCountAlienDreadnought() {
		return countAlienDreadnought;
	}
	public void setCountAlienDreadnought(int countAlienDreadnought) {
		this.countAlienDreadnought = countAlienDreadnought;
	}
}
