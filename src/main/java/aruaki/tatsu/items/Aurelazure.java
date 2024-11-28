package aruaki.tatsu.items;

import java.util.function.Consumer;
import java.util.function.Supplier;

import aruaki.tatsu.client.renderer.AurelazureRenderer;
import aruaki.tatsu.items.Materials.TatsuToolMaterials;
import net.minecraft.util.Formatting;
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

public final class Aurelazure extends SwordWithTooltip implements GeoItem {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

  public Aurelazure(Settings settings) {
		super(
			TatsuToolMaterials.AURELAZURE, 
			4, 
			-2.2f, 
			settings, 
			new String[] {
				"item.tatsu.aurelazure.tooltip.1",
				"item.tatsu.aurelazure.tooltip.1.1",
				"",
				"item.tatsu.aurelazure.tooltip.2"
			}, 
			Formatting.AQUA
		);

		// Register our item as server-side handled.
		// This enables both animation data syncing and server-side animation triggering
		SingletonGeoAnimatable.registerSyncedAnimatable(this);
	}

	@Override
	public void createRenderer(Consumer<Object> consumer) {
		consumer.accept(new RenderProvider() {
			private AurelazureRenderer renderer;

			@Override
			public BuiltinModelItemRenderer getCustomRenderer() {
				if (this.renderer == null)
					this.renderer = new AurelazureRenderer();

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
      state.getController().setAnimation(DefaultAnimations.IDLE);
      return PlayState.CONTINUE;
    }));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
