package com.github.boros41.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class GearsEnchantment extends Enchantment {
    public GearsEnchantment() {
        super(Enchantment.properties(
                ItemTags.FOOT_ARMOR_ENCHANTABLE,
                2,
                3,
                Enchantment.constantCost(20),
                Enchantment.constantCost(30),
                50,
                EquipmentSlot.FEET
        ));
    }

    // called when Minecraft needs to display the name of the enchantment such as when hovering a sword with the enchantment
    @Override
    public Text getName(int level) {
        // the text to be displayed when needed and can be formatted with custom colors
        MutableText mutableText = Text.translatable(this.getTranslationKey());

        mutableText.formatted(Formatting.GOLD);

        // displays roman numeral enchantment level after enchantment name
        return mutableText.append(ScreenTexts.SPACE).append(Text.translatable("enchantment.level." + level));
    }

    @Override
    public String toString() {
        return "Gears 1-3";
    }
}
