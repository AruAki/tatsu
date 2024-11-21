package aruaki.tatsu.client.renderer.armor;

import aruaki.tatsu.Tatsu;
import aruaki.tatsu.items.Armor.TiffysHat;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public final class TiffysHatRenderer extends GeoArmorRenderer<TiffysHat> {
	public TiffysHatRenderer() {
		super(new DefaultedItemGeoModel<>(new Identifier(Tatsu.MOD_ID, "armor/tiffys_hat")));
	}
}