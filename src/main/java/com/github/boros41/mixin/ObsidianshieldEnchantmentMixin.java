package com.github.boros41.mixin;

import com.github.boros41.ExtraEnchantsRegistries;
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
public class ObsidianshieldEnchantmentMixin {
    // method is called every tick
    @Inject(at = @At("TAIL"), method = "tick()V")
    public void init(CallbackInfo info) {
        LivingEntity wearer = (LivingEntity) (Object) this;
        int enchantmentLevel = EnchantmentHelper.getEquipmentLevel(ExtraEnchantsRegistries.OBSIDIANSHIELD_ENCHANTMENT, wearer);

        if (enchantmentLevel == 1) {
            wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 0, 0));
        }
    }
}