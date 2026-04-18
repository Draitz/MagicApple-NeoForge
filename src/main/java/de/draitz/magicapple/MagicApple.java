package de.draitz.magicapple;

import com.mojang.logging.LogUtils;
import de.draitz.magicapple.registry.ModCreativeTabs;
import de.draitz.magicapple.registry.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

/**
 * Main mod class for the Magic Apple mod.
 * This class is automatically loaded by NeoForge when the mod is detected.
 */
@Mod(MagicApple.MODID)
public class MagicApple {

    /** The unique mod identifier used for registration and resource locations. */
    public static final String MODID = "magicapple";

    /** Logger instance for debugging and informational output. */
    public static final Logger LOGGER = LogUtils.getLogger();

    /**
     * Deferred item registry for this mod.
     * All items are registered through this registry to ensure proper load order.
     */
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> TABS = ModCreativeTabs.TABS;

    /**
     * Constructor called during mod initialization.
     * Registers all deferred registries to the mod event bus.
     *
     * @param modEventBus The event bus used for mod-specific registration.
     * @param modContainer The mod container holding metadata and configuration.
     */
    public MagicApple(IEventBus modEventBus, ModContainer modContainer) {
        ITEMS.register(modEventBus);    //Register all items
        ModCreativeTabs.TABS.register(modEventBus); //Register custom creative tabs
        ModItems.register();
    }
}
