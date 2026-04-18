package de.draitz.magicapple.registry;

import de.draitz.magicapple.MagicApple;
import de.draitz.magicapple.item.FlightEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, MagicApple.MODID);

    public static final DeferredHolder<MobEffect, FlightEffect> FLIGHT =
            MOB_EFFECTS.register("flight", FlightEffect::new);

    public static void register() {}
}