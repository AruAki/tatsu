package aruaki.tatsu.items;

import java.util.*;

import org.jetbrains.annotations.*;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class ItemWithTooltip extends Item {
  private final List<MutableText> tooltipTexts = new ArrayList<>();
  private final Formatting formatting;

  public ItemWithTooltip(Settings settings, String tooltip, Formatting formatting) {
    super(settings);
    this.formatting = formatting;
    this.tooltipTexts.add(Text.translatable(tooltip));
  }

  @Override
  public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
    super.appendTooltip(stack, world, tooltip, context);
    for (MutableText text : this.tooltipTexts) {
      tooltip.add(text.formatted(formatting));
    }
  }
}
