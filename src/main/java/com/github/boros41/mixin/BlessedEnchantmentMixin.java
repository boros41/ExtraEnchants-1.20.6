package com.github.boros41.mixin;

import com.github.boros41.ExtraEnchants;
import com.github.boros41.access.LivingEntityAccess;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class BlessedEnchantmentMixin implements LivingEntityAccess {
    @Unique
    private boolean isBlessed = false;

    @Inject(at = @At("TAIL"), method = "<init>")
    public void LivingEntity(EntityType<? extends LivingEntity> entityType, World world, CallbackInfo info) {
        this.isBlessed = false;
    }

    @Override
    public boolean isBlessed() {
        ExtraEnchants.LOGGER.info("Returning blessed " + isBlessed + " from BlessedEnchantmentMixin " + this);
        return isBlessed;
    }

    @Override
    public void setBlessed(boolean bool) {
        ExtraEnchants.LOGGER.info("Setting blessed to " + bool + " from BlessedEnchantmentMixin " + this);
        isBlessed = bool;
    }
}
