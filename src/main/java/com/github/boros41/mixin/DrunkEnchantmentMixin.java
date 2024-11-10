package com.github.boros41.mixin;

import com.github.boros41.ExtraEnchants;
import com.github.boros41.ExtraEnchantsRegistries;
import com.github.boros41.access.LivingEntityAccess;
import com.github.boros41.enchantments.BlessedEnchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class DrunkEnchantmentMixin {
    // method is called every tick
    @Inject(at = @At("TAIL"), method = "tick()V")
    public void init(CallbackInfo info) {
        LivingEntity wearer = (LivingEntity) (Object) this;
        int enchantmentLevel = EnchantmentHelper.getEquipmentLevel(ExtraEnchantsRegistries.DRUNK_ENCHANTMENT, wearer);
        LivingEntityAccess livingEntityAccess = (LivingEntityAccess) wearer;

        switch (enchantmentLevel) {
            case 1:
                if (!BlessedEnchantment.isBlessed()) {
                    wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 0, 0));
                    wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 0, 0));
                }
                livingEntityAccess.setBlessed(true);
                wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 0, 0));
                break;
            case 2:
                if (!BlessedEnchantment.isBlessed()) {
                    wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 0, 1));
                    wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 0, 1));
                }
                livingEntityAccess.setBlessed(true);
                wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 0, 1));
                break;
            case 3:
                if (!BlessedEnchantment.isBlessed()) {
                    wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 0, 2));
                    wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 0, 2));
                }
                livingEntityAccess.setBlessed(true);
                wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 0, 2));
                break;
            case 4:
                if (!BlessedEnchantment.isBlessed()) {
                    wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 0, 3));
                    wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 0, 3));
                    ExtraEnchants.LOGGER.info("Not Blessed! Adding: " + StatusEffects.SLOWNESS + "for " + wearer);
                    ExtraEnchants.LOGGER.info("Not Blessed! Adding: " + StatusEffects.MINING_FATIGUE + "for " + wearer);
                }
                livingEntityAccess.setBlessed(true);
                wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 0, 3));
                break;
            default:
                BlessedEnchantment.setBlessed(false);
                livingEntityAccess.setBlessed(false);
                ExtraEnchants.LOGGER.info("No Drunk equipped. Setting blessed to false for " + wearer);
                break;
        }
    }
}