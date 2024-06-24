package com.github.boros41;

import java.security.SecureRandom;
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

	/*  Returns true x% of the time, where x is the parameter. Uses x/1000 concept to allow for percentages up to the tenth place.
        To allow for a 7.5% chance, 7.5 is multiplied by 10 for 75 which means that any number generated from [0-1000) had a 7.5% chance of being less than 75.

        Parameter:
        percent - desired percent chance success rate, must be an integer [0,100] or a double to the tenths place [0.0,100.0]

        Returns:
        true if the random number generated is less than the given percent * 10
    */
	public static boolean isEnchantSuccessful(double percent)
			throws IllegalArgumentException {
		if (percent < 0 || percent > 100) {
			throw new IllegalArgumentException("Percentage must be an integer [0,100] or a double to the tenths place [0.0,100.0] ");
		}
		final int BOUND = 1000;
		final int AMPLIFIER = 10;
		final double NUMERATOR = percent * AMPLIFIER;

		SecureRandom rng = new SecureRandom();
		int randomNumber = rng.nextInt(BOUND); // 0-999

		return randomNumber < NUMERATOR;
	}
}