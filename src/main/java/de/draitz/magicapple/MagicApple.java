package de.draitz.magicapple;

import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(MagicApple.MODID)
public class MagicApple {

    public static final String MODID = "magicapple";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MagicApple(IEventBus modEventBus, ModContainer modContainer) {
        LOGGER.info("MagicApple mod initialized.");
    }
}
