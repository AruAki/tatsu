package aruaki.tatsu.client.renderer;

import aruaki.tatsu.Tatsu;
import aruaki.tatsu.items.CrowensBlade;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class CrowensBladeRenderer extends GeoItemRenderer<CrowensBlade> {
  public CrowensBladeRenderer() {
    super(new DefaultedItemGeoModel<>(new Identifier(Tatsu.MOD_ID, "crowens_blade")));
  }
}
