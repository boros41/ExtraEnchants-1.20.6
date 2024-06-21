package com.github.boros41;

import com.github.boros41.scrolls.StrengthScroll;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtraEnchants implements ModInitializer {
	public static final String MOD_ID = "extra-enchants";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Registering Mod Items for " + MOD_ID);

		// register strength_scroll item in the ingredients creative tab after the enchanted books
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> content.addAfter(Items.ENCHANTED_BOOK, StrengthScroll.STRENGTH_SCROLL));
		LOGGER.info("Successfully registered " + StrengthScroll.STRENGTH_SCROLL + " to creative ingredients tab");
	}
}