package de.draitz.magicapple.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;

public class EmpoweredMagicAppleItem extends MagicAppleItem {

    // Constructor without flight
    public EmpoweredMagicAppleItem(Properties properties, MobEffectInstance... effects) {
        super(properties, false, 0, false, 0, 0, false, effects);
    }

    // Constructor with flight
    public EmpoweredMagicAppleItem(Properties properties, boolean grantFlight, int flightDuration, MobEffectInstance... effects) {
        super(properties, grantFlight, flightDuration, false, 0, 0, false, effects);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
