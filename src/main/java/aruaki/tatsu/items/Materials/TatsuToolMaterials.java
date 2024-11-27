package aruaki.tatsu.items.Materials;

import java.util.function.Supplier;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class TatsuToolMaterials implements ToolMaterial {
  public static final TatsuToolMaterials CROWENS_BLADE = new TatsuToolMaterials(4000, 8, 0, 0, 16, null);

  private final int durability;
  private final int attackDamage;
  private final float miningSpeed;
  private final int miningLevel;
  private final int enchantability;
  private final Supplier<Ingredient> repairIngredient;

  TatsuToolMaterials(int durability, int attackDamage, float miningSpeed, int miningLevel, int enchantability, Supplier<Ingredient> repairIngredient) {
    this.durability = durability;
    this.attackDamage = attackDamage;
    this.miningSpeed = miningSpeed;
    this.miningLevel = miningLevel;
    this.enchantability = enchantability;
    this.repairIngredient = repairIngredient;
  }

  @Override
  public int getDurability() {
    return this.durability;
  }

  @Override
  public float getAttackDamage() {
    return this.attackDamage;
  }

  @Override
  public float getMiningSpeedMultiplier() {
    return this.miningSpeed;
  }

  @Override
  public int getMiningLevel() {
    return this.miningLevel;
  }

  @Override
  public int getEnchantability() {
    return this.enchantability;
  }

  @Override
  public Ingredient getRepairIngredient() {
    return this.repairIngredient.get();
  }
}
