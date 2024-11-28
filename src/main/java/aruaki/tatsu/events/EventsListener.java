package aruaki.tatsu.events;

import aruaki.tatsu.registries.TatsuItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.*;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

public class EventsListener {
  private static final Identifier DUNGEON_CHEST_LOOT_TABLE_ID = Identifier.of("minecraft", "chests/simple_dungeon");
  public static void initialize() {
    
    LootTableEvents.MODIFY.register((resourceManager, lootManager, id, supplier, setter) -> {
      if (setter.isBuiltin() && DUNGEON_CHEST_LOOT_TABLE_ID.equals(id)) {
        // Modify the loot table here
        LootPool.Builder poolBuilder = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1f))
                .conditionally(RandomChanceLootCondition.builder(0.05f))
                .with(ItemEntry.builder(TatsuItems.AURELAZURE).build());
                // .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f,1f)).build()); // If you want to add the chance to get more than 1 item
        
        supplier.pool(poolBuilder);
      }
    });
  }
}
