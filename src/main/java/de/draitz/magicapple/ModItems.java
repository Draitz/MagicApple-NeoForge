package de.draitz.magicapple;

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
    private static final FoodProperties ALL_APPLE_FOOD = new FoodProperties.Builder()
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
    public static final DeferredItem<Item> ASCENSION_APPLE =
            MagicApple.ITEMS.registerItem(
                    "ascension_apple",
                    properties -> new Item(properties.food(ALL_APPLE_FOOD))
            );

    public static final DeferredItem<Item> BERSERKER_APPLE =
            MagicApple.ITEMS.registerItem(
                    "berserker_apple",
                    properties -> new Item(properties.food(ALL_APPLE_FOOD))
            );

    public static final DeferredItem<Item> BLAZE_APPLE =
            MagicApple.ITEMS.registerItem(
                    "blaze_apple",
                    properties -> new Item(properties.food(ALL_APPLE_FOOD))
            );

    public static final DeferredItem<Item> CHAOS_APPLE =
            MagicApple.ITEMS.registerItem(
                    "chaos_apple",
                    properties -> new Item(properties.food(ALL_APPLE_FOOD))
            );

    public static final DeferredItem<Item> MINING_APPLE =
            MagicApple.ITEMS.registerItem(
                    "mining_apple",
                    properties -> new Item(properties.food(ALL_APPLE_FOOD))
            );

    public static final DeferredItem<Item> NIGHTSEER_APPLE =
            MagicApple.ITEMS.registerItem(
                    "nightseer_apple",
                    properties -> new Item(properties.food(ALL_APPLE_FOOD))
            );

    public static final DeferredItem<Item> OMEN_APPLE =
            MagicApple.ITEMS.registerItem(
                    "omen_apple",
                    properties -> new Item(properties.food(ALL_APPLE_FOOD))
            );

    public static final DeferredItem<Item> PHANTOM_APPLE =
            MagicApple.ITEMS.registerItem(
                    "phantom_apple",
                    properties -> new Item(properties.food(ALL_APPLE_FOOD))
            );

    public static final DeferredItem<Item> SPEED_APPLE =
            MagicApple.ITEMS.registerItem(
                    "speed_apple",
                    properties -> new Item(properties.food(ALL_APPLE_FOOD))
            );

    public static final DeferredItem<Item> TIDE_APPLE =
            MagicApple.ITEMS.registerItem(
                    "tide_apple",
                    properties -> new Item(properties.food(ALL_APPLE_FOOD))
            );


    public static void register() {}
}
