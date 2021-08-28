package com.nonesoft.tutorial.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.nonesoft.tutorial.Tutorial;
import lombok.val;

public class DesktopLauncher {
	public static void main (String[] arg) {
		val config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(1024, 768);
		new Lwjgl3Application(new Tutorial(), config);
	}
}
