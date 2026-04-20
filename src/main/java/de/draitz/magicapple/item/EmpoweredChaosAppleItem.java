package de.draitz.magicapple.item;

import net.minecraft.world.item.ItemStack;

public class EmpoweredChaosAppleItem extends MagicAppleItem {

    public EmpoweredChaosAppleItem(Properties properties) {
        super(properties, false, 0, true, 3, 7, true);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
