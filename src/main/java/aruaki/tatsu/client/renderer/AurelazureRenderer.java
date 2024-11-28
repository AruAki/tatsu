package aruaki.tatsu.client.renderer;

import aruaki.tatsu.Tatsu;
import aruaki.tatsu.items.Aurelazure;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AurelazureRenderer extends GeoItemRenderer<Aurelazure> {
  public AurelazureRenderer() {
    super(new DefaultedItemGeoModel<>(new Identifier(Tatsu.MOD_ID, "aurelazure")));
  }
}
