package com.github.boros41;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtraEnchants implements ModInitializer {
	public static final int ONE_SECOND = 20; // 20 ticks per second
	public static final String MOD_ID = "extra-enchants";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ExtraEnchantsRegistries.registerMod();
	}
}