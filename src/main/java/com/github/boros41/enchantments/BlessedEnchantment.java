package com.github.boros41.enchantments;

import com.github.boros41.ExtraEnchants;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.*;

public class BlessedEnchantment extends Enchantment {
    public static boolean isDrunkBlessed;

    public BlessedEnchantment() {
        super(Enchantment.properties(
                ItemTags.AXES,
                5,
                4,
                Enchantment.constantCost(20),
                Enchantment.constantCost(30),
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
        Collection<StatusEffectInstance> statusEffectInstances = user.getStatusEffects();
        List<StatusEffectInstance> harmfulEffects = statusEffectInstances.stream()
                                                                         .filter(statusEffectInstance -> statusEffectInstance.getEffectType()
                                                                                                                             .value()
                                                                                                                             .getCategory()
                                                                                                                             .equals(StatusEffectCategory.HARMFUL))
                                                                                                                             .toList();

        ExtraEnchants.LOGGER.info(harmfulEffects.toString());


        for (StatusEffectInstance harmfulEffect : harmfulEffects) {
            user.removeStatusEffect(harmfulEffect.getEffectType());
        }

        isDrunkBlessed = true; // remove debuffs from drunk enchantment to not potentially conflict with other debuffed enchantments
    }

    // called when Minecraft needs to display the name of the enchantment such as when hovering a sword with the enchantment
    @Override
    public Text getName(int level) {
        /*  the text to be displayed when needed and can be formatted with custom colors
            translation key is "enchantment.extra-enchants.ice_aspect_enchantment" */
        MutableText mutableText = Text.translatable(this.getTranslationKey());

        mutableText.formatted(Formatting.YELLOW);

        // displays roman numeral enchantment level after enchantment name
        return mutableText.append(ScreenTexts.SPACE).append(Text.translatable("enchantment.level." + level));
    }

    @Override
    public String toString() {
        return "Blessed 1-4";
    }
}
