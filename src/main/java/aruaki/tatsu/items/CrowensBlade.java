package aruaki.tatsu.items;

import java.util.function.Consumer;
import java.util.function.Supplier;

import aruaki.tatsu.client.renderer.CrowensBladeRenderer;
import aruaki.tatsu.items.Materials.TatsuToolMaterials;
import net.minecraft.item.SwordItem;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public final class CrowensBlade extends SwordItem implements GeoItem {
  // private static final RawAnimation ACTIVATE_ANIM = RawAnimation.begin().thenPlay("use.activate");
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

  public CrowensBlade(Settings settings) {
		super(TatsuToolMaterials.CROWENS_BLADE, 5, -3f, settings);

		// Register our item as server-side handled.
		// This enables both animation data syncing and server-side animation triggering
		SingletonGeoAnimatable.registerSyncedAnimatable(this);
	}

  // Utilise our own render hook to define our custom renderer
	@Override
	public void createRenderer(Consumer<Object> consumer) {
		consumer.accept(new RenderProvider() {
			private CrowensBladeRenderer renderer;

			@Override
			public BuiltinModelItemRenderer getCustomRenderer() {
				if (this.renderer == null)
					this.renderer = new CrowensBladeRenderer();

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
