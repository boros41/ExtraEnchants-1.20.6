package com.github.boros41.enchantments;

import com.github.boros41.ExtraEnchants;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class IceAspectEnchantment extends Enchantment {
    public IceAspectEnchantment() {
        super(Enchantment.properties(
                ItemTags.SWORD_ENCHANTABLE,
                5, // lower weight = rarer
                3, // max level
                Enchantment.constantCost(20), // minimum enchanting table power level (bookshelves) required to see the enchantment in the table
                Enchantment.constantCost(30), // maximum enchanting table power level (bookshelves) required to see the enchantment in the table
                /*  Anvil cost/multiplier from item. Thus, multiplier from enchanted book would be half so 25.
                    Total cost = multiplier * level (excluding penalties and damage)
                    https://minecraft.fandom.com/wiki/Anvil_mechanics#Combining_items */
                50,
                EquipmentSlot.MAINHAND
        ));
    }

    // cannot be obtained from an enchanting table
    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        final double[] PERCENT_CHANCES = {5, 7.5, 10};
        final double percent = PERCENT_CHANCES[level - 1];

        if (target instanceof LivingEntity && ExtraEnchants.isEnchantSuccessful(percent)) {
            // amplifier is one less than the displayed level of effect
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, level * ExtraEnchants.ONE_SECOND, level - 1));
        }
    }

    // called when Minecraft needs to display the name of the enchantment such as when hovering a sword with the enchantment
    @Override
    public Text getName(int level) {
        /*  the text to be displayed when needed and can be formatted with custom colors
            translation key is "enchantment.extra-enchants.ice_aspect_enchantment" */
        MutableText mutableText = Text.translatable(this.getTranslationKey());

        // AQUA = rare enchant
        mutableText.formatted(Formatting.AQUA);

        // displays roman numeral enchantment level after enchantment name
        return mutableText.append(ScreenTexts.SPACE).append(Text.translatable("enchantment.level." + level));
    }

    @Override
    public String toString() {
        return "Ice Aspect Enchantment 1-3";
    }
}
