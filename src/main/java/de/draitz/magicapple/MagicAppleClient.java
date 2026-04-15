package de.draitz.magicapple;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = MagicApple.MODID, dist = Dist.CLIENT)
public class MagicAppleClient {

    public MagicAppleClient() {
        MagicApple.LOGGER.info("MagicApple client initialized.");
    }
}
