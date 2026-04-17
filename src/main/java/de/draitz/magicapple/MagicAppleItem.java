package de.draitz.magicapple;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.core.Holder;

import java.util.List;

public class MagicAppleItem extends Item {

    //List of effekts to give the apples
    private final List<MobEffectInstance> effects;

    public MagicAppleItem(Properties properties, MobEffectInstance... effects) {
        super(properties);
        this.effects = List.of(effects);
    }

    //After the Player finished eating
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack result = super.finishUsingItem(stack, level, entity);

        //Only run this on Server not on Client side
        if (!level.isClientSide() && entity instanceof Player player) {
            for (MobEffectInstance effect : effects) {
                player.addEffect(effect);
            }
        }

        return result;
    }
}
