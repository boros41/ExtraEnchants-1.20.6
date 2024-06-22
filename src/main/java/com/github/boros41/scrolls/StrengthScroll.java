package com.github.boros41.scrolls;

import com.github.boros41.ExtraEnchants;
import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.text.Text;

import java.util.List;

public class StrengthScroll extends Item {
    public static final Item STRENGTH_SCROLL =
            Registry.register(
                    Registries.ITEM,
                    new Identifier(ExtraEnchants.MOD_ID, "strength_scroll"),
                    new StrengthScroll(new Item.Settings()));

    public StrengthScroll(Item.Settings settings) {
        super (settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH, 1.0F, 1.0F);
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1000, 3)); // strength 4 for 50 seconds
        ExtraEnchants.LOGGER.info("Successfully applied strength status effect to " + user);

        // strength scroll was used so remove one from the player's item stack and consume it
        ItemStack itemStack = user.getStackInHand(hand);
        itemStack.decrement(1);
        return TypedActionResult.consume(itemStack);
    }

    // https://fabricmc.net/wiki/tutorial:tooltip
    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.extra-enchants.strength_scroll.tooltip"));
    }

    @Override
    public String toString() {
        return "Strength Scroll";
    }
}
