package aruaki.tatsu.registries;

import aruaki.tatsu.Tatsu;
import aruaki.tatsu.items.*;
import aruaki.tatsu.items.Armor.TiffysHat;
import net.fabricmc.fabric.api.itemgroup.v1.*;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier; 

public class TatsuItems {    
  public static Item register(Item item, String id) {
    // Create an identifier for the item
    Identifier itemID = Identifier.of(Tatsu.MOD_ID, id);

    // Register the item.
    Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

    // Return the registered item.
    return registeredItem;
  }

  public static final Item STRANGE_TABLET = register(new ItemWithTooltip(new Item.Settings().maxCount(1), "item.tatsu.strange_tablet.tooltip", Formatting.DARK_PURPLE), "strange_tablet");
  public static final Item TIFFYS_HAT = registerAnimatedItem("tiffys_hat", new TiffysHat(ArmorMaterials.LEATHER, ArmorItem.Type.HELMET, new Item.Settings()));
  
  public static final Item BLOOD_DIAMOND = register(new ItemWithTooltip(new Item.Settings(), "item.tatsu.blood_diamond.tooltip", Formatting.RED), "blood_diamond");
  public static final Item CROWENS_HILT = register(new Item(new Item.Settings().maxCount(1)), "crowens_hilt");
  public static final Item CROWENS_CROSSGUARD_PART = register(new Item(new Item.Settings().maxCount(4)), "crowens_crossguard_part");
  public static final Item CROWENS_CROSSGUARD = register(new Item(new Item.Settings().maxCount(1)), "crowens_crossguard");
  public static final Item CROWENS_BLADE_TOP = register(new Item(new Item.Settings().maxCount(1)), "crowens_blade_top");
  public static final Item CROWENS_BLADE_MIDDLE = register(new Item(new Item.Settings().maxCount(1)), "crowens_blade_middle");
  public static final Item CROWENS_BLADE_BOTTOM = register(new Item(new Item.Settings().maxCount(1)), "crowens_blade_bottom");
  public static final Item CROWENS_BLADE_FULL = register(new Item(new Item.Settings().maxCount(1)), "crowens_blade_full");
  public static final Item CROWENS_BLADE = registerAnimatedItem("crowens_blade", new CrowensBlade(new Item.Settings()));
  
  public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Tatsu.MOD_ID, "item_group"));
  public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
    .icon(() -> new ItemStack(TatsuItems.STRANGE_TABLET))
    .displayName(Text.translatable("itemGroup.tatsu"))
    .build();
  public static void initialize() {
    Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);
    ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
      itemGroup.add(TatsuItems.STRANGE_TABLET);
      itemGroup.add(TatsuItems.TIFFYS_HAT);
      itemGroup.add(TatsuItems.BLOOD_DIAMOND);
      itemGroup.add(TatsuItems.CROWENS_HILT);
      itemGroup.add(TatsuItems.CROWENS_CROSSGUARD_PART);
      itemGroup.add(TatsuItems.CROWENS_CROSSGUARD);
      itemGroup.add(TatsuItems.CROWENS_BLADE_TOP);
      itemGroup.add(TatsuItems.CROWENS_BLADE_MIDDLE);
      itemGroup.add(TatsuItems.CROWENS_BLADE_BOTTOM);
      itemGroup.add(TatsuItems.CROWENS_BLADE_FULL);
      itemGroup.add(TatsuItems.CROWENS_BLADE);
    });
  }

  public static <I extends Item> I registerAnimatedItem(String name, I item) {
    return Registry.register(Registries.ITEM, new Identifier(Tatsu.MOD_ID, name), item);
  }
}
