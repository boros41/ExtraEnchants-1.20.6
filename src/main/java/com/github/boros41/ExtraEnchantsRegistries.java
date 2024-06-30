package com.github.boros41;

import com.github.boros41.enchantments.*;
import com.github.boros41.scrolls.StrengthScroll;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ExtraEnchantsRegistries {
    public static final Item STRENGTH_SCROLL =
            Registry.register(
                    Registries.ITEM,
                    new Identifier(ExtraEnchants.MOD_ID, "strength_scroll"),
                    new StrengthScroll(new Item.Settings()));
    public static final Enchantment ICE_ASPECT_ENCHANTMENT =
            Registry.register(
                    Registries.ENCHANTMENT,
                    new Identifier("extra-enchants","ice_aspect_enchantment"),
                    new IceAspectEnchantment()
            );
    public static final Enchantment GEARS_ENCHANTMENT =
            Registry.register(
                    Registries.ENCHANTMENT,
                    new Identifier("extra-enchants","gears_enchantment"),
                    new GearsEnchantment()
            );
    public static final Enchantment OBSIDIANSHIELD_ENCHANTMENT =
            Registry.register(
                    Registries.ENCHANTMENT,
                    new Identifier("extra-enchants","obsidianshield_enchantment"),
                    new ObsidianshieldEnchantment()
            );
    public static final Enchantment DRUNK_ENCHANTMENT =
            Registry.register(
                    Registries.ENCHANTMENT,
                    new Identifier("extra-enchants","drunk_enchantment"),
                    new DrunkEnchantment()
            );
    public static final Enchantment OVERLOAD_ENCHANTMENT =
            Registry.register(
                    Registries.ENCHANTMENT,
                    new Identifier("extra-enchants","overload_enchantment"),
                    new OverloadEnchantment()
            );
    public static final Enchantment BLESSED_ENCHANTMENT =
            Registry.register(
                    Registries.ENCHANTMENT,
                    new Identifier("extra-enchants","blessed_enchantment"),
                    new BlessedEnchantment()
            );

    public static void registerMod() {
        ExtraEnchants.LOGGER.info("Registering all mods for " + ExtraEnchants.MOD_ID);

        // register strength_scroll item in the ingredients creative tab after the enchanted books
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> content.addAfter(Items.ENCHANTED_BOOK, STRENGTH_SCROLL));
        ExtraEnchants.LOGGER.info("Successfully registered " + STRENGTH_SCROLL + " to creative ingredients tab");

        ExtraEnchants.LOGGER.info("Successfully registered " + ICE_ASPECT_ENCHANTMENT);
        ExtraEnchants.LOGGER.info("Successfully registered " + GEARS_ENCHANTMENT);
        ExtraEnchants.LOGGER.info("Successfully registered " + OBSIDIANSHIELD_ENCHANTMENT);
        ExtraEnchants.LOGGER.info("Successfully registered " + DRUNK_ENCHANTMENT);
        ExtraEnchants.LOGGER.info("Successfully registered " + OVERLOAD_ENCHANTMENT);
        ExtraEnchants.LOGGER.info("Successfully registered " + BLESSED_ENCHANTMENT);
    }
}
