package aruaki.tatsu.items.Materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class CrowensMaterials implements ToolMaterial {
  public static final CrowensMaterials INSTANCE = new CrowensMaterials();

  @Override
  public int getDurability() {
    return 4000;
  }

  @Override
  public float getMiningSpeedMultiplier() {
    return 0;
  }

  @Override
  public float getAttackDamage() {
    return 8f;
  }

  @Override
  public int getMiningLevel() {
    return 0;
  }

  @Override
  public int getEnchantability() {
    return 16;
  }

  @Override
  public Ingredient getRepairIngredient() {
    return null;
  }
}
