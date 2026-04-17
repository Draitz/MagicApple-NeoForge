package de.draitz.magicapple;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.core.Holder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MagicAppleItem extends Item {

    private final List<MobEffectInstance> effects;
    private final boolean grantFlight;        //should give the apple flight?
    private final int flightDuration;   //Duration in ticks. 20ticks = 1sec
    private final boolean isChaos;  // Does this apple give random effects?

    // Stores when each player's flight expires (game time in ticks)
    public static final Map<UUID, Long> flightEndTimes = new HashMap<>();

    // Main constructor - all fields
    public MagicAppleItem(Properties properties, boolean grantFlight, int flightDuration, boolean isChaos, MobEffectInstance... effects) {
        super(properties);
        this.effects = List.of(effects);
        this.grantFlight = grantFlight;
        this.flightDuration = flightDuration;
        this.isChaos = isChaos;
    }

    // Constructor without flight, used by all normal apples
    public MagicAppleItem(Properties properties, MobEffectInstance... effects) {
        this(properties, false, 0, false, effects);
    }

    // Constructor with flight, used by Ascension Apple
    public MagicAppleItem(Properties properties, boolean grantFlight, int flightDuration, MobEffectInstance... effects) {
        this(properties, grantFlight, flightDuration, false, effects);
    }

    // Constructor for Chaos Apple
    public MagicAppleItem(Properties properties, boolean isChaos) {
        this(properties, false, 0, isChaos);
    }


    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack result = super.finishUsingItem(stack, level, entity);

        if (!level.isClientSide() && entity instanceof Player player) {
            // Normal effects
            for (MobEffectInstance effect : effects) {
                player.addEffect(effect);
            }

            // Flight logic
            if (grantFlight) {
                player.getAbilities().mayfly = true;
                player.getAbilities().flying = true;
                player.onUpdateAbilities();
                long expireTime = level.getGameTime() + flightDuration;
                flightEndTimes.put(player.getUUID(), expireTime);
            }

            // Chaos logic
            if (isChaos) {
                applyChaosEffects(player, 3, 5, 5, false);
            }
        }

        return result;
    }

    // Pool of possible chaos effects
    private static final List<MobEffectInstance> CHAOS_POOL = List.of(
            new MobEffectInstance(MobEffects.SPEED, 400, 0),
            new MobEffectInstance(MobEffects.STRENGTH, 400, 0),
            new MobEffectInstance(MobEffects.REGENERATION, 200, 0),
            new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0),
            new MobEffectInstance(MobEffects.WATER_BREATHING, 400, 0),
            new MobEffectInstance(MobEffects.JUMP_BOOST, 400, 0),
            new MobEffectInstance(MobEffects.HASTE, 400, 0),
            new MobEffectInstance(MobEffects.ABSORPTION, 400, 0),
            // Negative effects
            new MobEffectInstance(MobEffects.POISON, 200, 0),
            new MobEffectInstance(MobEffects.WEAKNESS, 400, 0),
            new MobEffectInstance(MobEffects.SLOWNESS, 400, 0),
            new MobEffectInstance(MobEffects.BLINDNESS, 200, 0),
            new MobEffectInstance(MobEffects.HUNGER, 300, 0),
            new MobEffectInstance(MobEffects.LEVITATION, 100, 0),
            new MobEffectInstance(MobEffects.WITHER, 200, 0)
    );

    protected static void applyChaosEffects(Player player, int min, int max,
                                            int durationMultiplier, boolean allowLevelTwo) {
        // Pick random number of effects between min and max
        int count = min + player.level().getRandom().nextInt(max - min + 1);
        //logger für überprüfung der ausgabe
        MagicApple.LOGGER.info("Chaos Apple: giving {} effects", count);

        // Shuffle a copy of the pool so we dont pick the same effect twice
        List<MobEffectInstance> pool = new java.util.ArrayList<>(CHAOS_POOL);
        java.util.Collections.shuffle(pool, new java.util.Random(player.level().getGameTime()));
        //java.util.Collections.shuffle(pool, new java.util.Random());

        for (int i = 0; i < count && i < pool.size(); i++) {
            MobEffectInstance original = pool.get(i);

            // Charged version can give level II effects randomly
            int amplifier = original.getAmplifier();
            if (allowLevelTwo && player.level().getRandom().nextFloat() < 0.3f) {
                amplifier = 1; // 30% chance for level II
            }

            player.addEffect(new MobEffectInstance(
                    original.getEffect(),
                    original.getDuration() * durationMultiplier,
                    amplifier
            ));
        }
    }
}
