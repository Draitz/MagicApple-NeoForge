package de.draitz.magicapple.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FlightEffect extends MobEffect {

    public FlightEffect() {
        // MobEffectCategory.BENEFICIAL = positive effect (blue background)
        super(MobEffectCategory.BENEFICIAL, 0x00CFFF); // cyan color
    }

}