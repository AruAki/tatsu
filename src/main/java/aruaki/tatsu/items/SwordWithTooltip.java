package aruaki.tatsu.items;

import java.util.*;

import org.jetbrains.annotations.*;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class SwordWithTooltip extends SwordItem {
  private final List<MutableText> tooltipTexts = new ArrayList<>();
  private final Formatting formatting;

  public SwordWithTooltip(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, String tooltip, Formatting formatting) {
    super(toolMaterial, attackDamage, attackSpeed, settings);
    this.formatting = formatting;
    this.tooltipTexts.add(Text.translatable(tooltip));
  }
  public SwordWithTooltip(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, String[] tooltips, Formatting formatting) {
    super(toolMaterial, attackDamage, attackSpeed, settings);
    this.formatting = formatting;
    Arrays.stream(tooltips).map(Text::translatable).forEach(this.tooltipTexts::add);
  }

  @Override
  public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
    super.appendTooltip(stack, world, tooltip, context);
    for (MutableText text : this.tooltipTexts) {
      tooltip.add(text.formatted(formatting));
    }
  }
}
