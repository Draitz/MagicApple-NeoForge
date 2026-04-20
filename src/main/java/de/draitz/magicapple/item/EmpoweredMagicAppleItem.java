package de.draitz.magicapple.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;

public class EmpoweredMagicAppleItem extends MagicAppleItem {

    public EmpoweredMagicAppleItem(Properties properties, MobEffectInstance... effects) {
        super(properties, effects);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
