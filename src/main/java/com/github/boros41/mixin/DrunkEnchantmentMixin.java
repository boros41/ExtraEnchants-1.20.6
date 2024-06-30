package com.github.boros41.mixin;

import com.github.boros41.ExtraEnchantsRegistries;
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


        switch (enchantmentLevel) {
            case 1:
                if (!BlessedEnchantment.isDrunkBlessed) {
                    wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 0, 0));
                    wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 0, 0));
                }
                wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 0, 0));
                break;
            case 2:
                if (!BlessedEnchantment.isDrunkBlessed) {
                    wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 0, 1));
                    wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 0, 1));
                }
                wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 0, 1));
                break;
            case 3:
                if (!BlessedEnchantment.isDrunkBlessed) {
                    wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 0, 2));
                    wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 0, 2));
                }
                wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 0, 2));
                break;
            case 4:
                if (!BlessedEnchantment.isDrunkBlessed) {
                    wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 0, 3));
                    wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 0, 3));
                }
                wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 0, 3));
                break;
            default:
                BlessedEnchantment.isDrunkBlessed = false; // user took off drunk helmet
        }
    }
}