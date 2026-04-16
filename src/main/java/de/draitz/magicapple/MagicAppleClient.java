/*package de.draitz.magicapple;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterItemDecorationsEvent;
import net.neoforged.neoforge.client.event.RegisterItemModelsEvent;

@Mod(value = MagicApple.MODID, dist = Dist.CLIENT)
public class MagicAppleClient {

    public MagicAppleClient(IEventBus modEventBus) {
        modEventBus.addListener(this::registerItemModels);
    }

    private void registerItemModels(RegisterItemModelsEvent event) {
        event.register(
                ModItems.BLAZE_APPLE.get(),
                // Sagt dem Spiel: nimm die blaze_apple.json als Modell
                new net.minecraft.client.renderer.item.BlockStateWrapper(/* ... */