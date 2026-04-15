package de.draitz.magicapple;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

/**
 * Registers custom creative mode tabs for the Magic Apple mod.
 * Creative tabs allow grouping mod items in the creative inventory.
 */
public class ModCreativeTabs {

    /** Deferred registry for creative tabs belonging to this mod. */
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(net.minecraft.core.registries.Registries.CREATIVE_MODE_TAB, MagicApple.MODID);

    /**
     * Main creative tab for the Magic Apple mod.
     * Displays all custom apples and related items.
     */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAGICAPPLE_TAB =
            TABS.register("magicapple_tab", () -> CreativeModeTab.builder()
                    .title(Component.literal("Magic Apple"))
                    .icon(() -> new ItemStack(ModItems.BLAZE_APPLE.get()))
                    .displayItems((params, output) -> {
                        output.accept(ModItems.BLAZE_APPLE.get());
                    })
                    .build());
}


