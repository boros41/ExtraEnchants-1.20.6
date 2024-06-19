package com.github.boros41;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.registry.Registries;
import net.minecraft.item.Item;

public class ExtraEnchants implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "extra-enchants";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Item STRENGTH_SCROLL =
			Registry.register(
					Registries.ITEM,
					new Identifier(MOD_ID, "strength_scroll"),
					new Item(new Item.Settings()));



	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Registering Mod Items for " + MOD_ID);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> content.addAfter(Items.ENCHANTED_BOOK, STRENGTH_SCROLL));
	}
}