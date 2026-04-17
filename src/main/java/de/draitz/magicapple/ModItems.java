package de.draitz.magicapple;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

/**
 * Holds all item registrations for the Magic Apple mod.
 * Items are registered using NeoForge's DeferredRegister system,
 * which ensures safe and ordered registration during the mod loading phase.
 */

public class ModItems {

    /**
     * Food properties for the Blaze Apple.
     * Defines hunger restoration, saturation, and whether the item can be eaten at full hunger.
     */
    private static final FoodProperties MAGIC_FOOD = new FoodProperties.Builder()
            .nutrition(4)            // Amount of hunger restored
            .saturationModifier(0.3f)     // Saturation modifier applied after eating
            .alwaysEdible()             // Allows eating even when the player is at full hunger
            .build();

    /**
     * Registers the Blaze Apple as a simple item.
     * The item uses the food properties defined above, making it edible.
     *
     * The DeferredItem acts as a safe reference to the item,
     * resolving only after the registry has been fully initialized.
     */
    // --- Ascension Apple ---
    public static final DeferredItem<Item> ASCENSION_APPLE =
            MagicApple.ITEMS.registerItem("ascension_apple",
                    properties -> new MagicAppleItem(properties.food(MAGIC_FOOD),
                            true,   // grantFlight = true
                            3600,   // flight duration in ticks = 3 minutes
                            new MobEffectInstance(MobEffects.SLOW_FALLING, 4000, 0),
                            new MobEffectInstance(MobEffects.REGENERATION, 200, 0),
                            new MobEffectInstance(MobEffects.GLOWING, 100, 0)
                    ));

    // --- Chaos Apple ---
    public static final DeferredItem<Item> CHAOS_APPLE =
            MagicApple.ITEMS.registerItem("chaos_apple",
                    properties -> new MagicAppleItem(properties.food(MAGIC_FOOD),
                            true)
            );

    // --- Berserker Apple ---
    public static final DeferredItem<Item> BERSERKER_APPLE =
            MagicApple.ITEMS.registerItem("berserker_apple",
                    properties -> new MagicAppleItem(properties.food(MAGIC_FOOD),
                            new MobEffectInstance(MobEffects.STRENGTH, 900, 1),
                            new MobEffectInstance(MobEffects.RESISTANCE, 900, 0),
                            new MobEffectInstance(MobEffects.ABSORPTION, 900, 0)
                    ));

    // --- Blaze Apple ---
    public static final DeferredItem<Item> BLAZE_APPLE =
            MagicApple.ITEMS.registerItem("blaze_apple",
                    properties -> new MagicAppleItem(properties.food(MAGIC_FOOD),
                            new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2400, 0)
                    ));

    // --- Mining Apple ---
    public static final DeferredItem<Item> MINING_APPLE =
            MagicApple.ITEMS.registerItem("mining_apple",
                    properties -> new MagicAppleItem(properties.food(MAGIC_FOOD),
                            new MobEffectInstance(MobEffects.HASTE, 1200, 1),
                            new MobEffectInstance(MobEffects.LUCK, 1200, 0)
                    ));

    // --- Nightseer Apple ---
    public static final DeferredItem<Item> NIGHTSEER_APPLE =
            MagicApple.ITEMS.registerItem("nightseer_apple",
                    properties -> new MagicAppleItem(properties.food(MAGIC_FOOD),
                            new MobEffectInstance(MobEffects.NIGHT_VISION, 3600, 0)
                    ));

    // --- Omen Apple ---
    public static final DeferredItem<Item> OMEN_APPLE =
            MagicApple.ITEMS.registerItem("omen_apple",
                    properties -> new MagicAppleItem(properties.food(MAGIC_FOOD),
                            new MobEffectInstance(MobEffects.BAD_OMEN, 6000, 0)
                    ));

    // --- Phantom Apple ---
    public static final DeferredItem<Item> PHANTOM_APPLE =
            MagicApple.ITEMS.registerItem("phantom_apple",
                    properties -> new MagicAppleItem(properties.food(MAGIC_FOOD),
                            new MobEffectInstance(MobEffects.INVISIBILITY, 1200, 0)
                    ));

    // --- Speed Apple ---
    public static final DeferredItem<Item> SPEED_APPLE =
            MagicApple.ITEMS.registerItem("speed_apple",
                    properties -> new MagicAppleItem(properties.food(MAGIC_FOOD),
                            new MobEffectInstance(MobEffects.SPEED, 1200, 2)
                    ));

    // --- Tide Apple ---
    public static final DeferredItem<Item> TIDE_APPLE =
            MagicApple.ITEMS.registerItem("tide_apple",
                    properties -> new MagicAppleItem(properties.food(MAGIC_FOOD),
                            new MobEffectInstance(MobEffects.WATER_BREATHING, 2400, 0),
                            new MobEffectInstance(MobEffects.CONDUIT_POWER, 2400, 0)
                    ));


    public static void register() {}
}
