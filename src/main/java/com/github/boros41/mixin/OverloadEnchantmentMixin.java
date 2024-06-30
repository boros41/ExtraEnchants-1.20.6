package com.github.boros41.mixin;

import com.github.boros41.ExtraEnchants;
import com.github.boros41.ExtraEnchantsRegistries;
import com.github.boros41.enchantments.OverloadEnchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.jar.Attributes;

@Mixin(PlayerEntity.class)
public class OverloadEnchantmentMixin {
    // method is called every tick
    @Inject(at = @At("TAIL"), method = "tick()V")
    public void init(CallbackInfo info) {
        LivingEntity wearer = (LivingEntity) (Object) this;
        int enchantmentLevel = EnchantmentHelper.getEquipmentLevel(ExtraEnchantsRegistries.OVERLOAD_ENCHANTMENT, wearer);
        EntityAttributeInstance entityAttributeInstance = wearer.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);

        // code resembles how SoulSpeedEnchantment is applied and removed

            // check if wearer has overload enchantment modifier or not to see if we need to apply or remove it
            if (entityAttributeInstance.getModifier(OverloadEnchantment.OVERLORD_ENCHANTMENT_ID) == null) {
                // wearer did not have overload enchantment modifier so check level and apply it accordingly
                switch (enchantmentLevel) {
                    case 1:
                        entityAttributeInstance.addTemporaryModifier(
                                new EntityAttributeModifier( // extra hearts = value/2
                                        OverloadEnchantment.OVERLORD_ENCHANTMENT_ID, "Overload health boost", 4, EntityAttributeModifier.Operation.ADD_VALUE
                                )
                        );
                        break;
                    case 2:
                        entityAttributeInstance.addTemporaryModifier(
                                new EntityAttributeModifier( // extra hearts = value/2
                                        OverloadEnchantment.OVERLORD_ENCHANTMENT_ID, "Overload health boost", 8, EntityAttributeModifier.Operation.ADD_VALUE
                                )
                        );
                        break;
                    case 3:
                        entityAttributeInstance.addTemporaryModifier(
                                new EntityAttributeModifier( // extra hearts = value/2
                                        OverloadEnchantment.OVERLORD_ENCHANTMENT_ID, "Overload health boost", 12, EntityAttributeModifier.Operation.ADD_VALUE
                                )
                        );
                        break;
                }
            } else if (enchantmentLevel != 1 && enchantmentLevel != 2 && enchantmentLevel != 3) {
                // wearer did have overload enchantment modifier but did not have the enchantment equipped so remove the modifier effect
                entityAttributeInstance.removeModifier(OverloadEnchantment.OVERLORD_ENCHANTMENT_ID);
            }
        }
    }


