package de.draitz.magicapple.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import java.util.List;

public class AddItemModifier extends LootModifier {

    // Codec-Aufbau exakt nach NeoForge-Docs
    public static final MapCodec<AddItemModifier> CODEC = RecordCodecBuilder.mapCodec(inst ->
            LootModifier.codecStart(inst)
                    .and(
                            BuiltInRegistries.ITEM.byNameCodec()
                                    .listOf()
                                    .fieldOf("items")
                                    .forGetter(m -> m.items)
                    )
                    .apply(inst, AddItemModifier::new)
    );


    private final List<Item> items;

    public AddItemModifier(LootItemCondition[] conditions, List<Item> items) {
        super(conditions);
        this.items = items;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(
            ObjectArrayList<ItemStack> generatedLoot,
            LootContext context) {
        // Vanilla-Drops bleiben — wir fügen nur hinzu
        for (Item item : items) {
            generatedLoot.add(new ItemStack(item));
        }
        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}