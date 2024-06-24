package com.github.boros41.mixin;

import com.github.boros41.ExtraEnchants;
import com.github.boros41.ExtraEnchantsRegistries;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class GearsEnchantmentMixin {

	// method is called every tick
	@Inject(at = @At("TAIL"), method = "tick()V", cancellable = true)
	public void init(CallbackInfo info) {
		LivingEntity wearer = (LivingEntity) (Object) this;
		int enchantmentLevel = EnchantmentHelper.getEquipmentLevel(ExtraEnchantsRegistries.GEARS_ENCHANTMENT, wearer);

		switch (enchantmentLevel) {
			case 1:
				wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20, 0));
				break;
			case 2:
				wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20, 1));
				break;
			case 3:
				wearer.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20, 2));
				break;

		}

		/*
		if (source.getAttacker() instanceof PlayerEntity && source.getAttacker() != null) {
			ExtraEnchants.LOGGER.info("INJECTED CODE FROM MIXIN ON DEATH HELLO?");
			ExtraEnchants.LOGGER.info("Source: " + source.getSource());
			ExtraEnchants.LOGGER.info("Attacker: " + source.getAttacker());

			((PlayerEntity) source.getAttacker()).addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, StatusEffectInstance.INFINITE, 2));
		}
		 */
	}
}