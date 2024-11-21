package aruaki.tatsu.items.Armor;

import java.util.function.Consumer;
import java.util.function.Supplier;

import aruaki.tatsu.client.renderer.armor.TiffysHatRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

public final class TiffysHat extends ArmorItem implements GeoItem {
  private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
  private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

  public TiffysHat(ArmorMaterial armorMaterial, ArmorItem.Type type, Settings settings) {
    super(armorMaterial, type, settings);
  }

  // Create our armor model/renderer for Fabric and return it
  @Override
  public void createRenderer(Consumer<Object> consumer) {
    consumer.accept(new RenderProvider() {
      private GeoArmorRenderer<?> renderer;

      @SuppressWarnings("unchecked")
      @Override
      public BipedEntityModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, BipedEntityModel<LivingEntity> original) {
        if(this.renderer == null)
            this.renderer = new TiffysHatRenderer();

        // This prepares our GeoArmorRenderer for the current render frame.
        // These parameters may be null however, so we don't do anything further with them
        this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);

        return this.renderer;
      }
    });
  }

  @Override
  public Supplier<Object> getRenderProvider() {
    return this.renderProvider;
  }

  @Override
  public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
    controllers.add(new AnimationController<>(this, 20, state -> {
      // Apply our generic idle animation.
      state.getController().setAnimation(DefaultAnimations.IDLE);
      return PlayState.CONTINUE;
    }));
  }

  @Override
  public AnimatableInstanceCache getAnimatableInstanceCache() {
      return this.cache;
  }
}
