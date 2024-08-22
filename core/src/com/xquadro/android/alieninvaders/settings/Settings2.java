package com.xquadro.android.alieninvaders.settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Settings2 {
	public static final Preferences prefs = Gdx.app.getPreferences(".alieninvades");
	public static boolean soundEnabled = true;
	public static boolean musicEnabled = true;
	public static boolean vibrateEnabled = true;
	
	public static void load() {
		boolean saveflag = false;
		if (!prefs.contains("soundEnabled")
				|| !prefs.contains("musicEnabled")
				|| !prefs.contains("vibrateEnabled")
				) {
			saveflag = true;
		}
		
		if (saveflag){
			save();
		}

		soundEnabled = prefs.getBoolean("soundEnabled", true);
		musicEnabled = prefs.getBoolean("musicEnabled", true);
		vibrateEnabled = prefs.getBoolean("vibrateEnabled", true);		
	}

	public static void save() {
		prefs.putBoolean("soundEnabled", soundEnabled);
		prefs.putBoolean("musicEnabled", musicEnabled);
		prefs.putBoolean("vibrateEnabled", vibrateEnabled);
		prefs.flush();
	}
}
