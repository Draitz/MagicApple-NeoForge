package de.draitz.magicapple.registry;

import de.draitz.magicapple.MagicApple;
import de.draitz.magicapple.item.MagicAppleItem;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = MagicApple.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        // Only run on server side
        if (player.level().isClientSide()) return;

        // Check if this player has active flight from an apple
        if (MagicAppleItem.flightEndTimes.containsKey(player.getUUID())) {
            long expireTime = MagicAppleItem.flightEndTimes.get(player.getUUID());

            if (player.level().getGameTime() >= expireTime) {
                // Flight expired - remove it
                player.getAbilities().mayfly = false;
                player.getAbilities().flying = false;
                player.onUpdateAbilities();
                player.removeEffect(ModEffects.FLIGHT);
                MagicAppleItem.flightEndTimes.remove(player.getUUID());
            }
        }
    }
}